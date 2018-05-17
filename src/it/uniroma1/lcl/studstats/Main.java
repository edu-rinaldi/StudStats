package it.uniroma1.lcl.studstats;

import it.uniroma1.lcl.studstats.dati.AnalizzatoreAnnoDiploma;
import it.uniroma1.lcl.studstats.dati.AnalizzatoreTitoloDiStudio;
import it.uniroma1.lcl.studstats.dati.AnalizzatoreVoto;
import it.uniroma1.lcl.studstats.dati.rapporti.RapportoBase;

public class Main
{
    public static void main(String[] args)
    {
        Studstats s = Studstats.fromFile("IMMATRICOLATI_INFORMATICA_SAPIENZA_2018_randomizzato.csv");
//        s.addAll(Analizzatori.allBasic());
//        s.add(new AnalizzatoreStudentiVotoMaggiore(80));
        //s.generaRapporti().forEach(System.out::println);
        s.add(new AnalizzatoreTitoloDiStudio());
        System.out.println(s.generaRapporti(RapportoBase.TITOLO));

    }
}
