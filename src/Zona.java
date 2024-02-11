/**
 *
 */

import java.util.Objects;

/**
 *
 */
//Classe Zona: questa classe rappresenta una zona con un tipo specifico e fornisce un metodo per accedere a questo tipo.
public class Zona extends DatoGara {
    private String tipoZona;

    public Zona(String nome, String tipoZona) {
        super(nome);
        this.tipoZona = tipoZona;
    }

    public String getTipoZona() {
        return tipoZona;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Zona zona)) return false;
        return Objects.equals(getTipoZona(), zona.getTipoZona())
                && Objects.equals(getNome(), zona.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTipoZona(), getNome());
    }
}
