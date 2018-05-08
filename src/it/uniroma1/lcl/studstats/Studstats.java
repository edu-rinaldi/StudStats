package it.uniroma1.lcl.studstats;

import it.uniroma1.lcl.studstats.dati.Analizzatore;
import it.uniroma1.lcl.studstats.dati.Rapporto;
import it.uniroma1.lcl.studstats.dati.Studente;
import it.uniroma1.lcl.studstats.dati.TipoRapporto;
import it.uniroma1.lcl.studstats.util.CSVParser;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Studstats implements AggregatoreStatistico
{
    private HashSet<Studente> studenti;

    //TODO: Togliere List e mettere HashSet per gli analizzatori
    private List<Analizzatore> analizzatori;


    private Studstats() {this.studenti = new HashSet<>();}
    private Studstats(HashSet<Studente> studenti) {this.studenti = studenti;}

    @Override
    public void add(Studente s) {studenti.add(s);}

    @Override
    public void add(Analizzatore an) {analizzatori.add(an);}

    //TODO: generaRapporti
    @Override
    public List<Rapporto> generaRapporti(TipoRapporto... tipiRapporto)
    {
        List<Rapporto> listaRapporti;
        return null;
    }


    public static Studstats fromFile(String file)
    {
        //nuova istanza Studstats
        Studstats stats = new Studstats();
        //parse del file
        CSVParser parser = new CSVParser(file);
        HashSet<Map> setMappe = new HashSet<>(parser.parseFile());

        for(Map mappaStudente: setMappe) stats.add(new Studente(mappaStudente));

        return stats;
    }

    //getter
    public HashSet<Studente> getStudenti() {return studenti;}
    public List<Analizzatore> getAnalizzatori() {return analizzatori;}

    public static void main(String[] args)
    {
        Studstats s = Studstats.fromFile("src/it/uniroma1/lcl/studstats/IMMATRICOLATI_INFORMATICA_SAPIENZA_2018_randomizzato.csv");
        for(Studente s1: s.studenti) System.out.println(s1);
    }


}
