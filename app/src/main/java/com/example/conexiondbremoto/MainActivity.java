package com.example.conexiondbremoto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.sql.*;

public class MainActivity extends AppCompatActivity {
    private EditText etUsuario, etContrasena;
    private Button btnLogin;
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://db4free.net/tienda_mascotas?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
    private static String user = "tienda_admin";
    private static String password = "adminTienda2023";
    private static Connection cnx = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // realizamos la conexion con la base de datos
        realizarConexion();

        etUsuario = findViewById(R.id.etUsuario);
        etContrasena = findViewById(R.id.etContrasena);
        btnLogin = findViewById(R.id.btnLogin);

        //click del boton login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Statement sentencia = null;
                try {
                    sentencia = cnx.createStatement();
                    ResultSet resul = sentencia.executeQuery("select * from usuarios where usuario = '"+etUsuario.getText()+"'");
                    while (resul.next()) {
                        String usuario = resul.getString("usuario");
                        String contrasena = resul.getString("contrasena");

                        if(contrasena.equals(etContrasena.getText().toString())){
                            Toast.makeText(MainActivity.this, "Usuario y contraseña coinciden", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(getApplicationContext(), PaginaPrincipal.class);
                            startActivity(i);
                        }else{
                            Toast.makeText(MainActivity.this, "datos incorrectos", Toast.LENGTH_SHORT).show();

                        }
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });


    }

    private void realizarConexion(){
        try {
            Class.forName(driver);
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            cnx = DriverManager.getConnection(url, user, password);
            Log.e("CONEXION A BD", " conexion establecida");
        } catch (Exception e) {
            Log.e("CONEXION A BD", " error al conectarse a la base de datos");
        }
    }


}