package com.fzh.game.view;

import java.util.ArrayList;
import com.fzh.game.db.HeroBean;
import com.fzh.game.db.JiuGuanBean;
import com.fzh.game.dota.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class JiuGuanFrm extends LinearLayout {

	private JiuGuanBean mItem;

	private OnClickListener mClicker;

	private ImageView jiuImg;
	private TextView jiuName;

	private ImageView[] imgs = null;
	private int[] imgIds = { R.id.hero11, R.id.hero12, R.id.hero13,
			R.id.hero14, R.id.hero21, R.id.hero22, R.id.hero23, R.id.hero24,
			R.id.hero31, R.id.hero32, R.id.hero33, R.id.hero34, R.id.hero41,
			R.id.hero42, R.id.hero43, R.id.hero44 };

	public JiuGuanFrm(Context context) {
		super(context);
		initView();
	}

	public JiuGuanFrm(Context context, AttributeSet attr) {
		super(context, attr);
		initView();
	}

	private void initView() {
		inflate(getContext(), R.layout.jiu_item, this);
		Gallery.LayoutParams params = new Gallery.LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT);
		setLayoutParams(params);
		setGravity(Gravity.CENTER_HORIZONTAL);

		jiuImg = (ImageView) findViewById(R.id.jiuImg);
		jiuName = (TextView) findViewById(R.id.jiuName);

		imgs = new ImageView[imgIds.length];
		for (int i = 0; i < imgIds.length; i++)
			imgs[i] = (ImageView) findViewById(imgIds[i]);
	}

	public void setJiuGuanData(JiuGuanBean jiuItem) {
		ArrayList<HeroBean> heroList = jiuItem.getHeros();
		int resId = getContext().getResources().getIdentifier(jiuItem.pic,
				"drawable", getContext().getPackageName());
		jiuImg.setImageResource(resId);
		jiuName.setText(jiuItem.name);
		for (int i = 0; i < heroList.size(); i++) {
			if(heroList.get(i).pic != null && !heroList.get(i).pic.equals("null")) {
				resId = getContext().getResources().getIdentifier(heroList.get(i).pic,
						"drawable", getContext().getPackageName());
				imgs[i].setImageResource(resId);
			}		
			imgs[i].setOnClickListener(mClicker);
			imgs[i].setTag(heroList.get(i));
		}
	}

	public JiuGuanBean getSubjectItemData() {
		return mItem;
	}

	public void setOnClickListener(OnClickListener clicker) {
		mClicker = clicker;
	}
}