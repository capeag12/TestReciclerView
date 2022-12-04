package com.example.testreciclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

//La clase AdapterDatos extenderá de RecyclerView.Aparter, la cual es una clase generica que contendrá otra clase llamada AdapterDatos.ViewHolder, la cual crearemos nosotros
public class AdapterDatos extends RecyclerView.Adapter<AdapterDatos.ViewHolder> {
    //Esta contiene obligatoriamente un dataSet y un contexto
    private List mDataset;
    private Context context;
    private int selectedIndex;

    public AdapterDatos(Context context) {
        this.context = context;
        mDataset = new ArrayList();
    }

    public void add(Item i){
        mDataset.add(i);
        notifyItemInserted(mDataset.indexOf(i));
    }

    public void remove(Item item) {
        int position = mDataset.indexOf(item);

        if(position != -1) {
            mDataset.remove(position);
            notifyItemRemoved(position);
        }
    }

    //El método onCreateViewHolder es un método sobrecargado de Adapter, el cual asignará el layout al ViewHolder y lo retornará
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflará el layout del listItem
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }
    //onBindViewHolder provee de los datos al viewViewHolder de cada posición del dataSet
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Item item = (Item) mDataset.get(position);
        holder.imageView.setImageDrawable(item.getImageSRC());
        holder.mTextView.setText(item.getName());

        //Podemos asignar eventos a los componentes del viewHolder
        holder.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedIndex = position;
                System.out.println(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    //Creamos la clase viewHolder, la cual corresponde a la clase que pasamos a RecyclerView.Adapter<AdapterDatos.ViewHolder>, esta debe tener los componentes correspondientes
    // a list_item.xml
    public static class ViewHolder extends RecyclerView.ViewHolder {

        protected ImageView imageView;
        protected TextView mTextView;
        protected Switch s;
        public ViewHolder(View v) {
            super(v);
            imageView = (ImageView) v.findViewById(R.id.ivItem);
            mTextView = (TextView) v.findViewById(R.id.tvItem);
            s = (Switch) v.findViewById(R.id.switch1);
        }
    }
}


