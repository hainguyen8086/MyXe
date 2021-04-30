package com.doancuoiky.myxe.ui.xe;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.doancuoiky.myxe.global.GlobalFunction;
import com.doancuoiky.myxe.model.NetworkAPI;
import com.doancuoiky.myxe.model.ViewXe;
import com.doancuoiky.myxe.model.Xe;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class XeViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    public static MutableLiveData<ArrayList<String>> mTenXe;
    public static MutableLiveData<ArrayList<String>> mBienSoXe;
    public static MutableLiveData<ArrayList<ViewXe>> viewXe;
    public static ArrayList<String> listTenXe;
    public static ArrayList<String> listBienSoXe;
    public static ArrayList<ViewXe> listViewXe;

    public XeViewModel() {
        mText = new MutableLiveData<>();
        mTenXe = new MutableLiveData<>();
        mBienSoXe = new MutableLiveData<>();
        viewXe = new MutableLiveData<>();

        mText.setValue("danh sách xe");
        listTenXe = new ArrayList<>();
        listBienSoXe = new ArrayList<>();
        listViewXe = new ArrayList<>();

        getTenAndBienSo();


    }

    private void getTenAndBienSo() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    JSONObject object = new JSONObject();
                    object.put("email", GlobalFunction.loginEmail);
//                    object.put("password", "d2");
                    NetworkAPI networkAPI = new NetworkAPI();
                    String response = networkAPI.execute("GetAllItem", object.toString()).get();
                    System.out.println("Get all item response = \n" + response);
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i=0;i<jsonArray.length();i++){
                        try {
                            JSONObject jsonObjectfor = jsonArray.getJSONObject(i);
                            String tenXe = jsonObjectfor.getString("tenXe");
                            String bienSo = jsonObjectfor.getString("bienSoXe");
                            System.out.println("getJsonObject "+tenXe+" -- "+bienSo);
                            listTenXe.add(tenXe);
                            listBienSoXe.add(bienSo);
                            listViewXe.add(new ViewXe(tenXe, bienSo));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("List Ten Xe " + listTenXe);
                    System.out.println("List Bien So Xe " + listBienSoXe);
                    System.out.println("list view xe"+listViewXe);

                    mTenXe.postValue(listTenXe);
                    mBienSoXe.postValue(listBienSoXe);
                    viewXe.postValue(listViewXe);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };
        thread.start();
    }


    public LiveData<String> getText() {
        return mText;
    }
    public LiveData<ArrayList<String>> getListTenXe(){
        return mTenXe;
    }
    public LiveData<ArrayList<String>> getListBienSoXe(){
        return mBienSoXe;
    }
    public LiveData<ArrayList<ViewXe>> getListViewXe(){
        return viewXe;
    }
}