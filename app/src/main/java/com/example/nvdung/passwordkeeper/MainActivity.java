package com.example.nvdung.passwordkeeper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObservable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Set ContentView
        setContentView(R.layout.activity_main);

        //Get informtion from layout
        context = this;

        Button bttSave =(Button) findViewById(R.id.bttSave);
        final EditText txtLink = (EditText) findViewById(R.id.txtLink);
        final EditText txtUser = (EditText) findViewById(R.id.txtUser);
        final EditText txtUserName = (EditText) findViewById(R.id.txtUserName);

        //Save DB
        bttSave.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {


                                           final String strLink = txtLink.getText().toString();
                                           final String strUser = txtUser.getText().toString();
                                           final String strUserName = txtUserName.getText().toString();
                                           dbSqlLite objdb = new dbSqlLite(context);
                                           objdb.save(strLink, strUser, strUserName);
                                           double coutRow = objdb.getCoutRow();
                                           Toast.makeText(MainActivity.this, coutRow + "", Toast.LENGTH_SHORT).show();

                                           //Sau khi save xong, load len listview
                                           Intent intent = new Intent(context,ListActivity.class);
                                           startActivity(intent);
                                       }
                                   }
        );

    }
}
