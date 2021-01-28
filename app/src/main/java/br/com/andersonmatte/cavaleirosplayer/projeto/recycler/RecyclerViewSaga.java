package br.com.andersonmatte.cavaleirosplayer.projeto.recycler;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import br.com.andersonmatte.cavaleirosplayer.R;
import br.com.andersonmatte.cavaleirosplayer.projeto.entidade.Saga;

public class RecyclerViewSaga extends RecyclerView.Adapter<RecyclerViewSaga.DataObjectHolder> {
    private Context context;
    private static String LOG_TAG = "RecyclerViewSaga";
    private ArrayList<Saga> mDataset;
    private static MyClickListener myClickListener;

    public static class DataObjectHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        AppCompatImageView imageViewSaga;
        AppCompatTextView textViewName;

        public DataObjectHolder(View itemView) {
            super(itemView);
            imageViewSaga = (AppCompatImageView) itemView.findViewById(R.id.imageViewSaga);
            textViewName = (AppCompatTextView) itemView.findViewById(R.id.textName);
            Log.i(LOG_TAG, "Adding Listener");
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getAdapterPosition(), v);
        }
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public RecyclerViewSaga(ArrayList<Saga> myDataset, Context context) {
        this.mDataset = myDataset;
        this.context = context;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_sagas, parent, false);
        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        holder.imageViewSaga.setImageResource(R.drawable.ic_launcher_background);
        if (mDataset.get(position).getNomeSaga() != null) {
            holder.textViewName.setText(mDataset.get(position).getNomeSaga());
            //Busca a imagem da Saga.
            int imagemSaga = this.context.getResources().getIdentifier(mDataset.get(position).getImagemSaga(), null, this.context.getPackageName());
            Drawable drawable = ContextCompat.getDrawable(this.context, imagemSaga);
            holder.imageViewSaga.setImageDrawable(drawable);
        }
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

}
