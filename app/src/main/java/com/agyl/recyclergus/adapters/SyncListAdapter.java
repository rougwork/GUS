package com.agyl.recyclergus.adapters;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.agyl.recyclergus.MainActivity;
import com.agyl.recyclergus.R;
import com.agyl.recyclergus.models.SyncContentListViewData;

import java.util.ArrayList;

/**
 * Created by rouguiatoudiallo on 16-05-23.
 */

public class SyncListAdapter extends BaseAdapter {

    private MainActivity activity;
    private ArrayList<SyncContentListViewData> data;
    LayoutInflater inflater;

    public SyncListAdapter( MainActivity activity, ArrayList<SyncContentListViewData> data) {
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
            convertView = inflater.inflate(R.layout.sync_item_adapter, parent, false);
            mViewHolder = new MyViewHolder(convertView);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (MyViewHolder) convertView.getTag();
        }

        SyncContentListViewData item = (SyncContentListViewData) getItem(position);

        mViewHolder.personKey.setText(item.getKey());
        mViewHolder.firstName.setText(item.getFirstName());
        mViewHolder.lastName.setText(item.getLastName());
        mViewHolder.pictureText.setText(item.getPicture());

        Log.i("GUS", " color " + item.getPictureTextColor());

        if( item.getPictureTextColor() != 0 ) {
            mViewHolder.pictureText.setTextColor(activity.getResources().getColor(item.getPictureTextColor()));
        }
        else
        {
            mViewHolder.pictureText.setTextColor( activity.getResources().getColor(R.color.gray) );
        }

        if( item.getPictureStatusIcon() != 0 ) {
            mViewHolder.pictureStatusIcon.setImageResource(item.getPictureStatusIcon());
        }

        mViewHolder.note.setText(item.getNote());

        if( item.getNoteStatusIcon() != 0 ) {
            mViewHolder.noteStatusIcon.setImageResource(item.getNoteStatusIcon());
        }

        mViewHolder.formulaire.setText(item.getFormulaire());

        return convertView;
    }

    private class MyViewHolder {
        TextView personKey, firstName, lastName, pictureText, note, formulaire;
        ImageView pictureIcon, pictureStatusIcon, noteIcon, noteStatusIcon;

        public MyViewHolder(View item) {
            personKey = (TextView) item.findViewById(R.id.person_key);
            firstName = (TextView) item.findViewById(R.id.first_name);
            lastName = (TextView) item.findViewById(R.id.last_name);
            pictureText = (TextView) item.findViewById(R.id.picture_text);
            note = (TextView) item.findViewById(R.id.note_text);
            formulaire = (TextView) item.findViewById(R.id.form_text);
            pictureIcon = (ImageView) item.findViewById(R.id.picture_icon);
            noteIcon = (ImageView) item.findViewById(R.id.note_icon);
            pictureStatusIcon = (ImageView) item.findViewById(R.id.picture_status_icon);
            noteStatusIcon = (ImageView) item.findViewById(R.id.note_status_icon);
        }
    }

}
