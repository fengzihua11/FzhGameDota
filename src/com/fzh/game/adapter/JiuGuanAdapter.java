package com.fzh.game.adapter;

import java.util.ArrayList;
import com.fzh.game.db.JiuGuanBean;
import com.fzh.game.view.JiuGuanFrm;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.AdapterView.OnItemClickListener;

public class JiuGuanAdapter extends BaseAdapter {

	private Context mContext;
	private ArrayList<JiuGuanBean> mDataList;
	
	private OnClickListener mClicker;
	
	public JiuGuanAdapter(Context context,
			ArrayList<JiuGuanBean> dataList, OnClickListener clicker) {
		mContext = context;
		mDataList = dataList;
		mClicker = clicker;
	}

	@Override
	public int getCount() {
		return mDataList.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = new JiuGuanFrm(mContext);
		}
		((JiuGuanFrm) convertView).setOnClickListener(mClicker);
		((JiuGuanFrm) convertView).setJiuGuanData(mDataList.get(position));				
		return convertView;
	}

}