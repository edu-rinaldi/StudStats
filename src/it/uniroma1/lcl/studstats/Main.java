package it.uniroma1.lcl.studstats;

import it.uniroma1.lcl.studstats.dati.*;

public class Main
{
    public static void easterEgg()
    {
        System.out.println("+oooooooooooooooooooo++:-`    \n" +
                "osssssssssssssssssssssssss+`  \n" +
                "osssssssssssssssssssssssssss` \n" +
                "ossssssssssssssssso--:ssssss: \n" +
                "osssssso-` `-ossss-   +sssss- \n" +
                "ossssss-     :sssso /osssss:  \n" +
                "osssssso.   `ossss-:sssss/`   \n" +
                "osssssss/`os:.oss+`sssssss+-  \n" +
                "osssssss`+ssso./+./ssssssssso`\n" +
                "ossssss/.sssss/   `osssssssss/\n" +
                "ossss:. .ossss/`  `osssssssss+\n" +
                "osss/    :ssssssoosssssssssss:\n" +
                "ossss/--/sssssssssssssssssss+ \n" +
                "ossssssssssssssssssssssssso-  \n" +
                "+oooooooooooooooooooo+/:-`   " +
                "\n\n----------------------\n");
    }
    public static void main(String[] args)
    {
        Studstats s = Studstats.fromFile("IMMATRICOLATI_INFORMATICA_SAPIENZA_2018_randomizzato.csv");
        s.addAll(Analizzatori.allBasic());
        for(Rapporto r: s.generaRapporti())
            System.out.println(r+"\n");

    }
}
