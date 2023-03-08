package com.example.conexiondbremoto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.*;

public class MainActivity extends AppCompatActivity {
private EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.et);

        java.sql.Connection cnx = null;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://db4free.net/tienda_mascotas?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
        String user = "tienda_admin";
        String password = "adminTienda2023";

        try {
            Class.forName(driver);
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            cnx = DriverManager.getConnection(url, user, password);

            Statement sentencia = cnx.createStatement();
            ResultSet resul = sentencia.executeQuery("select * from table_name");

            while (resul.next()) {
                et.setText(et.getText() + " "+resul.getString("column1"));
            }
        } catch (Exception e) {
            et.setText(""+e);

        }
    }


}