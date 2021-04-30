package com.doancuoiky.myxe.ui.xe;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.doancuoiky.myxe.model.NetworkAPI;
import com.doancuoiky.myxe.model.Xe;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class XeViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private MutableLiveData<ArrayList<String>> mTenXe;
    private MutableLiveData<ArrayList<String>> mBienSoXe;
    public static ArrayList<String> listTenXe;
    public static ArrayList<String> listBienSoXe;

    public XeViewModel() {
        mText = new MutableLiveData<>();
        mTenXe = new MutableLiveData<>();
        mBienSoXe = new MutableLiveData<>();
        mText.setValue("danh sách xe");
        listTenXe = new ArrayList<>();
        listBienSoXe = new ArrayList<>();

        getAllItem();

        mTenXe.setValue(listTenXe);
        mBienSoXe.setValue(listBienSoXe);


    }

    private void getAllItem() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    JSONObject object = new JSONObject();
                    object.put("username", "tester");
                    object.put("password", "123456");
                    NetworkAPI networkAPI = new NetworkAPI();
                    String response = networkAPI.execute("GetAllItem", object.toString()).get();
                    System.out.println("respon ==\n"+response);
                    JSONArray jsonArray = new JSONArray(response);
//                    JSONObject jsonObject = new JSONObject(response);
                    System.out.println("jsonAraay==="+jsonArray);

                    System.out.println("Response testAPI = " + response);

                    if (jsonArray != null){
                        String tenXe = "";
                        String bienSo = "";
                        for (int i=0;i<jsonArray.length();i++){
                            try{
                                JSONObject jsonObjectfor=jsonArray.getJSONObject(i);
                                tenXe = jsonObjectfor.getString("tenXe");
                                bienSo = jsonObjectfor.getString("bienSoXe");
                                System.out.println("getJsonObject"+tenXe+"--"+bienSo);
                                listTenXe.add(tenXe);
                                listBienSoXe.add(bienSo);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    System.out.println("List Ten Xe "+listTenXe);
                    System.out.println("List Bien So Xe "+listBienSoXe);

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
}