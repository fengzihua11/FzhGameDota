package com.fzh.game.view;

import com.fzh.game.dota.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;

public class NumberView extends ImageView {

	private final static float DISPADDING_NORMAL = 6.0f;

	private final static float DISPADDING = DISPADDING_NORMAL * 1.0f;

	private int iconNumber = 0;
	private int currentIcon = 0;

	private Paint paint = null;

	private Bitmap bitmapCurrSelect = null;
	private Bitmap bitmapNoneSelect = null;

	private int currWidth = 0;
	private int currHeight = 0;
	private int noneWidth = 0;
	private int noneHeight = 0;

	public NumberView(Context context) {
		super(context);
		init();
	}

	public NumberView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public NumberView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public void init() {
		setBackgroundDrawable(null);
		paint = new Paint();
		paint.setFilterBitmap(true);
		
		bitmapCurrSelect = BitmapFactory.decodeResource(getContext()
				.getResources(), R.drawable.current_select_point);
		currWidth = bitmapCurrSelect.getWidth();
		currHeight = bitmapCurrSelect.getHeight();
		bitmapNoneSelect = BitmapFactory.decodeResource(getContext()
				.getResources(), R.drawable.non_select_point);
		noneWidth = bitmapNoneSelect.getWidth();
		noneHeight = bitmapNoneSelect.getHeight();		
	}

	public void setNumber(int number) {
		if (number != iconNumber) {
			iconNumber = number;
			invalidate();
		}
	}

	public void setCurrentNumber(int currentIconI) {
		if (currentIconI != currentIcon) {
			currentIcon = currentIconI;
			invalidate();
		}
	}

	public int getNumber() {
		return iconNumber;
	}

	public void add() {
		iconNumber++;
		invalidate();
	}

	public boolean shorNumber() {
		if (iconNumber > 0) {
			iconNumber--;
			invalidate();
			return true;
		}
		return false;
	}

	@Override
	protected void onDetachedFromWindow() {
		super.onDetachedFromWindow();
		if (bitmapCurrSelect != null)
			bitmapCurrSelect.recycle();
		if (bitmapNoneSelect != null)
			bitmapNoneSelect.recycle();
	}

	/**
	 * 绘制桌面的图标
	 * 
	 * @Override
	 */
	public void draw(Canvas canvas) {
		final float countWidth = (iconNumber + 1) * noneWidth;
		// 图片之间的间隔总合
		final float distance = iconNumber * DISPADDING;
		// 当前图片其它图片多出的区域的一半
		final float currentExpadding = (currWidth - noneWidth) / 2;
		final float startX = (getWidth() - countWidth - distance) / 2;		
		// 绘制导航点
		for (int i = 0; i < iconNumber; i++) {
			if (i == currentIcon) {
				canvas.drawBitmap(bitmapCurrSelect, startX + (i + 1)
						* (noneWidth + DISPADDING) - currentExpadding,
						getHeight() / 2 - currHeight / 2, paint);
			} else {
				canvas.drawBitmap(bitmapNoneSelect, startX + (i + 1)
						* (noneWidth + DISPADDING), getHeight() / 2
						- noneHeight / 2, paint);
			}
		}
		super.draw(canvas);
	}
}