package com.example.gdf.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gdf.R;

public class GerenciarFilmesActivity extends Activity {
	

	private Button inserir;
	private Intent intent;
	private Button listar;
	private Intent intent3;
	private Button voltar;
	private Intent intent2;
	private Button procurar;
	private Intent intent4;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gerenciar_filmes_activity);
        
        inserir = (Button) findViewById(R.id.button1);
        intent = new Intent(this,FilmesActivity.class);
        
        voltar = (Button) findViewById(R.id.button4);
        intent2 = new Intent(this,MainActivity.class);

        listar = (Button) findViewById(R.id.button3);
        intent3 = new Intent(this,ListarFilmesActivity.class);

        procurar = (Button) findViewById(R.id.button2);
        intent4 = new Intent(this,ProcurarFilmesActivity.class);

        inserir.setOnClickListener(new View.OnClickListener() {
        	 
			@Override
			public void onClick(View v) {
				startActivity(intent);
			}
		});

        voltar.setOnClickListener(new View.OnClickListener() {
        	 
			@Override
			public void onClick(View v) {
				startActivity(intent2);
			}
		});
        
        listar.setOnClickListener(new View.OnClickListener() {
        	 
			@Override
			public void onClick(View v) {
				startActivity(intent3);
			}
		});
        
        procurar.setOnClickListener(new View.OnClickListener() {
        	 
			@Override
			public void onClick(View v) {
				startActivity(intent4);
			}
		});
    }

}
