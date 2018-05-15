package it.uniroma1.lcl.studstats;

import it.uniroma1.lcl.studstats.dati.Analizzatore;
import it.uniroma1.lcl.studstats.dati.Analizzatori;
import it.uniroma1.lcl.studstats.dati.analizzatori.AnalizzatoreAnnoDiploma;
import it.uniroma1.lcl.studstats.dati.analizzatori.AnalizzatoreStudentiVotoMaggiore;

public class Main
{
    public static void main(String[] args)
    {
        Studstats s = Studstats.fromFile("IMMATRICOLATI_INFORMATICA_SAPIENZA_2018_randomizzato.csv");
        s.addAll(Analizzatori.allBasic());
        s.generaRapporti().forEach(System.out::println);
    }
}
