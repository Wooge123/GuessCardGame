package com.yukang.guesscardgame;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	private TextView tvResult;
	private ImageView iv1, iv2, iv3;
	private Button btnAgain;
	private int[] imgIds = { R.drawable.p01, R.drawable.p02, R.drawable.p03 };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tvResult = (TextView) findViewById(R.id.tvResult);
		iv1 = (ImageView) findViewById(R.id.p1);
		iv2 = (ImageView) findViewById(R.id.p2);
		iv3 = (ImageView) findViewById(R.id.p3);
		btnAgain = (Button) findViewById(R.id.btnAgain);
		btnAgain.setOnClickListener(this);
		iv1.setOnClickListener(this);
		iv2.setOnClickListener(this);
		iv3.setOnClickListener(this);
		random();
	}

	@Override
	public void onClick(View v) {
		iv1.setImageResource(imgIds[0]);
		iv2.setImageResource(imgIds[1]);
		iv3.setImageResource(imgIds[2]);
		switch (v.getId()) {
		case R.id.p1:
			judgeA(0);
			iv2.setAlpha(100);
			iv3.setAlpha(100);
			break;
		case R.id.p2:
			judgeA(1);
			iv1.setAlpha(100);
			iv3.setAlpha(100);
			break;
		case R.id.p3:
			judgeA(2);
			iv1.setAlpha(100);
			iv2.setAlpha(100);
			break;
		case R.id.btnAgain:
			tvResult.setText("猜猜看红心A是哪一张？");
			iv1.setImageResource(R.drawable.p04);
			iv2.setImageResource(R.drawable.p04);
			iv3.setImageResource(R.drawable.p04);
			iv1.setAlpha(255);
			iv2.setAlpha(255);
			iv3.setAlpha(255);
			random();
			break;
		}
	}

	private void judgeA(int i) {
		if (imgIds[i] == R.drawable.p01)
			tvResult.setText("哇!你猜对了喔!!拍拍手!");
		else
			tvResult.setText("你猜错了喔!!要不要再试一次?");
	}

	/**
	 * 重新洗牌方法
	 */
	private void random() {
		for (int i = 0; i < imgIds.length; i++) {
			int tmp = imgIds[i];
			int s = (int) (Math.random() * 2);
			imgIds[i] = imgIds[s];
			imgIds[s] = tmp;
		}
	}

}
