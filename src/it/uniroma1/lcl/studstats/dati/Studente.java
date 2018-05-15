package it.uniroma1.lcl.studstats.dati;

import java.util.HashMap;

public class Studente
{
    private HashMap<String,String> info;

    public Studente(HashMap<String,String> info) {this.info = info;}


    @Override
    public String toString() {return info.toString();}

    public String get(String key) { return info.get(key);}
    public HashMap<String, String> getInfo() {return info;}
}
