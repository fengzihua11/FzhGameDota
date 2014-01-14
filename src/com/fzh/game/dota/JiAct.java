package com.fzh.game.dota;

import com.fzh.game.db.DatabaseConstant;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class JiAct extends BaseAct {

	private ImageView addMeth;
	private TextView desMeth;
	
	private TextView ji1, ji2, ji3, ji4, ji5;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ji);
		makeView();
		freshView();
	}

	private void makeView() {
		addMeth = (ImageView) findViewById(R.id.addMeth);
		desMeth = (TextView) findViewById(R.id.desMeth);
		ji1 = (TextView) findViewById(R.id.ji1);
		ji2 = (TextView) findViewById(R.id.ji2);
		ji3 = (TextView) findViewById(R.id.ji3);
		ji4 = (TextView) findViewById(R.id.ji4);
		ji5 = (TextView) findViewById(R.id.ji5);
	}

	private void freshView() {
		addMeth.setImageResource(getImgFromDraByStr(heroBean.pic
				+ DatabaseConstant.JI_HERO_EXTEND));
		desMeth.setText(heroBean.jineng);
	}
}