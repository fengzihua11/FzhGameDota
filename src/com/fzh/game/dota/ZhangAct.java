package com.fzh.game.dota;

import com.fzh.game.db.DatabaseConstant;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ZhangAct extends BaseAct {

	private ImageView qzimg, zzimg, hzimg;

	private TextView qzdes, zzdes, hzdes;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.zhang);
		makeView();
		freshView();
	}

	private void makeView() {
		qzimg = (ImageView) findViewById(R.id.qzimg);
		zzimg = (ImageView) findViewById(R.id.zzimg);
		hzimg = (ImageView) findViewById(R.id.hzimg);
		qzdes = (TextView) findViewById(R.id.qzdes);
		zzdes = (TextView) findViewById(R.id.zzdes);
		hzdes = (TextView) findViewById(R.id.hzdes);
	}

	private void freshView() {
		qzimg.setImageResource(getImgFromDraByStr(heroBean.pic
				+ DatabaseConstant.QZ_HERO_EXTEND));
		zzimg.setImageResource(getImgFromDraByStr(heroBean.pic
				+ DatabaseConstant.ZZ_HERO_EXTEND));
		hzimg.setImageResource(getImgFromDraByStr(heroBean.pic
				+ DatabaseConstant.HZ_HERO_EXTEND));

		qzdes.setText("\t" + heroBean.qz);
		zzdes.setText("\t" + heroBean.zz);
		hzdes.setText("\t" + heroBean.hz);
	}
}