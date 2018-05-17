package it.uniroma1.lcl.studstats.dati;

import java.util.Optional;

public interface Analizzatori
{

    static Analizzatore annoDiploma() { return new AnalizzatoreAnnoDiploma(); }
    static Analizzatore istituti() { return new AnalizzatoreIstituti(); }
    static Analizzatore sesso() { return new AnalizzatoreSesso(); }
    static Analizzatore titoloDiStudio() {
        return new AnalizzatoreTitoloDiStudio(); }
    static Analizzatore voto() { return new AnalizzatoreVoto(); }
    static Analizzatore studentiVotoMaggiore(int voto) {
        return new AnalizzatoreStudentiVotoMaggiore(voto); }
    static Analizzatore studentiVotoMaggiore(int voto, Analizzatore a) {
        return new AnalizzatoreStudentiVotoMaggiore(voto, a); }
    /* inserire l'eventuale codice dell'analizzatore bonus
       al posto di return Optional.empty() */
    static Optional<Analizzatore> analizzatoreBonus() {return Optional.empty(); }
    static Analizzatore[] allBasic() { return new Analizzatore[] {
            annoDiploma(), istituti(),
            sesso(), titoloDiStudio(),
            voto() }; }
}
