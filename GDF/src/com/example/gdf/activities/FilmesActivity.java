package com.example.gdf.activities;

import com.example.gdf.R;
import com.example.gdf.classes.Filmes;
import com.example.persistência.dbsqlite.DataBaseHelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class FilmesActivity extends Activity{

	private Button enviar;
	private Intent intent;
	private Button voltar;
	private EditText nome;
	private EditText diretor;
	private EditText produtor;
	private EditText historia;
	private Spinner genero;
	private String gener;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filmes_activity);
        
        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
             R.array.generos_dos_filmes, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

		genero = (Spinner) findViewById(R.id.spinner1); 
		
		genero.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {  
		    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {   
		    	gener = genero.getSelectedItem().toString();
		    }   
		    public void onNothingSelected(AdapterView<?> adapterView) {  
		        return;  
		    }   
		});  
        
        enviar = (Button) findViewById(R.id.button1);
        
        voltar = (Button) findViewById(R.id.button2);
        intent = new Intent(this,GerenciarFilmesActivity.class);

        enviar.setOnClickListener(new View.OnClickListener() {
        	 
			@Override
			public void onClick(View v) {
				salvarFilme();
				startActivity(intent);
			}
		});

        voltar.setOnClickListener(new View.OnClickListener() {
        	 
			@Override
			public void onClick(View v) {
				startActivity(intent);
			}
		});
        

        }
	
	private void salvarFilme(){

		nome = (EditText) findViewById(R.id.editText1);
		diretor = (EditText) findViewById(R.id.editText2);
		produtor = (EditText) findViewById(R.id.editText3);
		historia = (EditText) findViewById(R.id.editText4);
		
		Filmes filme = new Filmes(nome.getText().toString(),
				diretor.getText().toString(),
				produtor.getText().toString(),
				historia.getText().toString(),
				gener);
		
        DataBaseHelper db = new DataBaseHelper(this);
        Log.d("Inseriu",filme.getGenero());
        
        db.addFilme(filme);
        db.closeDB();
	}
}
