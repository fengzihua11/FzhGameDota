package com.fzh.game.dota;

import com.fzh.game.db.DatabaseConstant;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ImageView.ScaleType;

public class DesAct extends BaseAct implements OnClickListener {

	private ImageView img;
	private TextView name, shortName, kuaijie;
	private TextView contentTv;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.des);
		makeView();
		fillData();
	}

	private void makeView() {
		img = (ImageView) findViewById(R.id.img);
		img.setOnClickListener(this);
		name = (TextView) findViewById(R.id.name);
		shortName = (TextView) findViewById(R.id.shortName);
		kuaijie = (TextView) findViewById(R.id.kuaijie);
		contentTv = (TextView) findViewById(R.id.contentTv);
	}

	private void fillData() {
		img.setImageResource(getImgFromDraByStr(heroBean.pic));
		if(heroBean.kaijie == null || heroBean.kaijie.equals(""))
			name.setText(heroBean.name);
		else
			name.setText(heroBean.name + "(" + heroBean.kaijie + ")");
		shortName.setText("Ó¢ ÎÄ£º" + heroBean.eName);
		kuaijie.setText("¼ò ³Æ£º" + heroBean.shortName);
		contentTv.setText("\t" + heroBean.description);
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.img:
			openBigPic();
			break;
		}
	}

	private void openBigPic() {
		ImageView v = new ImageView(this);
		v.setScaleType(ScaleType.FIT_CENTER);
		v.setImageResource(getImgFromDraByStr(heroBean.pic + DatabaseConstant.BG_HERO_EXTEND));
		AlertDialog dialog = new AlertDialog.Builder(this).setView(v).create();
		dialog.show();
	}
}