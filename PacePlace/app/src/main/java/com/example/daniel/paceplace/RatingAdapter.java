package com.example.daniel.paceplace;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class RatingAdapter extends ArrayAdapter<String> {

    private Context context;
    private ArrayList<String> dataList;
    private int mSelectedPosition;

    public RatingAdapter(@NonNull Context context, ArrayList<String> dataList) {
        super(context, -1, dataList);
        this.context = context;
        this.dataList = dataList;
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = View.inflate(context, R.layout.rating_list_item, null);
            ViewHolder viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }

        final ViewHolder viewHolder = (ViewHolder) convertView.getTag();

        String[] data = dataList.get(position).split("\\|",3);
        viewHolder.mRatingView.setRating(Float.parseFloat(data[0])); // sets rating from 1st index in data array
        viewHolder.mCommentsView.setText(data[1]); // sets comment from 2nd index in data array

        return convertView;
    }

    // Sets position of clicked item in listview
    void setSelectedPosition(int position) {
        mSelectedPosition = position;
    }

    //Gets position of clicked item in listview
    int getSelectedPosition() {
        return mSelectedPosition;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public String getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    static class ViewHolder{
        RatingBar mRatingView;
        TextView mCommentsView;

        ViewHolder(View item) {
            //Add All views for an item in the view holder
             mRatingView = item.findViewById(R.id.ratingBar);
             mCommentsView = item.findViewById(R.id.commentBox);


        }

    }
}
