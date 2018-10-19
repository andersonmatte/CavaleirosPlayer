package br.com.andersonmatte.cavaleirosplayer.projeto.entidade;

import java.io.Serializable;

public class Episodio implements Serializable {

    private String nomeEpisodio;

    private String urlEpisodio;

    private String codigoEpisodio;

    public String getNomeEpisodio() {
        return nomeEpisodio;
    }

    public void setNomeEpisodio(String nomeEpisodio) {
        this.nomeEpisodio = nomeEpisodio;
    }

    public String getUrlEpisodio() {
        return urlEpisodio;
    }

    public void setUrlEpisodio(String urlEpisodio) {
        this.urlEpisodio = urlEpisodio;
    }

    public String getCodigoEpisodio() {
        return codigoEpisodio;
    }

    public void setCodigoEpisodio(String codigoEpisodio) {
        this.codigoEpisodio = codigoEpisodio;
    }

}
