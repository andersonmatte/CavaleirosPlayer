package br.com.andersonmatte.cavaleirosplayer.projeto.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;


import br.com.andersonmatte.cavaleirosplayer.R;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        //Controla o tempo de exibição da Splash Screen.
        Handler handle = new Handler();
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                mostrarHome();
            }
        }, 3000);
    }

    //Chama a SagaActivity.
    private void mostrarHome() {
        Intent intent = new Intent(SplashScreenActivity.this, SagaActivity.class);
        startActivity(intent);
        finish();
    }

}
