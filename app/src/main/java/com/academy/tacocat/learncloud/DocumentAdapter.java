package com.academy.tacocat.learncloud;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class DocumentAdapter extends ArrayAdapter<Dataset> {

    public DocumentAdapter(Context context, List<Dataset> datasets) {
        super(context, 0, datasets);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.tutorial_list, parent, false);
        }

        Dataset dataset = getItem(position);
        TextView content_title = convertView.findViewById(R.id.content_title);
        TextView description = convertView.findViewById(R.id.description);
        content_title.setText(dataset.content_title);
        description.setText(dataset.description);

        return convertView;
    }
}
