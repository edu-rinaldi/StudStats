package it.uniroma1.lcl.studstats;

import it.uniroma1.lcl.studstats.dati.Analizzatore;
import it.uniroma1.lcl.studstats.dati.Rapporto;
import it.uniroma1.lcl.studstats.dati.Studente;
import it.uniroma1.lcl.studstats.dati.TipoRapporto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;

public class Studstats implements AggregatoreStatistico
{

    private HashSet<Studente> studenti;
    //TODO: Togliere List e mettere HashSet per gli analizzatori
    private List<Analizzatore> analizzatori;

    private Studstats(HashSet<Studente> studenti) {this.studenti = studenti;}

    @Override
    public void add(Studente s) {studenti.add(s);}

    @Override
    public void add(Analizzatore an) {analizzatori.add(an);}

    //TODO: generaRapporti
    @Override
    public List<Rapporto> generaRapporti(TipoRapporto... tipiRapporto)
    {
        return null;
    }
    //TODO: fromFile
    public static Studstats fromFile(String file)
    {
        boolean primo = true;
        HashSet<Studente> setStudenti = new HashSet<>();

        try(BufferedReader br = new BufferedReader(new FileReader(file)))
        {

            while(br.ready())
            {
                String[] dati = br.readLine().split(";");
                if (primo)
                {
                    primo=false;
                    continue;
                }
                for(int i=0; i<dati.length; i++)
                    if(dati[i].equals("")) dati[i] = null;
                setStudenti.add(new Studente(Studente.Sesso.valueOf(dati[0]), dati[1], dati[2], dati[3], dati[4], dati[5],
                        dati[6], Integer.parseInt(dati[7]), Integer.parseInt(dati[8])));
            }
        }
        catch(IOException e)
        {
            // gestisci l’eccezione di I/O
            System.out.println(e);
        }

        return new Studstats(setStudenti);

    }

    //getter
    public HashSet<Studente> getStudenti() {return studenti;}
    public List<Analizzatore> getAnalizzatori() {return analizzatori;}

    public static void main(String[] args)
    {
        Studstats s = Studstats.fromFile("src/it/uniroma1/lcl/studstats/");
        for(Studente s1: s.studenti) System.out.println(s1);
    }

}
