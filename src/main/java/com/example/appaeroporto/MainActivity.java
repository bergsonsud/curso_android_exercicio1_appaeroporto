package com.example.appaeroporto;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends Activity {


    TextView texto;
    ImageView imagem;
    Animation aparece;
    Animation some;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto =  findViewById(R.id.texto);
        imagem = findViewById(R.id.imagem);
        imagem.setVisibility(View.INVISIBLE);

        aparece = new AlphaAnimation(0,1);
        some = new AlphaAnimation(1,0);


        aparece.setDuration(1000);
        some.setDuration(1500);



        aparece.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                imagem.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imagem.setVisibility(View.VISIBLE);
                imagem.startAnimation(some);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        some.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                imagem.setVisibility(View.VISIBLE);

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imagem.setVisibility(View.INVISIBLE);
                texto.setText("Toque para continuar");
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

    public void clicou(View view) {
        if (sortear() < 0.5) {
            imagem.setScaleX(1f);
            texto.setText("Siga para esquerda");
        } else {
            imagem.setScaleX(-1f);
            texto.setText("Siga para direita");
        }

        imagem.startAnimation(aparece);

        Timer timer = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                imagem.setAnimation(some);
            }
        };


        timer.schedule(tt, 2000);





    }

    public float sortear(){
        final float random = (float) Math.random();
        Log.i("Random", String.valueOf(random));
        return random;
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
