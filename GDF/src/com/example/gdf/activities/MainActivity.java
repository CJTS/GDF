package com.example.gdf.activities;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gdf.R;

public class MainActivity extends Activity {

	private Button btn1;
	private Intent intent;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        btn1 = (Button) findViewById(R.id.button1);
        intent = new Intent(this,GerenciarFilmesActivity.class);

        btn1.setOnClickListener(new View.OnClickListener() {
        	 
			@Override
			public void onClick(View v) {
				startActivity(intent);
			}
		});
    }

}
