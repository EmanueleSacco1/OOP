/**
 *
 */

/**
 *
 */
//Classe SfidaTecnologica: questa classe rappresenta una sfida tecnologica con attributi specifici come zona, oggetto, difficoltà e punti, e fornisce metodi per accedere a questi attributi.
public class SfidaTecnologica extends DatoGara {
    private String zonaSfida;
    private String oggettoSfida;
    private String difficoltaSfida;
    private int puntiSfida;

    public SfidaTecnologica(String nome, String zonaSfida, String oggettoSfida, String difficoltaSfida, int puntiSfida) {
        super(nome);
        this.zonaSfida = zonaSfida;
        this.oggettoSfida = oggettoSfida;
        this.difficoltaSfida = difficoltaSfida;
        this.puntiSfida = puntiSfida;
    }

    public String getNomeSfida() {
        return getNome();
    }

    public String getOggettoSfida() {
        return oggettoSfida;
    }

    public String getDifficoltaSfida() {
        return difficoltaSfida;
    }

    public int getPuntiSfida() {
        return puntiSfida;
    }

    public String getZonaSfida() {
        return zonaSfida;
    }
}
