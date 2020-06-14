package com.example.asus.top_10_downloaded_apps;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by ASUS on 6/14/2020.
 */

public class FeedAdapter extends ArrayAdapter {
    private static final String TAG = "FeedAdapter";
    private final int layoutResource;
    private final LayoutInflater layoutInflater;
    private List<FeedEntry> applications;

    public FeedAdapter(@NonNull Context context, int resource, List<FeedEntry> applications) {
        super(context, resource);
        this.layoutResource = resource;
        this.layoutInflater = LayoutInflater.from(context);
        this.applications = applications;
    }

    @Override
    public int getCount() {
        return applications.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        viewHolder viewholder;

        if (convertView==null){
            convertView=layoutInflater.inflate(layoutResource,parent,false);
            viewholder=new viewHolder(convertView);
            convertView.setTag(viewholder);
        }
        else {
            viewholder=(viewHolder) convertView.getTag();
        }


//        TextView tvName=(TextView)convertView.findViewById(R.id.tvName);
//        TextView tvArtist=(TextView)convertView.findViewById(R.id.tvArtist);
//        TextView tvSummary=(TextView)convertView.findViewById(R.id.tvSummary);

        FeedEntry currentApp=applications.get(position);

        viewholder.tvName.setText(currentApp.getName());
        viewholder.tvArtist.setText(currentApp.getArtist());
        viewholder.tvSummary.setText(currentApp.getSummary());

        return convertView;

    }

    private class viewHolder{
        final TextView tvName;
        final TextView tvArtist;
        final TextView tvSummary;

        public viewHolder(View v){
            this.tvName=(TextView)v.findViewById(R.id.tvName);
            this.tvArtist=(TextView)v.findViewById(R.id.tvArtist);
            this.tvSummary=(TextView)v.findViewById(R.id.tvSummary);
        }
    }

}


















