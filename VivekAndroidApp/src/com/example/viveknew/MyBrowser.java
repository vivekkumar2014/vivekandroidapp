package com.example.viveknew;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class MyBrowser extends Activity implements OnClickListener{
	EditText url;
	WebView myBrow;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mybrowser);

		myBrow = (WebView) findViewById(R.id.wvbrowser);
		myBrow.loadUrl("http://www.vit.ac.in/");

		
		
	}

	@Override
	public void onClick(DialogInterface arg0, int arg1) {
		// TODO Auto-generated method stub

	}

}
