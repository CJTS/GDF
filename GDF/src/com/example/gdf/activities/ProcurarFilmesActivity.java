package com.example.gdf.activities;

import com.example.gdf.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProcurarFilmesActivity extends Activity{
	
	private Button nome;
	private Intent intent;
	private Button diretor;
	private Intent intent1;
	private Button genero;
	private Intent intent2;
	private Button produtor;
	private Intent intent3;
	private Button voltar;
	private Intent intent4;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.procurar_filmes_activity);

        nome = (Button) findViewById(R.id.button2);
        intent = new Intent(this,ProcurarFilmesNomeActivity.class);
        nome.setOnClickListener(new View.OnClickListener() {	 
			@Override
			public void onClick(View v) {
				startActivity(intent);
			}
		});
        
        diretor = (Button) findViewById(R.id.button3);
        intent1 = new Intent(this,ProcurarFilmesDiretorActivity.class);
        diretor.setOnClickListener(new View.OnClickListener() {	 
			@Override
			public void onClick(View v) {
				startActivity(intent1);
			}
		});

        genero = (Button) findViewById(R.id.button4);
        intent2 = new Intent(this,ProcurarFilmesGeneroActivity.class);
        genero.setOnClickListener(new View.OnClickListener() {	 
			@Override
			public void onClick(View v) {
				startActivity(intent2);
			}
		});

        produtor = (Button) findViewById(R.id.button5);
        intent3 = new Intent(this,ProcurarFilmesProdutorActivity.class);
        produtor.setOnClickListener(new View.OnClickListener() {	 
			@Override
			public void onClick(View v) {
				startActivity(intent3);
			}
		});

        voltar = (Button) findViewById(R.id.button1);
        intent4 = new Intent(this,GerenciarFilmesActivity.class);
        voltar.setOnClickListener(new View.OnClickListener() {	 
			@Override
			public void onClick(View v) {
				startActivity(intent4);
			}
		});
    }
}