package it.uniroma1.lcl.studstats;

import it.uniroma1.lcl.studstats.dati.Analizzatore;
import it.uniroma1.lcl.studstats.dati.Rapporto;
import it.uniroma1.lcl.studstats.dati.Studente;
import it.uniroma1.lcl.studstats.dati.TipoRapporto;

import java.io.FileReader;
import java.util.HashSet;
import java.util.List;

public class Studstats implements AggregatoreStatistico
{

    private HashSet<Studente> studenti;
    //TODO: Togliere List e mettere HashSet per gli analizzatori
    private List<Analizzatore> analizzatori;

    private Studstats(HashSet<Studente> studenti) {this.studenti = studenti;}

    @Override
    public void add(Studente s) {studenti.add(s);}

    @Override
    public void add(Analizzatore an) {analizzatori.add(an);}

    @Override
    public List<Rapporto> generaRapporti(TipoRapporto... tipiRapporto)
    {
        return null;
    }

    public Studstats fromFile(String file)
    {
        
    }
}
