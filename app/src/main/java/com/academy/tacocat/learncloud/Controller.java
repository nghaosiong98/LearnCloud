package com.academy.tacocat.learncloud;

import android.content.Context;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Controller {

    public static Documents createDocument(Context context){
        try {
            InputStream inputStream = context.getAssets().open("documents.json");
            Reader reader = new InputStreamReader(inputStream, "UTF-8");

            return new Gson().fromJson(reader, Documents.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
