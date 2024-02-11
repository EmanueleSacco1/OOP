/**
 *
 */

import java.util.ArrayList;
import java.util.List;

/**
 *
 */

//Classe Squadra
public class Squadra extends DatoGara {
    private int punteggio;
    private List<String> listaMembri;
    private String tipoZonaAppartenenza;

    public Squadra(String nome, String tipoZonaAppartenenza) {
        super(nome);
        this.punteggio = 0;
        this.listaMembri = new ArrayList<>(2);
        this.tipoZonaAppartenenza = tipoZonaAppartenenza;
    }

    public void aggiungiMembro(String membro) {
        listaMembri.add(membro);
    }

    public void aggiornaPunteggio(int punti) {
        punteggio += punti;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public String getTipoZonaAppartenenza() {
        return tipoZonaAppartenenza;
    }

    public boolean squadraCompleta() {
        return listaMembri.size() == 2;
    }
}
