package com.santara.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btInputData,btViewList,btViewGrid,btExit;
    ArrayList<Mahasiswa> arrMhs = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btInputData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrMhs.add(new Mahasiswa("11","Deni",R.drawable.gambar1,20));
                arrMhs.add(new Mahasiswa("12","Andri",R.drawable.gambar2,21));
                arrMhs.add(new Mahasiswa("13","Winarti",R.drawable.gambar3,22));
                arrMhs.add(new Mahasiswa("14","Adi",R.drawable.gambar4,23));
                arrMhs.add(new Mahasiswa("15","Anita",R.drawable.gambar5,24));
                arrMhs.add(new Mahasiswa("16","Beby",R.drawable.gambar6,25));
                arrMhs.add(new Mahasiswa("17","Putri",R.drawable.gambar7,26));
                arrMhs.add(new Mahasiswa("18","Denise",R.drawable.gambar5,27));

            }
        });

        btViewList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
                intent.putParcelableArrayListExtra("arrMhs",arrMhs);
                startActivity(intent);

            }
        });

        btViewGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GridViewActivity.class);
                startActivity(intent);
            }
        });

        btExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
    }
}