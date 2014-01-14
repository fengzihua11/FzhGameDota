package com.fzh.game.dota;

import android.app.Activity;
import android.os.Bundle;

public class BaseAllAct extends Activity {
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	
	protected int getImgFromDraByStr(String str) {
		int resId = getResources().getIdentifier(str, "drawable",
				getPackageName());
		return resId;
	}
}