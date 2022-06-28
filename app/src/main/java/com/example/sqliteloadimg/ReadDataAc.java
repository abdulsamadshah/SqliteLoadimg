package com.example.sqliteloadimg;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ReadDataAc extends AppCompatActivity {
RecyclerView readrv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_data);
        readrv=findViewById(R.id.readrv);



        try {
            Dbhelper dbhelper=new Dbhelper(getApplicationContext());
            ArrayList<ReadModels> modelss=dbhelper.getOrders();
            readrv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            readAdapters adapters=new readAdapters(getApplicationContext(),modelss);
            readrv.setAdapter(adapters);
        }catch (Exception e){
            Toast.makeText(this, "readed problem", Toast.LENGTH_SHORT).show();
        }



    }
}