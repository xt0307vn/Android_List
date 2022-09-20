package com.example.andorid_learnlistview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {
    ListView listViewTraiCay ;
    ArrayList<TraiCay> traiCayArrayList;
    TraiCayApdater traiCayApdater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);


        connectID();
        traiCayApdater =new TraiCayApdater(ListViewActivity.this, R.layout.raw, traiCayArrayList);
        listViewTraiCay.setAdapter(traiCayApdater);

        listViewTraiCay.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ListViewActivity.this, DetailActivity.class);
                startActivity(intent);
            }
        });

        listViewTraiCay.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                confirmDelete(i);
                return false;
            }
        });
    }


    public void connectID() {
        listViewTraiCay = findViewById(R.id.listview);
        traiCayArrayList = new ArrayList<>();
        traiCayArrayList.add(new TraiCay("Chôm chôm", "Trái Cây", R.drawable.chomcom));
        traiCayArrayList.add(new TraiCay("Cà chua", "Trái Cây", R.drawable.cahcua));
        traiCayArrayList.add(new TraiCay("Nho", "Trái Cây", R.drawable.nho));
        traiCayArrayList.add(new TraiCay("Măng cụt", "Trái Cây", R.drawable.mangcut));

        traiCayArrayList.add(new TraiCay("Chôm chôm", "Trái Cây", R.drawable.chomcom));
        traiCayArrayList.add(new TraiCay("Cà chua", "Trái Cây", R.drawable.cahcua));
        traiCayArrayList.add(new TraiCay("Nho", "Trái Cây", R.drawable.nho));
        traiCayArrayList.add(new TraiCay("Măng cụt", "Trái Cây", R.drawable.mangcut));

    }

    public void confirmDelete(int position) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("");
        alert.setMessage("Bạn có muốn xóa không?");
        alert.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                traiCayArrayList.remove(position);
                traiCayApdater.notifyDataSetChanged();
            }
        });

        alert.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alert.show();
    }





}