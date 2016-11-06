package com.UAQ;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

/**
 * {@link BaseAdapter} personalizado para el gridview
 */
public class GridAdapter extends BaseAdapter {

    private final Context mContext;
    private final Product[] items;

    public GridAdapter(Context c, Product[] items) {
        mContext = c;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Product getItem(int position) {
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.grid_item, viewGroup, false);
        }

        final Product item = getItem(position);

        // Seteando Imagen
        final ImageView image = (ImageView) view.findViewById(R.id.imagen);
        Glide.with(image.getContext()).load(item.getIdThumbnail()).into(image);

        // Seteando Nombre
        final TextView name = (TextView) view.findViewById(R.id.nombre);
        name.setText(item.getNombre());

        // Seteando Descripción
        TextView descripcion = (TextView) view.findViewById(R.id.descripcion);
        descripcion.setText(item.getDescripcion());

        // Seteando Precio
        final TextView precio = (TextView) view.findViewById(R.id.precio);
        precio.setText(item.getPrecio());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(mContext, DetailActivity.class);
                myIntent.putExtra("EXTRA_NAME", name.getText());
                myIntent.putExtra("EXTRA_DRAWABLE", item.getIdThumbnail());
                myIntent.putExtra("EXTRA_DESCRIPCION", item.getDescripcion());
                v.getContext().startActivity(myIntent);
                Toast.makeText(mContext, name.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}