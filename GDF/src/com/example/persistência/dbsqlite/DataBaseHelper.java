package com.example.persistência.dbsqlite;

import java.util.ArrayList;
import java.util.List;

import com.example.gdf.classes.Filmes;
import com.example.gdf.classes.Usuarios;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBaseHelper extends SQLiteOpenHelper {
	
	public static final String DB_TEST = "gdf.db";
	public static final String TABLE_NAME = "usuarios";
	public static final String TABLE_NAME2 = "filmes";
	public static final String LOGIN = "login";
	public static final String SENHA = "senha";
	public static final String NOME = "nome";
	public static final String DIRETOR = "diretor";
	public static final String PRODUTOR = "produtor";
	public static final String HISTORIA = "historia";
	public static final String GENERO = "genero";
	public static final String ID = "_id";

	public DataBaseHelper(Context context) {
        super(context, DB_TEST, null, 1);
    }
	
	@Override
	public void onCreate(SQLiteDatabase db){
		db.execSQL("CREATE TABLE " + TABLE_NAME + " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + LOGIN + " TEXT, " + SENHA + " TEXT);");
		db.execSQL("CREATE TABLE " + TABLE_NAME2 + " ("
		+ ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + 
		NOME + " TEXT, " + 
		DIRETOR + " TEXT, " + 
		PRODUTOR + " TEXT, " + 
		GENERO + " TEXT, " + 
		HISTORIA + " TEXT);");
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
		onCreate(db);
	}
	
	public void addUsuario(Usuarios usuario) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(LOGIN, usuario.getLogin());
        values.put(SENHA, usuario.getSenha()); 
 
        db.insert(TABLE_NAME, null, values);
    }
	
	public void addFilme(Filmes filmes) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(NOME, filmes.getNome()); 
        values.put(DIRETOR, filmes.getDiretor());
        values.put(PRODUTOR, filmes.getProdutor());
        values.put(GENERO, filmes.getGenero());
        values.put(HISTORIA, filmes.getHistoria()); 
        
        Log.d("Inseriu", values.toString());
 
        db.insert(TABLE_NAME2, null, values);
    }
 
	Usuarios getUsuario(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
 
        Cursor cursor = db.query(TABLE_NAME, new String[] { ID,
                LOGIN, SENHA }, ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
 
        Usuarios contact = new Usuarios(Integer.parseInt(cursor.getString(0)),
        		cursor.getString(1), cursor.getString(2));

        return contact;
    }
    
   public List<Usuarios> getAllUsuarios() {
       List<Usuarios> usuariosList = new ArrayList<Usuarios>();
       String selectQuery = "SELECT  * FROM " + TABLE_NAME;

       SQLiteDatabase db = this.getWritableDatabase();
       Cursor cursor = db.rawQuery(selectQuery, null);

       if (cursor.moveToFirst()) {
           do {
               Usuarios usuario = new Usuarios();
               usuario.setID(Integer.parseInt(cursor.getString(0)));
               usuario.setLogin(cursor.getString(1));
               usuario.setSenha(cursor.getString(2));
               usuariosList.add(usuario);
           } while (cursor.moveToNext());
       }

       return usuariosList;
   }
   
  public List<Filmes> getAllFilmes() {
      List<Filmes> filmesList = new ArrayList<Filmes>();
      String selectQuery = "SELECT  * FROM " + TABLE_NAME2;

      SQLiteDatabase db = this.getWritableDatabase();
      Cursor cursor = db.rawQuery(selectQuery, null);

      if (cursor.moveToFirst()) {
          do {
              Filmes filme = new Filmes();
              filme.setID(Integer.parseInt(cursor.getString(0)));
              filme.setNome(cursor.getString(1));
              filme.setDiretor(cursor.getString(2));
              filme.setProdutor(cursor.getString(3));
              filme.setGenero(cursor.getString(4));
              filme.setHistoria(cursor.getString(5));
              filmesList.add(filme);
          } while (cursor.moveToNext());
      }

      return filmesList;
  }
  

  public int getUsuariosCount() {
      String countQuery = "SELECT  * FROM " + TABLE_NAME;
      SQLiteDatabase db = this.getReadableDatabase();
      Cursor cursor = db.rawQuery(countQuery, null);
      
      return cursor.getCount();
  }
  
  public int getFilmesCount() {
      String countQuery = "SELECT  * FROM " + TABLE_NAME2;
      SQLiteDatabase db = this.getReadableDatabase();
      Cursor cursor = db.rawQuery(countQuery, null);
      
      return cursor.getCount();
  }
  

  public void closeDB() {
      SQLiteDatabase db = this.getReadableDatabase();
      if (db != null && db.isOpen())
          db.close();
  }

  public Filmes getFilme(String parametro, String nome){
      SQLiteDatabase db = this.getReadableDatabase();
      
      Cursor cursor = db.query(TABLE_NAME2, new String[] { ID,
              NOME, DIRETOR, PRODUTOR, HISTORIA, GENERO}, parametro + "=?",
              new String[] { nome }, null, null, null, null);
      if (cursor != null)
          cursor.moveToFirst();

      Filmes filme = new Filmes(Integer.parseInt(cursor.getString(0)),
      		cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5));

      return filme;
  }
}