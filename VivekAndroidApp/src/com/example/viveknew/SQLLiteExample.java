package com.example.viveknew;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SQLLiteExample extends Activity implements OnClickListener {

	Button sqlUpdate, sqlView, sqlGetInfo, sqlModify, sqlDelete;
	EditText sqlName, sqlMobile, sqlRow;

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bSQLUpdate:

			boolean didItWork = true;
			try {
				String name = sqlName.getText().toString();
				String mobile = sqlMobile.getText().toString();

				Mobileno entry = new Mobileno(SQLLiteExample.this);
				entry.open();
				entry.createEntry(name, mobile);
				entry.close();
			} catch (Exception e) {
				didItWork = false;
				String error = e.toString();
				Dialog d = new Dialog(this);
				d.setTitle(" oops ! ");
				TextView tv = new TextView(this);
				tv.setText("error ocoured");
				d.setContentView(tv);
				d.show();
			} finally {
				if (didItWork) {
					Dialog d = new Dialog(this);
					d.setTitle(" yo dude! ");
					TextView tv = new TextView(this);
					tv.setText("success,the data is save now");
					d.setContentView(tv);
					d.show();
				}
			}

			break;
		case R.id.bSQLopenView:
			Intent i = new Intent("com.example.viveknew.SQLView");
			startActivity(i);
			break;

		case R.id.bgetInfo:
			try{
			String s = sqlRow.getText().toString();
			long l = Long.parseLong(s);
			Mobileno mo = new Mobileno(this);
			mo.open();
			String returnedName = mo.getName(l);
			String returnedMobile = mo.getMobile(l);
			mo.close();

			sqlName.setText(returnedName);
			sqlMobile.setText(returnedMobile);
			
		} catch (Exception e) {
			
			String error = e.toString();
			Dialog d = new Dialog(this);
			d.setTitle(" oops ! ");
			TextView tv = new TextView(this);
			tv.setText("error ocoured");
			d.setContentView(tv);
			d.show();
		} finally { }

			break;
		case R.id.bSQLmodify:
			try{
			String mName = sqlName.getText().toString();
			String mMobile = sqlMobile.getText().toString();
			String sRow = sqlRow.getText().toString();
			long lRow = Long.parseLong(sRow);

			Mobileno ex = new Mobileno(this);
			ex.open();
			ex.updateEntry(lRow, mName, mMobile);
			ex.close();
			
			} catch (Exception e) {
				
				String error = e.toString();
				Dialog d = new Dialog(this);
				d.setTitle(" oops ! ");
				TextView tv = new TextView(this);
				tv.setText("error ocoured");
				d.setContentView(tv);
				d.show();
			} finally {
			}

			break;

		case R.id.bSQLdelete:
			try{
			String sRow1 = sqlRow.getText().toString();
			long lRow1 = Long.parseLong(sRow1);
			Mobileno ex1 = new Mobileno(this);
			ex1.open();
			ex1.deleteEntry(lRow1);
			ex1.close();
			
			
			} catch (Exception e) {
				
				String error = e.toString();
				Dialog d = new Dialog(this);
				d.setTitle(" oops ! ");
				TextView tv = new TextView(this);
				tv.setText("error ocoured");
				d.setContentView(tv);
				d.show();
			} finally {
			}
			break;

		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sqlliteexample);
		sqlUpdate = (Button) findViewById(R.id.bSQLUpdate);
		sqlName = (EditText) findViewById(R.id.etSQLName);
		sqlMobile = (EditText) findViewById(R.id.etSQLMobile);
		sqlView = (Button) findViewById(R.id.bSQLopenView);
		sqlView.setOnClickListener(this);
		sqlUpdate.setOnClickListener(this);

		sqlRow = (EditText) findViewById(R.id.etSQLrowInfo);
		sqlModify = (Button) findViewById(R.id.bSQLmodify);
		sqlGetInfo = (Button) findViewById(R.id.bgetInfo);
		sqlDelete = (Button) findViewById(R.id.bSQLdelete);
		sqlDelete.setOnClickListener(this);
		sqlModify.setOnClickListener(this);
		sqlGetInfo.setOnClickListener(this);
	}

}
