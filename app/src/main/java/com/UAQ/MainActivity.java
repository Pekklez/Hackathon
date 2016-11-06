package com.UAQ;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.preference.PreferenceActivity;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;


public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    TextView textView_user;
    ImageView imageViewFacebook_logged;
    Drawable imagen;
    String idFacebook, userFacebook;

    private TableLayout tlDetalleVenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.acitivity_principal);

        tlDetalleVenta = (TableLayout)findViewById(R.id.tl_detalle_venta);
        obdatos("192.168.15.32", "/public_html/Tweets.php");

        //Get Image

        idFacebook = getIntent().getExtras().getString("idFacebook");
        userFacebook = getIntent().getExtras().getString("userFb");
        new getUserPicFB(imagen).execute("https://graph.facebook.com/"+idFacebook+"/picture?type=large");

       // setToolbar();

       toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);

        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                //Checking if the item is in checked state or not, if not make it in checked state
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);

                //Closing drawer on item click
                drawerLayout.closeDrawers();

                //Check to see which item was being clicked and perform appropriate action
                switch (item.getItemId()) {

                    case R.id.twitter:
                        //
                        return true;
                    // For rest of the options we just show a toast on click
                    case R.id.places:
                        startActivity(new Intent(getApplicationContext(), ItemsGrid.class));

                        return true;
                    case R.id.mapa:
                        startActivity(new Intent(getApplicationContext(), MapsActivity.class));
                        return true;
                    case R.id.reporte:
                        //startActivity(new Intent(getApplicationContext(), ActivityMaps.class));
                        return true;

                    default:
                        Toast.makeText(getApplicationContext(), "Somethings Wrong", Toast.LENGTH_SHORT).show();
                        return true;
                }
            }
        });

        // Initializing Drawer Layout and ActionBarToggle
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.openDrawer, R.string.closeDrawer){


            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank

                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessay or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();


    }

    public void obdatos(String ip, String path)
    {
        AsyncHttpClient client = new AsyncHttpClient();
        String url = "http://" + ip + path;

        Log.e("ip", url);
        //Parametros que se envian ---  bundle.getInt(key_intent_iD)
        RequestParams parametros = new RequestParams();

        //Mandar "Id Venta" para mostrar los datos de "mostrar_detale_venta.php"
        //parametros.put("id", bundle.getInt(key_intent_iD));

        client.post(url, parametros, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode == 200)
                {
                    obDatosJson(new String(responseBody));
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    public ArrayList<String> obDatosJson(String reponse)
    {
        ArrayList<String> list = new ArrayList<>();
        try
        {
            JSONObject jsonObject = new JSONObject(reponse);
            JSONArray jsonArray = jsonObject.getJSONArray("statuses");

            String idUser="";
            String textoTw="";

            for(int i = 0 ; i < jsonArray.length(); i++)
            {
                textoTw  =   "    " + jsonArray.getJSONObject(i).getString("text");
                String temp  =     jsonArray.getJSONObject(i).getString("user");

                JSONObject objUser = new JSONObject(temp);
                idUser = objUser.getString("name");



                //Definir Table Row
                TableRow row = new TableRow(getBaseContext());
                /*
                * Dar parametos Al Table Row
                *   MATCH_PARENT
                *   WRAP_CONTENT
                *   weightSum = 10f
                * */
                TableRow.LayoutParams params1 = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 10f);
                row.setPadding(10, 10, 10, 10);
                row.setLayoutParams(params1);

                //TextView 1 -----------------------------------------------------------------------
                TextView tv01 = new TextView(getBaseContext());
                //TextView 1 Parametros
                /*
                * Dar parametos Al TextView
                *   WRAP_CONTENT
                *   layout_weight= = 2.5f
                * */
                TableRow.LayoutParams params2 = new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 2.5f);
                tv01.setLayoutParams(params2);
                tv01.setPadding(30,30,30,30);
                //TextView 1 seleccionar Texto
                tv01.setText(idUser + "\n" + "\n" + textoTw);
                tv01.setElevation(10);

                tv01.setText(Html.fromHtml("<b>"+idUser+"</b><br><br><p align=\"justify\">"+textoTw+"</p>"));


                if((i+1)%2 == 0)
                {
                    //Si Es "Par" La Fila "BackgroundColor" = White
                    tv01.setBackgroundColor(Color.WHITE);
                    tv01.setTextColor(Color.GRAY);

                }
                else
                {
                    //Si Es "Impar" La Fila "BackgroundColor" = row 2 "Azul"
                    tv01.setBackgroundColor(Color.WHITE);
                    tv01.setTextColor(Color.GRAY);

                }

                //Agregar TextView Al TableRow------------------------------------------------------
                row.addView(tv01);

                //Agregar El TableRow al TableLayout------------------------------------------------
                tlDetalleVenta.addView(row);

                //Seleccionar Total
                //tvTotal.setText("Total: " + Integer.toString(total));
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    protected void onStart() {
        super.onStart();

    }


    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            // Poner ícono del drawer toggle
            ab.setHomeAsUpIndicator(R.drawable.ic_media_play);
            ab.setDisplayHomeAsUpEnabled(true);
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }



    //Get User pick from facebook
    class getUserPicFB extends AsyncTask<String, Void, Bitmap> {
        Drawable imagen;

        public getUserPicFB(Drawable image){
            this.imagen = image;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }


        protected void onPostExecute(Bitmap result) {

            int width = result.getWidth();
            int height = result.getHeight();
            int newW = 200;
            int newH = 200;
            float scaleW = ((float)newW)/width;
            float scaleH = ((float)newH)/height;
            Matrix x = new Matrix();
            x.postScale(scaleW,scaleH);
            Bitmap resized = Bitmap.createBitmap(result,0,0,width,height,x,true);
            RoundedBitmapDrawable roundedDrawable = RoundedBitmapDrawableFactory.create(Resources.getSystem() , resized);
            roundedDrawable.setCornerRadius(resized.getHeight());
            imagen = roundedDrawable;

            //imageViewFacebook_logged = (ImageView)findViewById(R.id.profile_image);
            //imageViewFacebook_logged.setImageDrawable(imagen);

            //textView_user = (TextView)findViewById(R.id.username);
            //textView_user.setText(userFacebook);

        }
    }



}
