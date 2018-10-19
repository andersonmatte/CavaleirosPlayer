package br.com.andersonmatte.cavaleirosplayer.projeto.entidade;

import java.io.Serializable;
import java.util.List;

public class Saga implements Serializable {

    private String nomeSaga;

    private List<String> nomeSubSaga;

    private String imagemSaga;

    public String getNomeSaga() {
        return nomeSaga;
    }

    public void setNomeSaga(String nomeSaga) {
        this.nomeSaga = nomeSaga;
    }

    public List<String> getNomeSubSaga() {
        return nomeSubSaga;
    }

    public void setNomeSubSaga(List<String> nomeSubSaga) {
        this.nomeSubSaga = nomeSubSaga;
    }

    public String getImagemSaga() {
        return imagemSaga;
    }

    public void setImagemSaga(String imagemSaga) {
        this.imagemSaga = imagemSaga;
    }

}
