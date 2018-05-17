package it.uniroma1.lcl.studstats;

import it.uniroma1.lcl.studstats.dati.*;
import it.uniroma1.lcl.studstats.dati.rapporti.RapportoBase;
import it.uniroma1.lcl.studstats.util.CSVParser;

import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//TODO: JavaDoc
public class Studstats implements AggregatoreStatistico
{
    private List<Studente> studenti;
    private LinkedHashSet<Analizzatore> analizzatori;

    private Studstats()
    {
        this.studenti = new ArrayList<>();
        this.analizzatori = new LinkedHashSet<>();
    }

    @Override
    public void add(Studente s) {studenti.add(s);}

    @Override
    public void add(Analizzatore an) {analizzatori.add(an); }

    @Override
    public List<Rapporto> generaRapporti(TipoRapporto... tipiRapporto)
    {
        return analizzatori.stream()
                            .filter(an-> Stream.of(tipiRapporto).anyMatch(tR -> tR == an.getTipo()))
                            .map(an -> an.generaRapporto(studenti))
                            .collect(Collectors.toList());
    }

    public List<Rapporto> generaRapporti()
    {
        return generaRapporti(analizzatori.stream()
                .map(Analizzatore::getTipo)
                .toArray(TipoRapporto[]::new));
    }

    @Override
    public int numeroAnalizzatori() {return analizzatori.size(); }

    public static Studstats fromFile(String file) {return  readFile(new CSVParser(file)); }

    public static Studstats fromFile(Path file) {return readFile(new CSVParser(file)); }

    private static Studstats readFile(CSVParser parser)
    {
        //nuova istanza Studstats
        Studstats stats = new Studstats();
        new ArrayList<>(parser.parseFile())
                .forEach(mappaStudente-> stats.add(new Studente(mappaStudente)));
        return stats;
    }

    //getter
    public List<Studente> getStudenti() {return studenti;}
    public LinkedHashSet<Analizzatore> getAnalizzatori() {return analizzatori;}
}
