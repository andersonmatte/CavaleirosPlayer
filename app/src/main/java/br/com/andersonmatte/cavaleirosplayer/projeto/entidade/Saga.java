package br.com.andersonmatte.cavaleirosplayer.projeto.entidade;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Saga implements Serializable {

    private String nomeSaga;

    private List<String> nomeSubSaga;

    private String imagemSaga;

}
