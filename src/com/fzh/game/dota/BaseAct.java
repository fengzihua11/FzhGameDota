package com.fzh.game.dota;

import com.fzh.game.db.HeroBean;
import android.os.Bundle;
import android.widget.Toast;

public class BaseAct extends BaseAllAct {

	protected HeroBean heroBean = null;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getHero();
	}
	
	private void getHero() {
		heroBean = getIntent().getParcelableExtra(HeroDesAct.HERO_BEAN);
	}	
	
	protected void showToast() {
		Toast.makeText(this, R.string.ad_show_content, Toast.LENGTH_SHORT).show();
	}
}