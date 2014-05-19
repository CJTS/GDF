package com.example.gdf.activities;

import com.example.gdf.R;
import com.example.gdf.classes.Filmes;
import com.example.persistência.dbsqlite.DataBaseHelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ProcurarFilmesNomeActivity extends Activity{
	EditText nome ;
	private Intent intent;
	private Button voltar;
	private Button buscar;
	
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.procurar_filmes_nome_activity);
	        
	        buscar = (Button) findViewById(R.id.button1);
	        buscar.setOnClickListener(new View.OnClickListener() {
	        	 
				@Override
				public void onClick(View v) {
					buscarFilme();
				
				}
			}); 	

	        voltar = (Button) findViewById(R.id.button2);
	        intent = new Intent(this,GerenciarFilmesActivity.class);
	        
	        voltar.setOnClickListener(new View.OnClickListener() {
	        	 
				@Override
				public void onClick(View v) {
					startActivity(intent);
				}
			});
	    }
	 public void buscarFilme(){
		 DataBaseHelper db = new DataBaseHelper(this);
		 nome = (EditText) findViewById(R.id.editText1);
		 Filmes fil = db.getFilme("nome", nome.getText().toString());
		 TextView busca = new TextView(this);
		 busca.setText("Nome: " + fil.getNome() + "\nDiretor: "
                 + fil.getDiretor() + "\nProdutor: " + fil.getProdutor() + "\nHistoria: " + fil.getHistoria() + "\nGenero: " + fil.getGenero());

	     setContentView(busca);
		 
	 }
}
