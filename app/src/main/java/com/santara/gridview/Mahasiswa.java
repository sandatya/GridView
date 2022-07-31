package com.santara.gridview;

import android.os.Parcel;
import android.os.Parcelable;

public class Mahasiswa implements Parcelable {
    String nim, nama;
    int umur,foto;

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public int getUmur() {
        return umur;
    }

    public int getFoto() {
        return foto;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nim);
        dest.writeString(this.nama);
        dest.writeInt(this.umur);
        dest.writeInt(this.foto);
    }

    public Mahasiswa(String nim, String nama, int umur, int foto) {
        this.nim = nim;
        this.nama = nama;
        this.umur = umur;
        this.foto = foto;
    }
    public void readFromParcel(Parcel source) {
        this.nim = source.readString();
        this.nama = source.readString();
        this.umur = source.readInt();
        this.foto = source.readInt();
    }

    protected Mahasiswa(Parcel in) {
        this.nim = in.readString();
        this.nama = in.readString();
        this.umur = in.readInt();
        this.foto = in.readInt();
    }

    public static final Creator<Mahasiswa> CREATOR = new Creator<Mahasiswa>() {
        @Override
        public Mahasiswa createFromParcel(Parcel source) {
            return new Mahasiswa(source);
        }

        @Override
        public Mahasiswa[] newArray(int size) {
            return new Mahasiswa[size];
        }
    };
}
