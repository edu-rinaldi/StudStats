package it.uniroma1.lcl.studstats;



/**
 * @author eduardo_rinaldi
 */

import it.uniroma1.lcl.studstats.dati.*;
import it.uniroma1.lcl.studstats.util.CSVParser;

import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * La classe Studstats e' un aggregatore statistico
 * che lavora su dati riguardanti gli studenti.
 */
public class Studstats implements AggregatoreStatistico
{
    private List<Studente> studenti;
    private LinkedHashSet<Analizzatore> analizzatori;

    /**
     * Il costruttore inizializza con un ArrayList vuoto di studenti la lista studenti.
     * Inoltre inizializza con un LinkedHashSet vuoto di analizzatori, il set di analizzatori.
     */
    private Studstats()
    {
        this.studenti = new ArrayList<>();
        this.analizzatori = new LinkedHashSet<>();
    }

    /**
     * Aggiunge uno studente alla lista studenti.
     * @param s studente da aggiungere
     */
    @Override
    public void add(Studente s) {studenti.add(s);}

    /**
     * Aggiunge un analizzatore al set di analizzatori.
     * @param an analizzatore da aggiungere
     */
    @Override
    public void add(Analizzatore an) {analizzatori.add(an); }

    /**
     * Genera tutti i rapporti dei tipi specificati, se e solo se,
     * tra gli analizzatori ce n'è uno che possa generare quel
     * tipo di rapporto.
     * @param tipiRapporto i tipi di cui si vogliono i rapporti
     * @return una lista con tutti i rapporti generati
     */
    @Override
    public List<Rapporto> generaRapporti(TipoRapporto... tipiRapporto)
    {
        return analizzatori.stream()
                            .filter(an-> Stream.of(tipiRapporto).anyMatch(tR -> tR == an.getTipo()))
                            .map(an -> an.generaRapporto(studenti))
                            .collect(Collectors.toList());
    }

    /**
     * Overload del metodo generaRapporti senza parametri,
     * genera rapporti con ogni analizzatore presente nel set
     * degli analizzatori
     * @return una lista con tutti i rapporti generati
     */
    public List<Rapporto> generaRapporti()
    {
        return generaRapporti(analizzatori.stream()
                .map(Analizzatore::getTipo)
                .toArray(TipoRapporto[]::new));
    }

    /**
     *
     * @return numero degli analizzatori aggiunti
     */
    @Override
    public int numeroAnalizzatori() {return analizzatori.size(); }

    /**
     * Permette la creazione di una nuova istanza di Studstats, ricevendo
     * come parametro una stringa contenente il path al file <strong>.csv</strong>.
     * Richiama e delega il compito di leggere il file al metodo readFile.
     * @param file path come String
     * @return un oggetto Studstats con dati memorizzati dal file .csv
     */
    public static Studstats fromFile(String file) {return readFile(new CSVParser(file)); }

    /**
     * Overload del metodo fromFile, fa la stessa cosa ma prende un Path
     * come parametro del metodo, delegando il compito di leggere il file,
     * al metodo readFile.
     * @param file path come oggetto Path
     * @return un oggetto Studstats con dati memorizzati dal file .csv
     */
    public static Studstats fromFile(Path file) {return readFile(new CSVParser(file)); }

    /**
     * Crea un oggetto Studstats, legge il file attraverso un parser,
     * e aggiunge i vari studenti presenti nel file letto alla lista studenti.
     * Il metodo viene reso privato perchè è un metodo di utilità per ottenere
     * un riuso del codice migliore su fromFile.
     * @param parser parser di un file CSV
     * @return un oggetto Studstats
     */
    private static Studstats readFile(CSVParser parser)
    {
        Studstats stats = new Studstats();
        new ArrayList<>(parser.parseFile())
                .forEach(mappaStudente-> stats.add(new Studente(mappaStudente)));
        return stats;
    }

    /**
     * @return studenti
     */
    public List<Studente> getStudenti() {return studenti;}

    /**
     *
     * @return analizzatori
     */
    public LinkedHashSet<Analizzatore> getAnalizzatori() {return analizzatori;}
}
