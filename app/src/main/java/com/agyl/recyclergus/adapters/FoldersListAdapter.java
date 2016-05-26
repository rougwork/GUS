package com.agyl.recyclergus.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.agyl.recyclergus.models.FoldersContentListViewData;
import com.agyl.recyclergus.MainActivity;
import com.agyl.recyclergus.R;

import java.util.ArrayList;

/**
 * Created by rouguiatoudiallo on 16-05-23.
 */

public class FoldersListAdapter extends BaseAdapter {

    private MainActivity activity;
    private ArrayList<FoldersContentListViewData> data;
    LayoutInflater inflater;

    public FoldersListAdapter( MainActivity activity, ArrayList<FoldersContentListViewData> data) {
        this.activity = activity;
        inflater = LayoutInflater.from(activity.getApplicationContext());
        //data = new ArrayList<SyncContentListViewData>();
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MyViewHolder mViewHolder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) activity
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.folders_item_adapter, parent, false);
            mViewHolder = new MyViewHolder(convertView);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (MyViewHolder) convertView.getTag();
        }

        FoldersContentListViewData item = (FoldersContentListViewData) getItem(position);

        mViewHolder.street.setText(item.getStreet());
        mViewHolder.firstName.setText(item.getFirstName());
        mViewHolder.lastName.setText(item.getLastName());
        mViewHolder.weatherNumber.setText(item.getWeatherNumber());
        mViewHolder.weatherText.setText(item.getWeatherText());

        return convertView;
    }

    private class MyViewHolder {
        TextView street, firstName, lastName, weatherNumber, weatherText;

        public MyViewHolder(View item) {
            street = (TextView) item.findViewById(R.id.street_text);
            firstName = (TextView) item.findViewById(R.id.first_name);
            lastName = (TextView) item.findViewById(R.id.last_name);
            weatherNumber = (TextView) item.findViewById(R.id.weather_number);
            weatherText = (TextView) item.findViewById(R.id.weather_text);
        }
    }
}
