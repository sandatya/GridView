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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {
    ListView lstView;
    ArrayList<Mahasiswa> arrMhs3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        Intent intent = getIntent();
        arrMhs3=intent.getParcelableArrayListExtra("ArrayMhs");
        lstView=(ListView) findViewById(R.id.listViewData);

        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Mahasiswa selectedMhs = arrMhs3.get(i);
                Toast.makeText(getBaseContext(),"Nama : "+selectedMhs.getNama(),Toast.LENGTH_LONG).show();
            }
        });
        setAdapter();
    }

    private class MyListAdapter extends ArrayAdapter<Mahasiswa> {
        public MyListAdapter(){
            super(ListViewActivity.this,R.layout.detail_data_list2,arrMhs3);

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            if(convertView==null){
                convertView=getLayoutInflater().inflate(R.layout.detail_data_list2,parent,false);
            }

            Mahasiswa currentData = arrMhs3.get(position);

           ImageView imView = (ImageView) convertView.findViewById(R.id.imageView2);
           imView.setImageResource(currentData.getFoto());
            TextView tvData = (TextView) convertView.findViewById(R.id.textviewList);
            tvData.setText(currentData.getNim()+'\n'+currentData.getNama()+'\n'+String.valueOf(currentData.getUmur()));


            return convertView;
        }
    }
    private void setAdapter (){
        ArrayAdapter<Mahasiswa> adapter = new MyListAdapter();
        lstView.setAdapter(adapter);
    }
}