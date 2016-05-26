package com.agyl.recyclergus.views;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.agyl.recyclergus.models.FoldersContentListViewData;
import com.agyl.recyclergus.MainActivity;
import com.agyl.recyclergus.R;
import com.agyl.recyclergus.adapters.FoldersListAdapter;

import java.util.ArrayList;

/**
 * Created by rouguiatoudiallo on 16-05-23.
 */

public class FoldersListFragment extends ListFragment
{
	ArrayList<FoldersContentListViewData> data;
	FoldersListAdapter adapter;

	public FoldersListFragment() {
		this.data = new ArrayList<FoldersContentListViewData>();

		this.getListData();
	}


	private void getListData(){
		FoldersContentListViewData fl = new FoldersContentListViewData("175 de l'Eglise St-Augustin-de-Desmaures",
				"Nom,",
				"Prénom",
				"10039",
				"Estimation, Vent");

		data.add(fl);

		fl = new FoldersContentListViewData("175 de l'Eglise St-Augustin-de-Desmaures",
				"Nom,",
				"Prénom",
				"10039",
				"Estimation, Vent");
		data.add(fl);

		fl = new FoldersContentListViewData("175 de l'Eglise St-Augustin-de-Desmaures",
				"Nom,",
				"Prénom",
				"10039",
				"Estimation, Vent");
		data.add(fl);

		fl = new FoldersContentListViewData("175 de l'Eglise St-Augustin-de-Desmaures",
				"Nom,",
				"Prénom",
				"10039",
				"Estimation, Vent");

		fl = new FoldersContentListViewData("175 de l'Eglise St-Augustin-de-Desmaures",
				"Nom,",
				"Prénom",
				"10039",
				"Estimation, Vent");
		data.add(fl);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.folders_list_fragment, container, false);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		adapter = new FoldersListAdapter( (MainActivity) getActivity(), data );

		setListAdapter(adapter);
	}

}