package com.doancuoiky.myxe.global;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.inputmethod.InputMethodManager;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GlobalFunction {

    public static String loginEmail;
    public static String currentID = "";

    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        if(inputMethodManager.isAcceptingText()){
            inputMethodManager.hideSoftInputFromWindow(
                    activity.getCurrentFocus().getWindowToken(),
                    0
            );
        }
    }

    public static String formatOnlyDate(Date date) {
        SimpleDateFormat simpleDate =  new SimpleDateFormat("dd/MM/yyyy");
        String strDt = simpleDate.format(date);
        return strDt;
    }

    public static void showAlert(Activity act, String str){
        act.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    AlertDialog.Builder builder = new AlertDialog.Builder(act);
                    builder.setMessage(str)
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();
                }catch (Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        });
    }
}
