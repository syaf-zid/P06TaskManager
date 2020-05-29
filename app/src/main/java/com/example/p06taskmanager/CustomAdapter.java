package com.example.p06taskmanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Task> {
    private ArrayList<Task> tasks;
    private Context context;
    private TextView tvID, tvName, tvDesc;

    public CustomAdapter(Context context, int resource, ArrayList<Task> objs){
        super(context, resource, objs);
        tasks = objs;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);

        tvID = rowView.findViewById(R.id.textViewID);
        tvName = rowView.findViewById(R.id.textViewName);
        tvDesc = rowView.findViewById(R.id.textViewDesc);

        Task currentTask = tasks.get(position);

        tvID.setText(currentTask.getId());
        tvName.setText(currentTask.getName());
        tvDesc.setText(currentTask.getDescription());

        return rowView;
    }
}
