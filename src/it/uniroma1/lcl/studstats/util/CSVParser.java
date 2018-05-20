package it.uniroma1.lcl.studstats.util;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * @author eduardo_rinaldi
 */
/**
 * Parser di file CSV su una Collezione di righe.
 * Queste sono rappresentate come mappe con coppia chiave-valore
 * del tipo {@code <colonna,valore>}, così da ottenere una tabella.
 */
public class CSVParser
{
    private Path file;

    /**
     * Costruisce un oggetto CSVParser a partire da un
     * uno String path locale o assoluto al file .csv
     * @param filePath di tipo String
     */
    public CSVParser(String filePath) {this(Paths.get(filePath)); }

    /**
     * Costruisce un oggetto CSVParser a partire da un
     * oggetto Path che contiene un percorso locale o
     * assoluto al file .csv
     * @param filePath di tipo
     */
    public CSVParser(Path filePath) {this.file = filePath;}


    /**
     * Fa il parse del file, restituendo una collezione di mappe.
     * @param separator separatore delle colonne
     * @return una collezione di mappe, dove ogni mappa è una riga del file
     */
    public Collection<HashMap<String,String>> parseFile(String separator)
    {
        String[] keys;
        Collection<HashMap<String,String>> mapCollection = new ArrayList<>();

        try(BufferedReader br = Files.newBufferedReader(file))
        {
            keys = br.readLine().split(separator);
            while(br.ready())
            {
                //prendo ogni riga, la splitto per ";"
                String[] infos = br.readLine().split(separator);
                //creo una nuova mappa temp.
                HashMap<String, String> mappa = new HashMap<>();

                //faccio il mapping
                for(int i=0; i<infos.length; i++) mappa.put(keys[i], infos[i]);
                mapCollection.add(mappa);
            }
        }
        catch(IOException e) {e.printStackTrace();}
        return mapCollection;
    }
}
