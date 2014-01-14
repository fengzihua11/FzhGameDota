package com.fzh.game.dota;

import com.fzh.game.db.DatabaseHelper;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

public class DotaLoadAct extends BaseAllAct {
	
	private final static int LOADING_OVER_TIME = 1800;

	protected CheckDataAsyncTask checkTask;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.load);
		checkData();
	}
	
	private void checkData() {
		if (checkTask != null
				&& checkTask.getStatus() != CheckDataAsyncTask.Status.FINISHED) {
			checkTask.cancel(true);
		}
		checkTask = (CheckDataAsyncTask) new CheckDataAsyncTask().execute();
	}
	
	private class CheckDataAsyncTask extends AsyncTask<Void, String, Void> {
		protected Void doInBackground(Void... params) {
			DatabaseHelper.checkAndMakeDir(DotaLoadAct.this, R.raw.dota);
			try {
				Thread.sleep(LOADING_OVER_TIME);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			geToMainPage();
		}
	};
	
	private void geToMainPage() {
		Intent intent = new Intent(this, DotaMainAct.class);
		startActivity(intent);
		finish();
	}	
	
	protected void onDestroy() {
		super.onDestroy();
		if (checkTask != null
				&& checkTask.getStatus() != AsyncTask.Status.FINISHED) {
			checkTask.cancel(true);
			checkTask = null;
		}
	}
}