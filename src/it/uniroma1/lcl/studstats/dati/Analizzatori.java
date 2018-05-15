package it.uniroma1.lcl.studstats.dati;

import it.uniroma1.lcl.studstats.dati.analizzatori.*;

public interface Analizzatori
{
    static Analizzatore annoDiploma() { return new AnalizzatoreAnnoDiploma(); }
    static Analizzatore istituti() { return new AnalizzatoreIstituti(); }
    static Analizzatore sesso() { return new AnalizzatoreSesso(); }
    static Analizzatore titoloDiStudio() { return new AnalizzatoreTitoloDiStudio(); }
    static Analizzatore voto() { return new AnalizzatoreVoto(); }

    static Analizzatore[] allBasic() { return new Analizzatore[]
            { annoDiploma(), istituti(), sesso(), titoloDiStudio(), voto() }; }

}
