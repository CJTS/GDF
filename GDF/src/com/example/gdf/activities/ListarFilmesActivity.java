package com.example.gdf.activities;

import java.util.List;

import com.example.gdf.R;
import com.example.gdf.classes.Filmes;
import com.example.persistência.dbsqlite.DataBaseHelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ListarFilmesActivity extends Activity{
	ListView listView ;
	private Intent intent;
	private Button voltar;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listar_filmes);
        DataBaseHelper db = new DataBaseHelper(this);
        
        voltar = (Button) findViewById(R.id.button2);
        intent = new Intent(this,GerenciarFilmesActivity.class);
        
        int vaux = 0;
        
        listView = (ListView) findViewById(R.id.list);
        
        String[] values = new String[db.getFilmesCount()];
        
        List<Filmes> list = db.getAllFilmes();
        
        for(Filmes fil : list){
        	String usuario = "Nome: " + fil.getNome() + "\nDiretor: "
                    + fil.getDiretor() + "\nProdutor: " + fil.getProdutor() + "\nHistoria: " + fil.getHistoria() + "\nGenero: " + fil.getGenero();
        	values[vaux] = usuario;
        	vaux++;
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
          android.R.layout.simple_list_item_1, android.R.id.text1, values);
        
        listView.setAdapter(adapter); 
        
        db.closeDB();

        voltar.setOnClickListener(new View.OnClickListener() {
        	 
			@Override
			public void onClick(View v) {
				startActivity(intent);
			}
		});
    }
}
