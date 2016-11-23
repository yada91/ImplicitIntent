package com.example.bit_user.implicitintent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TextView textView = (TextView) findViewById(R.id.textView);
		Button button_call = (Button) findViewById(R.id.button_call);
		Button button_web = (Button) findViewById(R.id.button_web);
		Button button_address = (Button) findViewById(R.id.button_address);
		Button button_search = (Button) findViewById(R.id.button_search);
		Button button_map = (Button) findViewById(R.id.button_map);

		button_call.setOnClickListener(this);
		button_web.setOnClickListener(this);
		button_address.setOnClickListener(this);
		button_search.setOnClickListener(this);
		button_map.setOnClickListener(this);
	}


	@Override
	public void onClick(View view) {
		int viewid = view.getId();
		Intent intent = null;
		switch (viewid) {
			case R.id.button_call:
				intent = new Intent("com.bit2016.android.action.ACTION_SHARE");
				startActivity(intent);
				break;
			case R.id.button_address:
				intent = new Intent(Intent.ACTION_PICK, Uri.parse("content://com.android.contacts/data/phones"));
				startActivity(intent);
				break;
			case R.id.button_web:
				intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.estsoft.com"));
				startActivity(intent);
				break;
			case R.id.button_search:
				intent = new Intent(Intent.ACTION_SEARCH);
				intent.setPackage("com.android.browser");
				intent.putExtra("query", "android");
				startActivity(intent);
				break;
			case R.id.button_map:
				intent = new Intent( Intent.ACTION_VIEW, Uri.parse("geo:38.899533,-77.036476" ) );
				startActivity(intent);
				break;
			default:
				Toast.makeText(this, "unknow view", Toast.LENGTH_SHORT).show();
		}
	}
}
