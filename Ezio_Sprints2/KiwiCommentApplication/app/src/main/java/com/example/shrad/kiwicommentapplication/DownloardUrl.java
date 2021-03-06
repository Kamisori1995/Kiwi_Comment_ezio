package com.example.shrad.kiwicommentapplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by shrad on 23/09/2017.
 */

public class DownloardUrl {

    public String readUrl(String myUrl) throws IOException{
        String data="";
        InputStream inputStream=null;
        HttpURLConnection urlConnection = null;
        try {
            URL url =  new URL(myUrl);
            urlConnection=  (HttpURLConnection) url.openConnection();
            urlConnection.connect();

            inputStream =urlConnection.getInputStream();
            BufferedReader br= new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer stringBuffer= new StringBuffer();

            String line="";
            while((line=br.readLine())!=null){
                stringBuffer.append(line);
            }
            data = stringBuffer.toString();
            br.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            inputStream.close();
            urlConnection.disconnect();
        }
        return data;
    }
}
