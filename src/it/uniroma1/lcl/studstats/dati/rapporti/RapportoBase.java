package it.uniroma1.lcl.studstats.dati.rapporti;

import it.uniroma1.lcl.studstats.dati.TipoRapporto;

/**
 * Enum di tutti i tipi di rapporti che possono essere
 * creati attraverso i vari Analizzatori.
 */
public enum RapportoBase implements TipoRapporto
{
    ANNO_DIPLOMA,
    ISTITUTI,
    SESSO,
    TITOLO,
    VOTO,
    VOTO_MAGGIORE,
    BONUS;
}
