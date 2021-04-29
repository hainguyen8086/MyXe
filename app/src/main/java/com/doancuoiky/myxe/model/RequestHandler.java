package com.doancuoiky.myxe.model;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;

import javax.net.ssl.HttpsURLConnection;


public class RequestHandler {

    String WEB_URL = "https://tdtuapps.com/mobile/doan_android/api/";

    public RequestHandler() {

    }

    public String sendQuery(String urlPath, String query, JSONObject postDataParams) throws Exception{
        System.out.println("URL = " + WEB_URL + urlPath);
        System.out.println("Param = " + query);
        URL url = new URL(WEB_URL + urlPath);     // moi
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(20000);
        conn.setConnectTimeout(20000);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json; utf-8");
        conn.setDoInput(true);
        conn.setDoOutput(true);
        OutputStream os = conn.getOutputStream();
        BufferedWriter writer = new BufferedWriter( new OutputStreamWriter(os, "UTF-8"));
        if (postDataParams == null)
            writer.write(query);
        else
            writer.write(query + encodeParams(postDataParams));
        writer.flush();
        writer.close();
        os.close();

        int responseCode = conn.getResponseCode(); // To Check for 200
        if (responseCode == HttpsURLConnection.HTTP_OK) {

            BufferedReader in=new BufferedReader( new InputStreamReader(conn.getInputStream()));
            StringBuffer sb = new StringBuffer("");
            String line="";
            while((line = in.readLine()) != null) {
                sb.append(line);
                break;
            }
            in.close();
            return sb.toString();
        }
        else
        {
            return String.valueOf(responseCode);
        }
    }

    private String encodeParams(JSONObject params) throws Exception {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        Iterator<String> itr = params.keys();
        while(itr.hasNext()){
            String key= itr.next();
            Object value = params.get(key);
            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(key, "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(value.toString(), "UTF-8"));
        }
        return result.toString();
    }
}
