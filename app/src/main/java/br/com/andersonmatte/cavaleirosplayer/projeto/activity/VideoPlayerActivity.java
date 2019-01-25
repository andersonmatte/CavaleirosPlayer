package br.com.andersonmatte.cavaleirosplayer.projeto.activity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import br.com.andersonmatte.cavaleirosplayer.R;
import br.com.andersonmatte.cavaleirosplayer.projeto.entidade.Episodio;
import br.com.andersonmatte.cavaleirosplayer.projeto.entidade.Saga;

public class VideoPlayerActivity extends AppCompatActivity {

    private Saga saga;
    private String TAG = "Executando Video";
    private VideoView videoView;
    List<Episodio> listaEpisodio = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        //Recebe os dados passados na Intent da Classe SagaActivity por mecanismo de Bundle.
        Bundle bundle = getIntent().getBundleExtra("saga");
        if (bundle != null) {
            this.saga = (Saga) bundle.getSerializable("resultado");
            videoView = findViewById(R.id.video_view);
            // Checa a saga recebida e .
            this.populaListaEpisodiosPorSaga(this.saga.getNomeSaga());
            if (!this.listaEpisodio.isEmpty()) {
                this.executaVideo(this.listaEpisodio.get(0).getUrlEpisodio());
            }
        }
    }

    private void populaListaEpisodiosPorSaga(String nomeSaga) {
        int idJson = 0;
        try {
            switch (nomeSaga) {
                case "Saga do Santuário":
                    idJson = R.raw.saga_santuario;
                    break;
                case "Saga de Asgard":
                    idJson = R.raw.saga_asgard;
                    break;
                case "Saga de Poseidon":
                    idJson = R.raw.saga_poseidon;
                    break;
                case "Saga de Hades":
                    idJson = R.raw.saga_hades;
                    break;
            }

            BufferedReader jsonReader = new BufferedReader(new InputStreamReader(this.getResources().openRawResource(idJson)));
            StringBuilder jsonBuilder = new StringBuilder();
            for (String line = null; (line = jsonReader.readLine()) != null; ) {
                jsonBuilder.append(line).append("\n");
            }

            JSONTokener tokener = new JSONTokener(jsonBuilder.toString());
            JSONArray jsonArray = new JSONArray(tokener);

            if (jsonArray != null) {
                this.listaEpisodio = new Gson().fromJson(jsonArray.toString(), new TypeToken<List<Episodio>>() {
                }.getType());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    //Método responsável pela execução dos videos.
    public void executaVideo(String urlVideo){
        videoView.setVideoPath(urlVideo);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Log.i(TAG, "Duration = " +
                        videoView.getDuration());
            }
        });
        videoView.start();
    }

}
