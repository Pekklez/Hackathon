package com.UAQ;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
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
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    TextView textView_user;
    ImageView imageViewFacebook_logged;
    Drawable imagen;
    String idFacebook, userFacebook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.acitivity_principal);

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

                    case R.id.cafe:
                        startActivity(new Intent(getApplicationContext(), ItemsGrid.class));
                        return true;
                    // For rest of the options we just show a toast on click
                    case R.id.alimentos:
                        startActivity(new Intent(getApplicationContext(), MapsActivity.class));
                        return true;
                    case R.id.pedidos:
                        //Toast.makeText(getApplicationContext(),"Pedidos",Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.rutas:
                        //startActivity(new Intent(getApplicationContext(), ActivityMaps.class));
                        return true;
                    case R.id.places:
                        //startActivity(new Intent(getApplicationContext(), ActivityPlaces.class));
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

            imageViewFacebook_logged = (ImageView)findViewById(R.id.profile_image);
            imageViewFacebook_logged.setImageDrawable(imagen);

            textView_user = (TextView)findViewById(R.id.username);
            textView_user.setText(userFacebook);

        }
    }



}
