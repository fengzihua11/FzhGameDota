package com.fzh.game.dota;

import com.admogo.AdMogoLayout;
import com.admogo.AdMogoListener;
import com.admogo.AdMogoManager;
import com.fzh.game.db.DatabaseConstant;
import com.fzh.game.db.HeroBean;
import android.app.ActivityGroup;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class HeroDesAct extends ActivityGroup implements OnClickListener,
		AdMogoListener {

	public static final String HERO_BEAN = "hero";

	private HeroBean heroBean = null;
	private LinearLayout mainFrm;
	private LinearLayout desLin, shuLin, jiLin, zhangLin;
	private TextView desHero, shuHero, jiHero, zhangHero;
	private FrameLayout childAct;
	private LocalActivityManager localActivityManager;

	private int currentId = -1;

	private AdMogoLayout admogo_layout;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getHero();
		setContentView(R.layout.descriptionfrm);
		localActivityManager = getLocalActivityManager();
		makeView();
		showToast();
	}

	private void getHero() {
		heroBean = getIntent().getParcelableExtra(HERO_BEAN);
	}

	private void makeView() {
		mainFrm = (LinearLayout) findViewById(R.id.mainFrm);
		desLin = (LinearLayout) findViewById(R.id.desLin);
		desHero = (TextView) findViewById(R.id.desHero);
		desLin.setOnClickListener(this);
		shuLin = (LinearLayout) findViewById(R.id.shuLin);
		shuHero = (TextView) findViewById(R.id.shuHero);
		shuLin.setOnClickListener(this);
		jiLin = (LinearLayout) findViewById(R.id.jiLin);
		jiHero = (TextView) findViewById(R.id.jiHero);
		jiLin.setOnClickListener(this);
		zhangLin = (LinearLayout) findViewById(R.id.zhangLin);
		zhangHero = (TextView) findViewById(R.id.zhangHero);
		zhangLin.setOnClickListener(this);

		admogo_layout = (AdMogoLayout) findViewById(R.id.admogo_layout);
		admogo_layout.setAdMogoListener(this);

		childAct = (FrameLayout) findViewById(R.id.childAct);

		onClick(desLin);
	}

	public void setBackGround() {
		int resId = getResources().getIdentifier(
				heroBean.pic + DatabaseConstant.BG_HERO_EXTEND, "drawable",
				getPackageName());
		mainFrm.setBackgroundResource(resId);
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.desLin:
			if (goNewPage(DesAct.class, 0)) {
				desLin.setBackgroundColor(Color.GRAY);
			}
			break;

		case R.id.shuLin:
			if (goNewPage(ShuAct.class, 1)) {
				shuLin.setBackgroundColor(Color.GRAY);
			}
			break;
		case R.id.jiLin:
			if (goNewPage(JiAct.class, 2)) {
				jiLin.setBackgroundColor(Color.GRAY);
			}
			break;
		case R.id.zhangLin:
			if (goNewPage(ZhangAct.class, 3)) {
				zhangLin.setBackgroundColor(Color.GRAY);
			}
			break;
		}
	}

	private boolean goNewPage(Class<?> c, int index) {
		if (currentId == index)
			return false;
		chageBackColor();
		Intent intent = new Intent(this, c);
		intent.putExtra(HERO_BEAN, heroBean);
		childAct.removeAllViews();
		childAct.addView(localActivityManager.startActivity("", intent)
				.getDecorView());
		currentId = index;
		return true;
	}

	private void chageBackColor() {
		switch (currentId) {
		case 0:
			desLin.setBackgroundColor(Color.argb(0, 0, 0, 0));
			break;

		case 1:
			shuLin.setBackgroundColor(Color.argb(0, 0, 0, 0));
			break;
		case 2:
			jiLin.setBackgroundColor(Color.argb(0, 0, 0, 0));
			break;
		case 3:
			zhangLin.setBackgroundColor(Color.argb(0, 0, 0, 0));
			break;
		}
	}

	protected void showToast() {
		Toast.makeText(this, R.string.ad_show_content, Toast.LENGTH_SHORT).show();
	}

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
	}
}