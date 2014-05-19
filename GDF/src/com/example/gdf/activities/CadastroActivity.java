package com.example.gdf.activities;

import com.example.gdf.R;
import com.example.gdf.classes.Usuarios;
import com.example.persistência.dbsqlite.DataBaseHelper;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class CadastroActivity extends Activity {

	private Button btn1;
	private TextView nome;
	private TextView senha;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_activity);
        
        btn1 = (Button) findViewById(R.id.button1);

        btn1.setOnClickListener(new View.OnClickListener() {
        	 
			@Override
			public void onClick(View v){
				DataBaseHelper db = new DataBaseHelper(null);

				nome = (TextView) findViewById(R.id.button2);
				senha = (TextView) findViewById(R.id.button2);
				
				Usuarios usuario = new Usuarios(nome.toString(),senha.toString());
				
				db.addUsuario(usuario);
				
			}
		});
    }

}