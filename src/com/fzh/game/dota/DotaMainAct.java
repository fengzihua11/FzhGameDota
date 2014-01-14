package com.fzh.game.dota;

import java.util.ArrayList;
import com.admogo.AdMogoLayout;
import com.admogo.AdMogoListener;
import com.admogo.AdMogoManager;
import com.fzh.game.adapter.JiuGuanAdapter;
import com.fzh.game.db.DatabaseHelper;
import com.fzh.game.db.HeroBean;
import com.fzh.game.db.JiuGuanBean;
import com.fzh.game.dota.R;
import com.fzh.game.view.NumberView;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.AdapterView.OnItemSelectedListener;

public class DotaMainAct extends BaseAct implements OnItemSelectedListener,
		OnClickListener, AdMogoListener{

	private static final String TAG = "dota";
	private Gallery allJiu;
	private NumberView currentPoint;
	private JiuGuanAdapter adapter = null;

	private DatabaseHelper dbHelper;

	protected QueryDataAsyncTask qyeryTask;

	private ArrayList<JiuGuanBean> jiuGuanList = new ArrayList<JiuGuanBean>();
	
	private AdMogoLayout admogo_layout;

	private class QueryDataAsyncTask extends AsyncTask<Void, String, Void> {
		protected Void doInBackground(Void... params) {
			queryJiuGuans();
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			notifyDataChange();
		}
	};

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		makeView();
		initListener();
		initDbHelper();
		startQuery();
		showToast();
	}

	private void makeView() {
		allJiu = (Gallery) findViewById(R.id.allJiu);		
		
		adapter = new JiuGuanAdapter(this, jiuGuanList, mClicker);
		allJiu.setAdapter(adapter);
		currentPoint = (NumberView) findViewById(R.id.currentPoint);

		admogo_layout = (AdMogoLayout) findViewById(R.id.admogo_layout);
		admogo_layout.setAdMogoListener(this);
	}

	private void initListener() {
		allJiu.setOnItemSelectedListener(this);		
	}

	private void initDbHelper() {		
		dbHelper = new DatabaseHelper(this, R.raw.dota);
	}

	private void startQuery() {
		if (qyeryTask != null
				&& qyeryTask.getStatus() != QueryDataAsyncTask.Status.FINISHED) {
			qyeryTask.cancel(true);
		}
		qyeryTask = (QueryDataAsyncTask) new QueryDataAsyncTask().execute();
	}
	
	private void notifyDataChange() {
		currentPoint.setNumber(jiuGuanList.size());
		adapter.notifyDataSetChanged();
	}

	@Override
	public void onClick(View v) {		
	}
	
	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		currentPoint.setCurrentNumber(position);
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {		
	}

	private void queryJiuGuans() {
		Cursor cu = dbHelper.queryJiuGuans();
		JiuGuanBean jiuGuanBean = null;
		while (cu.moveToNext()) {
			jiuGuanBean = new JiuGuanBean();
			jiuGuanBean._id = cu.getInt(0);
			jiuGuanBean.name = cu.getString(1);
			jiuGuanBean.number = cu.getInt(2);
			jiuGuanBean.location = cu.getInt(3);
			jiuGuanBean.pic = cu.getString(4);
			
			Log.d(TAG, "queryJiuGuans()--> " + jiuGuanBean.toString());
			
			queryHeros(jiuGuanBean);
			jiuGuanList.add(jiuGuanBean);
		}
		cu.close();
		dbHelper.close();
	}
	
	private void queryHeros(JiuGuanBean jiuGuanBean) {
		Cursor cu = dbHelper.queryHeros(jiuGuanBean._id);
		HeroBean heroBean = null;
		while (cu.moveToNext()) {
			heroBean = new HeroBean();
			heroBean._id = cu.getInt(0);
			heroBean.name = cu.getString(1);
			heroBean.eName = cu.getString(2);
			heroBean.shortName = cu.getString(3);
			heroBean.charpter = cu.getInt(4);
			heroBean.jiu_id = cu.getInt(5);	
			heroBean.pic = cu.getString(6);
			heroBean.description = cu.getString(7);
			heroBean.kaijie = cu.getString(8);
			heroBean.jineng = cu.getString(9);
			heroBean.qz = cu.getString(10);
			heroBean.zz = cu.getString(11);	
			heroBean.hz = cu.getString(12);	
			heroBean.sy = cu.getString(13);	
			
			Log.d(TAG, "queryHeros() --> " + heroBean.toString());
			jiuGuanBean.addHero(heroBean);
		}
		cu.close();
	}	
	
	private OnClickListener mClicker = new OnClickListener() {
		public void onClick(View v) {
			Object o = v.getTag();
			if(o == null)
				return;
			HeroBean heroBean = (HeroBean) o;
			Log.d(TAG, heroBean.toString());	
			
			Intent intent = new Intent(DotaMainAct.this, HeroDesAct.class);
			intent.putExtra(HeroDesAct.HERO_BEAN, heroBean);
			startActivity(intent);		
		}
	};
	
	@Override
	public void onClickAd() {
		admogo_layout.setVisibility(View.GONE);
	}

	@Override
	public void onFailedReceiveAd() {
	}

	@Override
	public void onReceiveAd() {
	}

	protected void onDestroy() {
		AdMogoManager.clear();
		super.onDestroy();
		if (qyeryTask != null
				&& qyeryTask.getStatus() != AsyncTask.Status.FINISHED) {
			qyeryTask.cancel(true);
			qyeryTask = null;
		}

		if (dbHelper != null) {
			dbHelper.close();
			dbHelper = null;
		}		
	}
}