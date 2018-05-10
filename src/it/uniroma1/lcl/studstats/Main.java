package it.uniroma1.lcl.studstats;

import it.uniroma1.lcl.studstats.dati.Analizzatori;

public class Main
{
    public static void main(String[] args)
    {
        Studstats s = Studstats.fromFile("IMMATRICOLATI_INFORMATICA_SAPIENZA_2018_randomizzato.csv");
        s.add(Analizzatori.AnalizzatoreAnnoDiploma);
        s.add(Analizzatori.analizzatoreIstituti);
        s.generaRapporti().stream().forEach(System.out::println);
        //System.out.println(s.generaRapporti(Rapporto.RapportoSemplice.ANNO_DIPLOMA, Rapporto.RapportoSemplice.ISTITUTI));
    }
}
