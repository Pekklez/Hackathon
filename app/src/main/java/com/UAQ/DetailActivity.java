package com.UAQ;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    private GoogleMap mMap;
    private MapView mapView;
    private Marker marker;

    private static LatLng ONE;

    private ArrayList<LatLng> coords = new ArrayList<LatLng>();
    private static final int POINTS = 1;


    private static final String EXTRA_NAME = "com.uaq.toolbarapp.name";
    private static final String EXTRA_DRAWABLE = "com.uaq.toolbarapp.drawable";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mapView = (MapView) findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ONE, 15));
                setUpMap(googleMap);
            }
        });


        setToolbar();// Añadir action bar
        if (getSupportActionBar() != null) // Habilitar up button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent i = getIntent();
        String name = i.getExtras().getString("EXTRA_NAME");
        int idDrawable = i.getExtras().getInt("EXTRA_DRAWABLE");
        String descripcion = i.getExtras().getString("EXTRA_DESCRIPCION");

        CollapsingToolbarLayout collapser =
                (CollapsingToolbarLayout) findViewById(R.id.collapser);
        collapser.setTitle(name); // Cambiar título

        Bundle extras = getIntent().getExtras();

        ONE = extras.getParcelable("from_position");

        Bitmap bmp = (Bitmap) extras.getParcelable("imagebitmap");
        ImageView image = (ImageView) findViewById(R.id.image_paralax);
        image.setImageBitmap(bmp );

        TextView textView_descripcion = (TextView) findViewById(R.id.descripcion_cardView);
        textView_descripcion.setText(descripcion);



        // Setear escucha al FAB
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Floating Action button", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    private void setToolbar() {
        // Añadir la Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    /**
     * Se carga una imagen aleatoria para el detalle
     */
    private void loadImageParallax(int id) {
        ImageView image = (ImageView) findViewById(R.id.image_paralax);
        // Usando Glide para la carga asíncrona
        Glide.with(this)
                .load(id)
                .centerCrop()
                .into(image);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setUpMap(GoogleMap map) {
        mMap = map;

        coords.add(ONE);

        for (int i = 0; i < POINTS; i++) {
            mMap.addMarker(new MarkerOptions()
                    .position(coords.get(i))
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        }
    }

}