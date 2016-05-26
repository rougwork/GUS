package com.agyl.recyclergus.views;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.*;

import com.agyl.recyclergus.MainActivity;
import com.agyl.recyclergus.R;
import com.agyl.recyclergus.models.SyncContentListViewData;
import com.agyl.recyclergus.adapters.SyncListAdapter;

import java.util.ArrayList;

/**
 * Created by rouguiatoudiallo on 16-05-23.
 */

public class SyncListFragment extends ListFragment
{

	ArrayList<SyncContentListViewData> data;
	SyncListAdapter adapter;

	public SyncListFragment() {
		this.data = new ArrayList<SyncContentListViewData>();

		this.getListData();
	}


	private void getListData(){
		SyncContentListViewData sc = new SyncContentListViewData("DOS-00045545", "Bérubé,",
				"Jean-Philippe",
				"Photos(25 de 25)",
				R.drawable.icon_status_completed,
				0,
				"Notes(3 de 3)",
				0,
				"Formulaires (2 de 2)"
		);

		this.data.add(sc);

		sc = new SyncContentListViewData("DOS-00045545", "Dubois,",
				"Marc-Antoine",
				"Photos(22 de 25)",
				R.drawable.icon_status_incompleted,
				R.color.red,
				"Notes(0)",
				0,
				"Formulaires (2 de 2)"
		);

		this.data.add(sc);

		sc = new SyncContentListViewData("DOS-00045545", "Beauregard,",
				"Josephine",
				"Photos(25 de 25)",
				R.drawable.icon_status_completed,
				R.color.light_orange,
				"Notes(0 de 3)",
				0,
				"Formulaires (0)"
		);

		this.data.add(sc);

		sc = new SyncContentListViewData("DOS-00045545", "Tremblay,",
				"Véronique",
				"Photos(0 de 25)",
				R.drawable.icon_status_waiting,
				0,
				"Notes(0 de 3)",
				0,
				"Formulaires (0)"
		);

		this.data.add(sc);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.sync_list_fragment, container, false);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		adapter = new SyncListAdapter( (MainActivity) getActivity(), data );

		setListAdapter(adapter);
		adapter.notifyDataSetChanged();
	}

}