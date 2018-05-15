package it.uniroma1.lcl.studstats.util;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Collection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;

public class CSVParser
{
    private Path file;

    public CSVParser(String filePath) {this(Paths.get(filePath)); }
    public CSVParser(Path filePath) {this.file = filePath;}


    //ritorna una collezione di mappe, una mappa per ogni record
    public Collection<HashMap<String,String>> parseFile()
    {
        boolean primo = true;
        String[] keys = null;
        Collection<HashMap<String,String>> mapCollection = new ArrayList<>();

        try(BufferedReader br = Files.newBufferedReader(file))
        {
            keys = br.readLine().split(";");
            while(br.ready())
            {
                //prendo ogni riga, la splitto per ";"
                String[] infos = br.readLine().split(";");
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
