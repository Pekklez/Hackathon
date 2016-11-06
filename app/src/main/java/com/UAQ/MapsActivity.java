package com.UAQ;

import android.nfc.Tag;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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

        LatLng myLocation = new LatLng(mMap.getMyLocation().getLatitude(),mMap.getMyLocation().getLongitude());

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
        mMap.addMarker(new MarkerOptions().position(UNO).title("Jardin Guerrero"));
        mMap.addMarker(new MarkerOptions().position(DOS).title("Parque Nacional el Cimatario"));
        mMap.addMarker(new MarkerOptions().position(TRES).title("Plaza de los Fundadores"));
        mMap.addMarker(new MarkerOptions().position(CUATRO).title("Museo Regional"));
        mMap.addMarker(new MarkerOptions().position(CINCO).title("Museo de la Restauracion"));
        mMap.addMarker(new MarkerOptions().position(SEIS).title("Museo del Arte"));
        mMap.addMarker(new MarkerOptions().position(SIETE).title("Teatro de la Republica"));
        mMap.addMarker(new MarkerOptions().position(OCHO).title("Panteon de los Queretanos Ilustres"));
        mMap.addMarker(new MarkerOptions().position(NUEVE).title("Casa de Ecala"));
        mMap.addMarker(new MarkerOptions().position(DIEZ).title("Cerro de las Campanas"));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(myLocation));
    }
}
