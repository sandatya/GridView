package com.santara.gridview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class GridViewActivity extends AppCompatActivity {
    GridView gView;
    ArrayList<Mahasiswa>arrMhs2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        Intent intent = getIntent();
        arrMhs2=intent.getParcelableArrayListExtra("ArrayMhs");
        gView=(GridView) findViewById(R.id.GridViewList);

        gView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Mahasiswa selectedMhs =arrMhs2.get(i);
                Toast.makeText(getBaseContext(),"Nama : "+selectedMhs.getNama(),Toast.LENGTH_LONG).show();
            }
        });

        setAdapterGridView();
    }
    private class MyListAdapter extends ArrayAdapter<Mahasiswa>{
        public MyListAdapter(){
           super(GridViewActivity.this,R.layout.detail_data_list,arrMhs2);

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            if(convertView==null){
                convertView=getLayoutInflater().inflate(R.layout.detail_data_list,parent,false);
            }

            Mahasiswa currentMhs = arrMhs2.get(position);
            ImageView imgV = (ImageView) convertView.findViewById(R.id.imageView);
            imgV.setImageResource(currentMhs.getFoto());
            TextView tvNim = (TextView) convertView.findViewById(R.id.textViewNIM);

            tvNim.setText(currentMhs.getNim()+'\n'+currentMhs.getNama()+'\n'+String.valueOf(currentMhs.getUmur()));


            return convertView;
        }
    }

    private void setAdapterGridView(){
        ArrayAdapter<Mahasiswa> adapter = new MyListAdapter();
        gView.setAdapter(adapter);
    }
}