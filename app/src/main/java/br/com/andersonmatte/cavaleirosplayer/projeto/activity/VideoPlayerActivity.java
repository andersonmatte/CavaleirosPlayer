package br.com.andersonmatte.cavaleirosplayer.projeto.activity;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

import br.com.andersonmatte.cavaleirosplayer.R;
import br.com.andersonmatte.cavaleirosplayer.projeto.entidade.Saga;

public class VideoPlayerActivity extends AppCompatActivity {

    private Saga saga;
    String TAG = "com.ebookfrenzy.videoplayer";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Recebe os dados passados na Intent da Classe SagaActivity por mecanismo de Bundle.
        Bundle bundle = getIntent().getBundleExtra("saga");
        if (bundle != null) {
            this.saga = (Saga) bundle.getSerializable("resultado");
            this.executaVideo();
        }
        setContentView(R.layout.activity_video_player);
    }

    //Método responsável pela execução dos videos.
    public void executaVideo(){
        final VideoView videoView = (VideoView) findViewById(R.id.video_view);
        videoView.setVideoPath("http://www.ebookfrenzy.com/android_book/movie.mp4");
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
