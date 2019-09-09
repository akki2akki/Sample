package com.sample.ayush;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    public TextView total_point;
    private FirebaseUser currentUser;
    private FirebaseAuth mAuth;
    int startingPoint;
    DatabaseReference databaseReference;
    int pt;

    private boolean loadFragment(Fragment fragment){
        if (fragment!=null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_frame,fragment)
                    .commit();
            return true;
        }
        return false;
    }



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment =new HomeFragment();
                    break;
//                    pt =700;
//                    getPointNew();

                case R.id.navigation_earnMoney:
                    fragment =new EarnMoneyFragment();
                    break;
                case R.id.navigation_withdrawl:
                    fragment =new WithdrawalFragment();
                    break;

            }
            return loadFragment(fragment);
        }


    };

    private void getPointNew() {
        SharedPreferences sp = getSharedPreferences("sp_points", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        int n =  startingPoint + pt;
        editor.putInt("int_key", n);
        editor.commit();
        databaseReference.child("points").setValue(+n);
        startingPoint =  sp.getInt("point_key",n);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        
        if (savedInstanceState==null){
            loadFragment(new HomeFragment());
        }






        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);



    }
    @Override
    protected void onStart() {
        super.onStart();

    }
//
//
//    public boolean isInternetAvailable() {
//
//        final Dialog dialog = new Dialog(this);
//        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(
//                getApplicationContext().CONNECTIVITY_SERVICE);
//        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() ==
//                NetworkInfo.State.CONNECTED || connectivityManager.getNetworkInfo
//                (ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
//
//            Toast.makeText(getApplicationContext(),"Internet Avialble", Toast.LENGTH_SHORT).show();
//
//
//        }else{
//            Toast.makeText(getApplicationContext(),"Internet Not Avialble", Toast.LENGTH_SHORT).show();
//
//            dialog.setContentView(R.layout.no_internet_error);
//            LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            View main = inflater.inflate(R.layout.no_internet_error,null);
//            dialog.setContentView(main);
//            dialog.show();
//            Button button = dialog.findViewById(R.id.retry_button);
//            button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (isInternetAvailable()){
//                        dialog.dismiss();
//                    }
//                }
//            });
//        }
//        //Do Something network is connected
//
//        return true;
//    }



}
