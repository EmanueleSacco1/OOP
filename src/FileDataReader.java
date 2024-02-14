/**
 *
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.util.List;


/**
 *
 */
//Classe FileDataReader
public class FileDataReader implements DataReader {
    private final String filePath;
    public FileDataReader(String filePath) {
        this.filePath = filePath;
    }

    private static String[] splitSection(String sezione) {
        return sezione.split("\n");
    }

    @Override
    public List<DatoGara> leggiDatoGara(String tipoDato) throws IOException {
        List<DatoGara> datiGara = new ArrayList<>();
        try {
            Scanner fileInput = new Scanner(new FileInputStream(filePath)); //Lettura dal file
            fileInput.useDelimiter("###");
            String[] sezioni = new String[3];
            int i = 0;
            while (fileInput.hasNext()) {
                sezioni[i] = fileInput.next().trim(); //Il metodo trim() in Java è un metodo integrato della classe String che elimina gli spazi bianchi iniziali e finali di una stringa
                i++;
            }
            switch (tipoDato) {
                case "Zona": //elabora una sezione di dati, dividendo ogni evento in quella sezione in argomenti, creando un nuovo oggetto Zona con quegli argomenti e aggiungendo quell’oggetto a una lista.
                    String[] lista1 = splitSection(sezioni[0]);
                    for (String evento : lista1) {
                        String[] argomenti = evento.split(",");
                        datiGara.add(new Zona(argomenti[0], argomenti[1]));
                    }
                    break;
                case "Squadra": //elabora una sezione di dati, dividendo ogni evento in quella sezione in argomenti, creando un nuovo oggetto Squadra con quegli argomenti, aggiornando il punteggio della squadra, aggiungendo membri alla squadra e infine aggiungendo quella squadra a una lista.
                    String[] lista2 = splitSection(sezioni[1]);

                    for (String evento : lista2) {
                        String[] argomenti = evento.split(",");
                        Squadra squadra = new Squadra(argomenti[0], argomenti[argomenti.length - 1]);
                        squadra.aggiornaPunteggio(Integer.parseInt(argomenti[1]));
                        for (int j = 2; j < argomenti.length - 1; j++) {
                            squadra.aggiungiMembro(argomenti[j]);
                        } //ciclo for che itera su ogni elemento dell'array "argomenti" a partire dal terzo membro fino al penultimo per aggirare possibili errori qualora i membri siano più o meno di 2
                        datiGara.add(squadra);
                    }
                    break;
                case "SfidaTecnologica": //elabora una sezione di dati, dividendo ogni evento in quella sezione in argomenti, creando un nuovo oggetto SfidaTecnologica con quegli argomenti e infine aggiungendo quella sfida tecnologica a una lista
                    String[] lista3 = splitSection(sezioni[2]);

                    for (String evento : lista3) {
                        String[] argomenti = evento.split(",");
                        datiGara.add(new SfidaTecnologica(argomenti[0], argomenti[1], argomenti[2], argomenti[3], Integer.parseInt(argomenti[4])));
                    }
                    break;
            }
        } catch (FileNotFoundException e) {
            System.out.println("FILE NON TROVATO!");
        }
        return datiGara;
    }
}