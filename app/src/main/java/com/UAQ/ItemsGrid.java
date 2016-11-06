package com.UAQ;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Adolfo on 05/11/2016.
 */

public class ItemsGrid  extends AppCompatActivity{

    ImageButton imageButton1,imageButton2,imageButton3,imageButton4,imageButton5,imageButton6,
            imageButton7,imageButton8,imageButton9,imageButton10;

    ImageView imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,
    imageView9,imageView10;

    TextView name1,name2,name3,name4,name5,name6,name7,name8,name9,name10;

    TextView descripcion1,descripcion2,descripcion3,descripcion4,descripcion5,descripcion6,
            descripcion7,descripcion8,descripcion9,descripcion10;

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

        imageView1 = (ImageView)findViewById(R.id.profile_image1);
        imageView2 = (ImageView)findViewById(R.id.profile_image2);
        imageView3 = (ImageView)findViewById(R.id.profile_image3);
        imageView4 = (ImageView)findViewById(R.id.profile_image4);
        imageView5 = (ImageView)findViewById(R.id.profile_image5);
        imageView6 = (ImageView)findViewById(R.id.profile_image6);
        imageView7 = (ImageView)findViewById(R.id.profile_image7);
        imageView8 = (ImageView)findViewById(R.id.profile_image8);
        imageView9 = (ImageView)findViewById(R.id.profile_image9);
        imageView10 = (ImageView)findViewById(R.id.profile_image10);

        name1 = (TextView)findViewById(R.id.nombre1);
        name2 = (TextView)findViewById(R.id.nombre2);
        name3 = (TextView)findViewById(R.id.nombre3);
        name4 = (TextView)findViewById(R.id.nombre4);
        name5 = (TextView)findViewById(R.id.nombre5);
        name6 = (TextView)findViewById(R.id.nombre6);
        name7 = (TextView)findViewById(R.id.nombre7);
        name8 = (TextView)findViewById(R.id.nombre8);
        name9 = (TextView)findViewById(R.id.nombre9);
        name10 = (TextView)findViewById(R.id.nombre10);

        descripcion1 = (TextView)findViewById(R.id.descripcion1);
        descripcion2 = (TextView)findViewById(R.id.descripcion2);
        descripcion3 = (TextView)findViewById(R.id.descripcion3);
        descripcion4 = (TextView)findViewById(R.id.descripcion4);
        descripcion5 = (TextView)findViewById(R.id.descripcion5);
        descripcion6 = (TextView)findViewById(R.id.descripcion6);
        descripcion7 = (TextView)findViewById(R.id.descripcion7);
        descripcion8 = (TextView)findViewById(R.id.descripcion8);
        descripcion9 = (TextView)findViewById(R.id.descripcion9);
        descripcion10 = (TextView)findViewById(R.id.descripcion10);


        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplicationContext(), DetailActivity.class);
                myIntent.putExtra("EXTRA_NAME", name1.getText());                    // MODIFICAR NAME

                LatLng fromPosition = new LatLng(20.5919162,-100.3973391);           //  MODIFICAR LAT LNG

                imageView1.buildDrawingCache();
                Bitmap image= imageView1.getDrawingCache();

                Bundle extras = new Bundle();
                extras.putParcelable("imagebitmap", image);
                extras.putParcelable("from_position", fromPosition);
                myIntent.putExtras(extras);


                myIntent.putExtra("EXTRA_DESCRIPCION", descripcion1.getText());  // MODIFICAR DESCRIPCION
                v.getContext().startActivity(myIntent);
            }
        });
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(getApplicationContext(), DetailActivity.class);
                myIntent.putExtra("EXTRA_NAME", name2.getText());                    // MODIFICAR NAME

                LatLng fromPosition = new LatLng(20.5320625,-100.3632066);           //  MODIFICAR LAT LNG

                imageView2.buildDrawingCache();
                Bitmap image= imageView2.getDrawingCache();                         // MODIFICAR IMAGEVIEW

                Bundle extras = new Bundle();
                extras.putParcelable("imagebitmap", image);
                extras.putParcelable("from_position", fromPosition);
                myIntent.putExtras(extras);


                myIntent.putExtra("EXTRA_DESCRIPCION", descripcion2.getText());  // MODIFICAR DESCRIPCION
                v.getContext().startActivity(myIntent);
            }
        });
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplicationContext(), DetailActivity.class);
                myIntent.putExtra("EXTRA_NAME", name3.getText());                    // MODIFICAR NAME

                LatLng fromPosition = new LatLng(20.5928291,-100.3868695);           //  MODIFICAR LAT LNG

                imageView3.buildDrawingCache();
                Bitmap image= imageView3.getDrawingCache();

                Bundle extras = new Bundle();
                extras.putParcelable("imagebitmap", image);
                extras.putParcelable("from_position", fromPosition);
                myIntent.putExtras(extras);


                myIntent.putExtra("EXTRA_DESCRIPCION", descripcion3.getText());  // MODIFICAR DESCRIPCION
                v.getContext().startActivity(myIntent);

            }
        });
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(getApplicationContext(), DetailActivity.class);
                myIntent.putExtra("EXTRA_NAME", name4.getText());                    // MODIFICAR NAME

                LatLng fromPosition = new LatLng(20.5926205,-100.3932835);           //  MODIFICAR LAT LNG

                imageView4.buildDrawingCache();
                Bitmap image= imageView4.getDrawingCache();

                Bundle extras = new Bundle();
                extras.putParcelable("imagebitmap", image);
                extras.putParcelable("from_position", fromPosition);
                myIntent.putExtras(extras);


                myIntent.putExtra("EXTRA_DESCRIPCION", descripcion4.getText());  // MODIFICAR DESCRIPCION
                v.getContext().startActivity(myIntent);
            }
        });
        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(getApplicationContext(), DetailActivity.class);
                myIntent.putExtra("EXTRA_NAME", name5.getText());                    // MODIFICAR NAME

                LatLng fromPosition = new LatLng(20.5929527,-100.397889);           //  MODIFICAR LAT LNG

                imageView5.buildDrawingCache();
                Bitmap image= imageView5.getDrawingCache();

                Bundle extras = new Bundle();
                extras.putParcelable("imagebitmap", image);
                extras.putParcelable("from_position", fromPosition);
                myIntent.putExtras(extras);


                myIntent.putExtra("EXTRA_DESCRIPCION", descripcion5.getText());  // MODIFICAR DESCRIPCION
                v.getContext().startActivity(myIntent);
            }
        });
        imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(getApplicationContext(), DetailActivity.class);
                myIntent.putExtra("EXTRA_NAME", name6.getText());                    // MODIFICAR NAME

                LatLng fromPosition = new LatLng(20.5929525,-100.4044551);           //  MODIFICAR LAT LNG

                imageView6.buildDrawingCache();
                Bitmap image= imageView6.getDrawingCache();

                Bundle extras = new Bundle();
                extras.putParcelable("imagebitmap", image);
                extras.putParcelable("from_position", fromPosition);
                myIntent.putExtras(extras);


                myIntent.putExtra("EXTRA_DESCRIPCION", descripcion6.getText());  // MODIFICAR DESCRIPCION
                v.getContext().startActivity(myIntent);
            }
        });
        imageButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(getApplicationContext(), DetailActivity.class);
                myIntent.putExtra("EXTRA_NAME", name7.getText());                    // MODIFICAR NAME

                LatLng fromPosition = new LatLng(20.5942768,-100.3949366);           //  MODIFICAR LAT LNG

                imageView7.buildDrawingCache();
                Bitmap image= imageView7.getDrawingCache();

                Bundle extras = new Bundle();
                extras.putParcelable("imagebitmap", image);
                extras.putParcelable("from_position", fromPosition);
                myIntent.putExtras(extras);


                myIntent.putExtra("EXTRA_DESCRIPCION", descripcion7.getText());  // MODIFICAR DESCRIPCION
                v.getContext().startActivity(myIntent);
            }
        });
        imageButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(getApplicationContext(), DetailActivity.class);
                myIntent.putExtra("EXTRA_NAME", name8.getText());                    // MODIFICAR NAME

                LatLng fromPosition = new LatLng(20.592489,-100.3824324);           //  MODIFICAR LAT LNG

                imageView8.buildDrawingCache();
                Bitmap image= imageView8.getDrawingCache();

                Bundle extras = new Bundle();
                extras.putParcelable("imagebitmap", image);
                extras.putParcelable("from_position", fromPosition);
                myIntent.putExtras(extras);


                myIntent.putExtra("EXTRA_DESCRIPCION", descripcion8.getText());  // MODIFICAR DESCRIPCION
                v.getContext().startActivity(myIntent);
            }
        });
        imageButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(getApplicationContext(), DetailActivity.class);
                myIntent.putExtra("EXTRA_NAME", name9.getText());                    // MODIFICAR NAME

                LatLng fromPosition = new LatLng(20.5932645,-100.3917004);           //  MODIFICAR LAT LNG

                imageView9.buildDrawingCache();
                Bitmap image= imageView9.getDrawingCache();

                Bundle extras = new Bundle();
                extras.putParcelable("imagebitmap", image);
                extras.putParcelable("from_position", fromPosition);
                myIntent.putExtras(extras);


                myIntent.putExtra("EXTRA_DESCRIPCION", descripcion9.getText());  // MODIFICAR DESCRIPCION
                v.getContext().startActivity(myIntent);
            }
        });
        imageButton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplicationContext(), DetailActivity.class);
                myIntent.putExtra("EXTRA_NAME", name10.getText());                    // MODIFICAR NAME

                LatLng fromPosition = new LatLng(20.5933286,-100.4121403);           //  MODIFICAR LAT LNG

                imageView10.buildDrawingCache();
                Bitmap image= imageView10.getDrawingCache();

                Bundle extras = new Bundle();
                extras.putParcelable("imagebitmap", image);
                extras.putParcelable("from_position", fromPosition);
                myIntent.putExtras(extras);


                myIntent.putExtra("EXTRA_DESCRIPCION", descripcion10.getText());  // MODIFICAR DESCRIPCION
                v.getContext().startActivity(myIntent);

            }
        });
    }
}
