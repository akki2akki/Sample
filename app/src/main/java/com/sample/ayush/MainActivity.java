package com.sample.ayush;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawer_layout);
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
//                            case R.id.d_quotes_of_the_day:
//                                mp.start();
//                                Intent intent = new Intent(MainActivity.this,DayQuoteActivity.class);
//                                startActivity(intent);
//                                break;
//                            case R.id.d_instagram:
//                                mp.start();
//                                intent = new Intent(Intent.ACTION_VIEW);
//                                intent.setData(Uri.parse("https://www.instagram.com/ayush_mangla_"));
//                                startActivity(intent);
//                                break;
//                            case R.id.d_rate_us:
//                                mp.start();
//                                intent = new Intent(Intent.ACTION_VIEW);
//                                intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.boys.attitude.status.hindi"));
//                                startActivity(intent);
//                                break;
//                            case R.id.d_share_app:
//                                mp.start();
//                                Intent intt =new Intent(Intent.ACTION_SEND);
//                                intt.setType("text/plain");
//                                String text = "Best Boys Attitude status App in Hindi Download Now ";
//                                String link= "http://bit.ly/attitudehindi";
//                                intt.putExtra(Intent.EXTRA_TEXT, text +" " + link   );
//                                startActivity(Intent.createChooser(intt,"Share Via"));
//
//                                break;
//                            case R.id.d_privacy:
//                                mp.start();
//                                intent = new Intent(Intent.ACTION_VIEW);
//                                intent.setData(Uri.parse("https://sites.google.com/view/boysattitudestatushindi/"));
//                                startActivity(intent);
//                                break;
//                            default:
//                                break;

                        }
                        menuItem.setCheckable(false);
                        menuItem.setChecked(false);

                        drawerLayout.closeDrawers();
                        return true;
                    }
                });



//        @Override
//        public void onBackPressed() {
//
//            if (drawerLayout.isDrawerOpen(Gravity.RIGHT)) {
//                drawerLayout.closeDrawer(Gravity.RIGHT);
//                mInterstitialAd.show();
//            } else {
    }
}
