package br.com.andersonmatte.cavaleirosplayer.projeto.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import br.com.andersonmatte.cavaleirosplayer.R;
import br.com.andersonmatte.cavaleirosplayer.projeto.entidade.Saga;
import br.com.andersonmatte.cavaleirosplayer.projeto.recycler.RecyclerViewSaga;

public class SagaActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "SagaActivity";
    private ArrayList<Saga> listaSaga = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saga);
        //Popula a lista de sagas.
        this.montaListaSaga();
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new RecyclerViewSaga(listaSaga, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void montaListaSaga() {
        Saga saga1 = new Saga();
        saga1.setNomeSaga(this.getResources().getString(R.string.saga1));
        saga1.setImagemSaga("@drawable/sagasantuario");
        this.listaSaga.add(saga1);
        Saga saga2 = new Saga();
        saga2.setNomeSaga(this.getResources().getString(R.string.saga2));
        saga2.setImagemSaga("@drawable/sagaasgard");
        this.listaSaga.add(saga2);
        Saga saga3 = new Saga();
        saga3.setNomeSaga(this.getResources().getString(R.string.saga3));
        saga3.setImagemSaga("@drawable/sagaposeidon");
        this.listaSaga.add(saga3);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ((RecyclerViewSaga) mAdapter).setOnItemClickListener(new RecyclerViewSaga
                .MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                //prepara o objeto para passar para a VideoPlayerActivity.
                Saga saga = listaSaga.get(position);
                Bundle bundle = new Bundle();
                bundle.putSerializable("resultado", saga);
                //Chama a VideoPlayerActivity já com o objeto populado.
                Intent intent = new Intent(SagaActivity.this, VideoPlayerActivity.class);
                intent.putExtra("saga", bundle);
                startActivity(intent);
                Log.i(LOG_TAG, " Clicked on Item " + position);
            }
        });
    }

}
