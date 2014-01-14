package com.fzh.game.dota;

import com.fzh.game.db.DatabaseConstant;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class ShuAct extends BaseAct implements OnClickListener {

	private ImageView shu;

	private TextView charpter, sy;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shu);
		makeView();
		freshView();
	}

	private void makeView() {
		shu = (ImageView) findViewById(R.id.shu);
		charpter = (TextView) findViewById(R.id.charpter);
		sy = (TextView) findViewById(R.id.sy);
	}

	private void freshView() {
		shu.setImageResource(getImgFromDraByStr(heroBean.pic
				+ DatabaseConstant.SHU_HERO_EXTEND));
		switch (heroBean.charpter) {
		case 1:
			charpter.setText("英雄类型：智力");
			charpter.setTextColor(getResources().getColor(R.color.yellow));
			break;

		case 2:
			charpter.setText("英雄类型：敏捷");
			charpter.setTextColor(getResources().getColor(R.color.green));
			break;

		case 3:
			charpter.setText("英雄类型：力量");
			charpter.setTextColor(getResources().getColor(R.color.red));
			break;
		}
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.sy:
			playSound();
			break;
		}
	}

	private void playSound() {

	}
}