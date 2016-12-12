package br.com.fernandescruz.times.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import retrofit2.http.Field;


/**
 * Created by claudiocruz on 19/11/16.
 */


public class Time implements Parcelable{

    private String nome;

    @SerializedName("anofundacao")
    private String anoFundacao;

    private String escudo;

    private String estado;

    protected Time(Parcel in) {
        nome = in.readString();
        anoFundacao = in.readString();
        escudo = in.readString();
        estado = in.readString();
    }

    public static final Creator<Time> CREATOR = new Creator<Time>() {
        @Override
        public Time createFromParcel(Parcel in) {
            return new Time(in);
        }

        @Override
        public Time[] newArray(int size) {
            return new Time[size];
        }
    };

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAnoFundacao() {
        return anoFundacao;
    }

    public void setAnoFundacao(String anoFundacao) {
        this.anoFundacao = anoFundacao;
    }

    public String getEscudo() {
        return escudo;
    }

    public void setEscudo(String escudo) {
        this.escudo = escudo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nome);
        parcel.writeString(anoFundacao);
        parcel.writeString(escudo);
        parcel.writeString(estado);
    }

}




