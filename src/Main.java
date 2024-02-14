import java.io.IOException;
import java.util.List;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        DataReader fileDataReader = new FileDataReader("traccia_A.txt");
        GestoreCompetizione gestoreCompetizione = new GestoreCompetizione(fileDataReader);

        gestoreCompetizione.caricaDati();

        //questa riga di codice legge i dati della gara per le “Zone” dal file, li converte in una lista di oggetti Zona e assegna questa lista alla variabile zone
        List<Zona> zone = (List<Zona>)(List<?>) fileDataReader.leggiDatoGara("Zona");

        // Task 1: Analisi delle Squadre per Zona
        gestoreCompetizione.analisiSquadrePerZona(zone);

        // Task 2: Calcolo del Punteggio Totale per Ogni Zona
        gestoreCompetizione.calcoloPunteggioTotalePerOgniZona();

        // Task 3: Analisi delle Prestazioni delle Squadre nelle Sfide
        gestoreCompetizione.analisiPrestazioniSquadreNelleSfide();
    }
}