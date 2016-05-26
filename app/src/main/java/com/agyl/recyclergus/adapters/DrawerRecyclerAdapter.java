package com.agyl.recyclergus.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.agyl.recyclergus.R;
import com.agyl.recyclergus.models.DrawerListViewData;

import java.util.ArrayList;

/**
 * Created by rouguiatoudiallo on 16-05-24.
 */

public class DrawerRecyclerAdapter extends RecyclerView.Adapter<DrawerRecyclerAdapter.DrawerViewHolder> {

    public final static int TYPE_HEADER = 0;
    public final static int TYPE_MENU = 1;


    private ArrayList<DrawerListViewData> drawerMenuList;

    private OnItemSelecteListener mListener;

    public DrawerRecyclerAdapter(ArrayList<DrawerListViewData> drawerMenuList) {
        this.drawerMenuList = drawerMenuList;
    }

    @Override
    public DrawerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if(viewType == TYPE_HEADER){

            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.drawer_header, parent, false);

        }else{

            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.drawer_listview, parent, false);
        }


        return new DrawerViewHolder(view, viewType);
    }


    @Override
    public void onBindViewHolder(DrawerViewHolder holder, int position) {
        if(position == 0) {
            //holder.headerText.setText("Header Text");
        }else{
            holder.name.setText(drawerMenuList.get(position - 1).getName());
            holder.icon.setImageResource(drawerMenuList.get(position - 1).getIconId());
        }

    }

    @Override
    public int getItemCount() {
        return drawerMenuList.size()+1;
    }



    @Override
    public int getItemViewType(int position) {

        if(position == 0){
            return  TYPE_HEADER;
        }
        return TYPE_MENU;

    }

    class DrawerViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView headerText;
        ImageView icon;

        public DrawerViewHolder(View itemView, int viewType) {
            super(itemView);


            if(viewType == 0){
                //headerText = (TextView)itemView.findViewById(R.id.headerText);
            }else {
                name = (TextView) itemView.findViewById(R.id.name);
                icon = (ImageView) itemView.findViewById(R.id.icon);
            }
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.onItemSelected(view, getAdapterPosition());

                }
            });
        }

    }




    public void setOnItemClickLister(OnItemSelecteListener mListener) {
        this.mListener = mListener;
    }

   public interface OnItemSelecteListener{
        public void onItemSelected(View v, int position);
    }

}