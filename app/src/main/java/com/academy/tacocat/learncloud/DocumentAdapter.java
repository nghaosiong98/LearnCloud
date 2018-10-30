package com.academy.tacocat.learncloud;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class DocumentAdapter extends ArrayAdapter<Dataset> {
    private int resourceLayout;
    private Context mContext;

    public DocumentAdapter(Context context, int resource, List<Dataset> items) {
        super(context, resource, items);
        this.resourceLayout = resource;
        this.mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_list, parent, false);
        }

        Dataset p = getItem(position);
        TextView textView = convertView.findViewById(R.id.list_text_title);
        TextView textView1 = convertView.findViewById(R.id.list_text_desc);
        textView.setText(p.content_title);
        textView1.setText(p.description);

        return convertView;
    }
}
