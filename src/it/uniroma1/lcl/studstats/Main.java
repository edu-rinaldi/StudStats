package it.uniroma1.lcl.studstats;

import it.uniroma1.lcl.studstats.dati.Rapporto;
import it.uniroma1.lcl.studstats.dati.analizzatori.AnalizzatoreAnnoDiploma;

public class Main
{
    public static void main(String[] args)
    {
        Studstats s = Studstats.fromFile("src/it/uniroma1/lcl/studstats/IMMATRICOLATI_INFORMATICA_SAPIENZA_2018_randomizzato.csv");
        //for(Studente s1: s.studenti) System.out.println(s1);
        s.add(new AnalizzatoreAnnoDiploma());

        System.out.println(s.generaRapporti(Rapporto.RapportoSemplice.ANNO_DIPLOMA));
    }
}
