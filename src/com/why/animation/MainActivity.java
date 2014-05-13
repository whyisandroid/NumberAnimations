package com.why.animation;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	private Button bt_1, bt_2, bt_3, bt_5, bt_7;
	private TextView tv_num;

	private static int value = 0;
	private final int delayMillis = 10;

	private Handler handler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findView();
		initView();
	}

	private void initView() {
		bt_1.setOnClickListener(this);
		bt_2.setOnClickListener(this);
		bt_3.setOnClickListener(this);
		bt_5.setOnClickListener(this);
		bt_7.setOnClickListener(this);
	}

	private void findView() {
		tv_num = (TextView) findViewById(R.id.tv_num);
		bt_1 = (Button) findViewById(R.id.bt_1);
		bt_2 = (Button) findViewById(R.id.bt_2);
		bt_3 = (Button) findViewById(R.id.bt_3);
		bt_5 = (Button) findViewById(R.id.bt_5);
		bt_7 = (Button) findViewById(R.id.bt_7);
	}

	@Override
	public void onClick(View v) {
		String str = ((Button)v).getText().toString();
		value = Integer.parseInt(str);
		startTimer();
	}
	
	private void startTimer(){
		handler.removeCallbacks(run);
		handler.postDelayed(run, delayMillis);
	}
	
	
	private Runnable run = new Runnable() {
		@Override
		public void run() {
    		int numStr = Integer.valueOf(tv_num.getText().toString());
    		if(numStr > value){
    			tv_num.setText(numStr-100+"");
	    		handler.postDelayed(run, delayMillis);
    		}else if(numStr < value){
    			tv_num.setText(numStr+100+"");
	    		handler.postDelayed(run, delayMillis);
    		}else if(numStr == value){
    			return;
    		}
		}
	};
	
	
	

}
