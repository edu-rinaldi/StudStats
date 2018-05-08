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

public class CSVParser
{
    private Path file;

    public CSVParser(String filePath) {this(Paths.get(filePath)); }
    public CSVParser(Path filePath) {this.file = filePath;}


    //ritorna una collezione di mappe, una mappa per ogni record
    public Collection<Map> parseFile()
    {
        boolean primo = true;
        String[] keys = null;
        Collection<Map> mapCollection = new ArrayList<>();

        try(BufferedReader br = Files.newBufferedReader(file))
        {
            while(br.ready())
            {
                if (primo)
                {
                    keys = br.readLine().split(";");
                    primo = false;
                    continue;
                }

                //prendo ogni riga, la splitto per ";"
                String[] infos = br.readLine().split(";");

                //creo una nuova mappa temp.
                HashMap<String, String> mappa = new HashMap<>();

                //faccio il mapping
                for(int i=0; i<infos.length; i++) mappa.put(keys[i], infos[i]);

                mapCollection.add(mappa);
            }
        }
        catch(IOException e) {System.out.println(e);}
        return mapCollection;
    }


}