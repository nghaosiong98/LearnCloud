package com.academy.tacocat.learncloud;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TutorialFragment extends Fragment {


    public TutorialFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tutorial, container, false);
        Documents documents = new Documents();
        try {
            InputStream inputStream = getContext().getAssets().open("documents.json");
            Reader reader = new InputStreamReader(inputStream, "UTF-8");
            documents = new Gson().fromJson(reader, Documents.class);
        }catch (IOException e){
            Log.e("GSON_ERROR", e.getMessage());
        }


        ArrayList<Dataset> datasetArrayList = new ArrayList<>(documents.section.get(0).dataset);
        Log.d("abc", documents.section.get(0).dataset.get(0).content_title);
        DocumentAdapter adapter = new DocumentAdapter(getActivity().getApplicationContext() , datasetArrayList);
        ListView listView = (ListView) view.findViewById(R.id.tutorialList);
        listView.setAdapter(adapter);


        return view;
    }

}
