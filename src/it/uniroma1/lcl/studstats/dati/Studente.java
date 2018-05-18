package it.uniroma1.lcl.studstats.dati;

import java.util.HashMap;
//TODO: VEDERE SE E' UN PATTERN
/**
 * Conserva tutte le informazioni dello studente
 * in una mappa String-to-String per generalizzare
 * banalmente il tipo di informazioni.
 * Viene utilizzata una mappa per poter permettere una
 * maggiore estensibilità della classe, andando a considerare così
 * "infiniti" campi.
 */
public class Studente
{
    private HashMap<String,String> info;

    /**
     *
     * @param info mappa delle informazioni con formato {@code <nomeCampo,valore>}
     */
    public Studente(HashMap<String,String> info) {this.info = info;}

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public String toString() {return info.toString();}

    /**
     *
     * @param key campo della mappa
     * @return valore corrispondente al campo
     */
    public String get(String key) { return info.get(key);}

    /**
     *
     * @return mappa delle informazioni riguardanti lo studente
     */
    public HashMap<String, String> getInfo() {return info;}
}
