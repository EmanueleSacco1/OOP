/**
 *
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 */
//Classe GestoreCompetizione: questa classe sembra essere un gestore che utilizza un DataReader per popolare e gestire un insieme di Squadra e SfidaTecnologica
public class GestoreCompetizione {
    private List<Squadra> squadre;
    private List<SfidaTecnologica> sfide;
    private List<Zona> zone;
    private DataReader dataReader;

    public GestoreCompetizione(DataReader dataReader) {
        squadre = new ArrayList<Squadra>();
        sfide = new ArrayList<SfidaTecnologica>();
        zone = new ArrayList<Zona>();
        this.dataReader = dataReader;
    }

    public void caricaDati() throws IOException {
        squadre.addAll(dataReader.leggiDatoGara("Squadra").stream().map(dato -> (Squadra) dato).collect(Collectors.toList()));
        sfide.addAll(dataReader.leggiDatoGara("SfidaTecnologica").stream().map(dato -> (SfidaTecnologica) dato).collect(Collectors.toList()));
        zone.addAll(dataReader.leggiDatoGara("Zona").stream().map(dato -> (Zona) dato).collect(Collectors.toList()));
    }


    // Task 1: Analisi delle Squadre per Zona (questo blocco di codice analizza le squadre per zona, identifica il numero di squadre in ogni zona e trova la squadra con il punteggio più alto in ogni zona).
    public void analisiSquadrePerZona() {
        Map<String, List<Squadra>> squadrePerZona = new HashMap<>();
        for (Squadra squadra : squadre) {
            String zona = squadra.getTipoZonaAppartenenza();
            if (!squadrePerZona.containsKey(zona)) {
                squadrePerZona.put(zona, new ArrayList<>());
            }
            squadrePerZona.get(zona).add(squadra);
        }

        for (Map.Entry<String, List<Squadra>> entry : squadrePerZona.entrySet()) {
            String zona = entry.getKey();
            List<Squadra> squadreInZona = entry.getValue();
            Squadra squadraConPunteggioMaggiore = Collections.max(squadreInZona, Comparator.comparing(Squadra::getPunteggio));
            System.out.println(zona + ": " + squadreInZona.size() + ", " + squadraConPunteggioMaggiore.getNome());
        }
    }

    // Task 2: Calcolo del Punteggio Totale per Ogni Zona (questo blocco di codice calcola e stampa il punteggio totale accumulato per ogni zona basato sulle sfide tecnologiche).
    public void calcoloPunteggioTotalePerOgniZona() {
        Map<String, Integer> punteggioTotalePerZona = new HashMap<>();
        for (SfidaTecnologica sfida : sfide) {
            String zona = sfida.getZonaSfida();
            if (!punteggioTotalePerZona.containsKey(zona)) {
                punteggioTotalePerZona.put(zona, 0);
            }
            punteggioTotalePerZona.put(zona, punteggioTotalePerZona.get(zona) + sfida.getPuntiSfida());
        }

        for (Map.Entry<String, Integer> entry : punteggioTotalePerZona.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Task 3: Analisi delle Prestazioni delle Squadre nelle Sfide (questo blocco di codice analizza le prestazioni di ogni squadra nelle sfide tecnologiche che si svolgono nella stessa zona di appartenenza della squadra e stampa i risultati).
    public void analisiPrestazioniSquadreNelleSfide() {
        Map<String, List<Squadra>> squadrePerZona = new HashMap<>();
        for (Squadra squadra : squadre) {
            String tipozona = squadra.getTipoZonaAppartenenza();
            for (Zona zona : zone) {
                if (zona.getTipoZona().equals(tipozona)) {
                    squadrePerZona.putIfAbsent(tipozona, new ArrayList<>());
                    squadrePerZona.get(tipozona).add(squadra);
                    break;
                }
            }
        }
        for (Map.Entry<String, List<Squadra>> entry : squadrePerZona.entrySet()) {
            List<Squadra> squadreNellaZona = entry.getValue();

            for (Squadra squadra : squadreNellaZona) {
                System.out.print(squadra.getNome() + ": [");
                for (SfidaTecnologica sfida : sfide) {
                        for (Zona zona : zone) {
                            if (squadra.getTipoZonaAppartenenza().equals(zona.getTipoZona())
                                    && sfida.getZonaSfida().equals(zona.getNome())) {
                                System.out.print(sfida.getNome() + ": " + sfida.getPuntiSfida() + ", ");
                                break;
                            }
                        }
                }
                System.out.println("], " + squadra.getPunteggio());
            }
        }
    }
}


