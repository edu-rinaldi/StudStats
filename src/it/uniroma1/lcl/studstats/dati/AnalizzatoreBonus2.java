package it.uniroma1.lcl.studstats.dati;

import it.uniroma1.lcl.studstats.dati.rapporti.RapportoBase;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @author eduardo_rinaldi
 */

/**
 * Quali sono i 5 istituti che hanno piu voti in una fascia di voti?
 */
public class AnalizzatoreBonus2 extends AnalizzatoreBasic implements Analizzatore
{
    private int inizio;
    private int fine;


    public AnalizzatoreBonus2(int inizio, int fine)
    {
        this.inizio = inizio;
        this.fine = fine;
    }


    @Override
    public Rapporto generaRapporto(Collection<Studente> studs)
    {
        return new AnalizzatoreIstituti().generaRapporto(studs.stream()
                .filter(st->{
                    int a = Integer.parseInt(st.get("MaxDiVOTO"));
                    return a>=inizio && a<=fine;
                })
                .collect(Collectors.toList()));

    }

    @Override
    public TipoRapporto getTipo() {return RapportoBase.BONUS; }

    public int getInizio() {return inizio; }
    public int getFine() {return fine; }

}
