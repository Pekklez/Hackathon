package com.UAQ;

import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.nfc.Tag;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), com.UAQ.UnityPlayerActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                Bundle extras = getIntent().getExtras();
                if (extras != null)
                    intent.putExtras(extras);
                startActivity(intent);
            }
        });



    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setMyLocationEnabled(true);

        LocationManager service = (LocationManager)

                getSystemService(LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        String provider = service.getBestProvider(criteria, false);
        Location location = service.getLastKnownLocation(provider);
        LatLng myLocation = new LatLng(location.getLatitude(),location.getLongitude());
        myLocation = new LatLng(20.592973, -100.391549);

        // Add a marker in Sydney and move the camera
        LatLng UNO = new LatLng(20.5919162, -100.3973391);
        LatLng DOS = new LatLng(20.5320625, -100.3632066);
        LatLng TRES = new LatLng(20.5928291, -100.3868695);
        LatLng CUATRO = new LatLng(20.5926205, -100.3932835);
        LatLng CINCO = new LatLng(20.5929527, -100.397889);
        LatLng SEIS = new LatLng(20.5929523, -100.4132099);
        LatLng SIETE = new LatLng(20.5942768, -100.3949366);
        LatLng OCHO = new LatLng(20.592489, -100.3824324);
        LatLng NUEVE = new LatLng(20.5932645, -100.3917004);
        LatLng DIEZ = new LatLng(20.5933286, -100.4121403);
        mMap.addMarker(new MarkerOptions().position(UNO).title("Jardin Guerrero").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)));
        mMap.addMarker(new MarkerOptions().position(DOS).title("Parque Nacional el Cimatario").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)));
        mMap.addMarker(new MarkerOptions().position(TRES).title("Plaza de los Fundadores").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)));
        mMap.addMarker(new MarkerOptions().position(CUATRO).title("Museo Regional").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)));
        mMap.addMarker(new MarkerOptions().position(CINCO).title("Museo de la Restauracion").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)));
        mMap.addMarker(new MarkerOptions().position(SEIS).title("Museo del Arte").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)));
        mMap.addMarker(new MarkerOptions().position(SIETE).title("Teatro de la Republica").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)));
        mMap.addMarker(new MarkerOptions().position(OCHO).title("Panteon de los Queretanos Ilustres").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)));
        mMap.addMarker(new MarkerOptions().position(NUEVE).title("Casa de Ecala").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)));
        mMap.addMarker(new MarkerOptions().position(DIEZ).title("Cerro de las Campanas").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)));

        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myLocation, 15));

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(myLocation) // Sets the center of the map to
                .zoom(22)                   // Sets the zoom
                .bearing(90) // Sets the orientation of the camera to east
                .tilt(30)    // Sets the tilt of the camera to 30 degrees
                .build();    // Creates a CameraPosition from the builder
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(
                cameraPosition));



    }
}
