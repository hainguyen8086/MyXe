package com.doancuoiky.myxe.model;

import android.os.AsyncTask;

public class NetworkAPI extends AsyncTask<String,Void,String> {

    @Override
    protected String doInBackground(String... strings) {
        try {
            RequestHandler requestHandler = new RequestHandler();
            return requestHandler.sendQuery(strings[0], strings[1], null);
            //return RequestHandler.sendQuery(strings[0], null);
        }
        catch(Exception e){
            return new String("Exception: " + e.getMessage());
        }
    }

    @Override
    protected void onPostExecute(String s) {
        if(s!=null){

        }
    }

}
