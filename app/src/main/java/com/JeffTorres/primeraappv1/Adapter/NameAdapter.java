package com.JeffTorres.primeraappv1.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.JeffTorres.primeraappv1.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NameAdapter extends RecyclerView.Adapter<NameAdapter.NameViewHolder>
{
    private List<String> Fondo1;

    public NameAdapter(List<String> animes)
    {
        this.Fondo1 = animes;

    }

    public NameViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.pantalla_1,parent ,false);
        return new NameViewHolder(view);
    }

    public void onBindViewHolder( NameViewHolder holder, int position)
    {
        ImageView imagen = holder.itemView.findViewById(R.id.fondo1);
        String link ="https://i.pinimg.com/originals/61/fb/12/61fb12bc6e014f3833f99843e66e167e.jpg";
        Picasso.get().load(link).into(imagen);

    }

    public int getItemCount()
    {
        return Fondo1.size();
    }

    class NameViewHolder extends  RecyclerView.ViewHolder
    {

        public NameViewHolder(View itemView)
        {
            super(itemView);
        }
    }
}
