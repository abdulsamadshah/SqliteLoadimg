package com.example.sqliteloadimg;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    EditText bikename;
    Button insert;
    ImageView bikeimg;
    Uri imageuri;
    FloatingActionButton showdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bikename = findViewById(R.id.bikename);
        insert = findViewById(R.id.insert);
        bikeimg = findViewById(R.id.bikeimg);
        showdata=findViewById(R.id.showdata);

        showdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),ReadDataAc.class);
                startActivity(intent);
            }
        });

        Dbhelper dbhelper = new Dbhelper(getApplicationContext());

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isinserted = dbhelper.insertOrder(
                        bikename.getText().toString(),
                        imageuri + "");
                if (isinserted == true) {

                    Toast.makeText(MainActivity.this, "data inseted succesfully", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(getApplicationContext(), ReadDataAc.class);
//                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bikeimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, 10);
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            imageuri = data.getData();
            bikeimg.setImageURI(imageuri);
        }else{
            Toast.makeText(this, "something wrong", Toast.LENGTH_SHORT).show();
        }
    }



}