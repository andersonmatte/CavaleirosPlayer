package br.com.andersonmatte.cavaleirosplayer.projeto.entidade;

import java.io.Serializable;

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
public class Episodio implements Serializable {

    private String nomeEpisodio;

    private String urlEpisodio;

    private String codigoEpisodio;

}
