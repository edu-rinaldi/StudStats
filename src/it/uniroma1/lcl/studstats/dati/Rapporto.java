package it.uniroma1.lcl.studstats.dati;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

/**
 * Contiene tutte le informazioni su un Rapporto generato:
 * <ul>
 *     <li>Tipo del Rapporto</li>
 *     <li>Mappa del Rapporto</li>
 * </ul>
 */
public class Rapporto
{
    private TipoRapporto tipoRapporto;
    private HashMap<String, ? extends AbstractMap<String,? extends Number>> rapporto;

    /**
     * Costruisce un rapporto conoscendo il tipo e la mappa delle informazioni
     * @param tipoRapporto Enum tipo del Rapporto
     * @param rapporto mappa del Rapporto
     */
    public Rapporto(TipoRapporto tipoRapporto, HashMap<String,
                    ? extends AbstractMap<String,? extends Number>> rapporto)
    {
        this.tipoRapporto = tipoRapporto;
        this.rapporto = rapporto;
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public String toString() {return rapporto.toString();}

    /**
     * Restituisce la mappa contenente le informazioni analizzate.
     * Questo metodo è public per poter permettere di utilizzare queste
     * informazioni in classi esterne (es. grafici, gui, etc..)
     * @return la mappa del Rapporto
     */
    public HashMap<String,? extends AbstractMap<String,? extends Number>> getRapporto() {return rapporto;}

    /**
     * Restituisce il tipo del Rapporto generato.
     * @return tipo del Rapporto
     */
    public TipoRapporto getTipoRapporto() {return tipoRapporto;}
}
