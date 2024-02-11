import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        DataReader fileDataReader = new FileDataReader("traccia_A.txt");
        GestoreCompetizione gestoreCompetizione = new GestoreCompetizione(fileDataReader);

        gestoreCompetizione.caricaDati();

        // Task 1: Analisi delle Squadre per Zona
        gestoreCompetizione.analisiSquadrePerZona();

        // Task 2: Calcolo del Punteggio Totale per Ogni Zona
        gestoreCompetizione.calcoloPunteggioTotalePerOgniZona();

        // Task 3: Analisi delle Prestazioni delle Squadre nelle Sfide
        gestoreCompetizione.analisiPrestazioniSquadreNelleSfide();
    }
}