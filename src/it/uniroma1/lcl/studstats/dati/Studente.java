package it.uniroma1.lcl.studstats.dati;

import java.util.Map;

public class Studente
{
    private Map<String,String> info;

    public Studente(Map info) {this.info = info;}

    //possiamo utilizzare direttamente l'hashcode di info
    @Override
    public int hashCode() {return info.hashCode();}

    //possiamo utilizzare direttamente l'equals di info
    @Override
    public boolean equals(Object obj) {return info.equals(obj);}

    @Override
    public String toString() {return info.toString();}


    public Map<String, String> getInfo() {return info;}
}
