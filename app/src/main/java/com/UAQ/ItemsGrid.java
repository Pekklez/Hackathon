package com.UAQ;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by Adolfo on 05/11/2016.
 */

public class ItemsGrid  extends AppCompatActivity{

    ImageButton imageButton1,imageButton2,imageButton3,imageButton4,imageButton5,imageButton6,
            imageButton7,imageButton8,imageButton9,imageButton10;

    ImageView imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,
    imageView9,imageView10;

    TextView name1,name1,textView3,textView4,textView5,textView6,textView7,textView8,textView9,
            textView10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.grid_item);

        imageButton1 = (ImageButton)findViewById(R.id.image_buton1);
        imageButton2 = (ImageButton)findViewById(R.id.image_buton2);
        imageButton3 = (ImageButton)findViewById(R.id.image_buton3);
        imageButton4 = (ImageButton)findViewById(R.id.image_buton4);
        imageButton5 = (ImageButton)findViewById(R.id.image_buton5);
        imageButton6 = (ImageButton)findViewById(R.id.image_buton6);
        imageButton7 = (ImageButton)findViewById(R.id.image_buton7);
        imageButton8 = (ImageButton)findViewById(R.id.image_buton8);
        imageButton9 = (ImageButton)findViewById(R.id.image_buton9);
        imageButton10 = (ImageButton)findViewById(R.id.image_buton10);

        ImageView image = (ImageView) findViewById(R.id.);
        Glide.with(image.getContext()).load(item.getIdThumbnail()).into(image);

        // Seteando Nombre
        TextView name = (TextView) view.findViewById(R.id.nombre);
        name.setText(item.getNombre());

        // Seteando Descripción
        TextView descripcion = (TextView) view.findViewById(R.id.descripcion);
        descripcion.setText(item.getDescripcion());

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        imageButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        imageButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        imageButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        imageButton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });




    }
}
