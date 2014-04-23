package com.example.viveknew;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class TextPlay extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text);
		
		Button chkCmd= (Button) findViewById(R.id.bResults);
		final ToggleButton passTog=(ToggleButton) findViewById(R.id.tbPassword);
		final EditText input =(EditText) findViewById(R.id.etCommands);
		final TextView display=(TextView) findViewById(R.id.tvResults);
		passTog.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (passTog.isChecked()) {
					input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
					
				}else{
					input.setInputType(InputType.TYPE_CLASS_TEXT);
				}
			};
	});
		chkCmd.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String check= input.getText().toString();
				if(check.contentEquals("left")){
					display.setGravity(Gravity.LEFT);
				}else if(check.contentEquals("center")){
					display.setGravity(Gravity.CENTER);
				}else if(check.contentEquals("right")){
					display.setGravity(Gravity.RIGHT);
					
				}else if(check.contentEquals("blue")){
					
				}
				
			}
		});
	
	}}
