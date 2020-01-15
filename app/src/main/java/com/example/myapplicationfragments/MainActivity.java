package com.example.myapplicationfragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView navView;
    int tipoMenu = 2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setTheme(R.style.AppTheme);

        setContentView(R.layout.activity_main);

        navView = findViewById(R.id.nav_view);


        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.homeFragment, R.id.loginFragment, R.id.registerFragment,R.id.newsFragment, R.id.messageFragment, R.id.favouriteFragment,
                R.id.recoveryPasswordFragment, R.id.recoveryPasswordFragment2, R.id.recoveryPasswordFragment3, R.id.recoveryPasswordFragment4).build();
        NavController navController = Navigation.findNavController(this,R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this,navController,appBarConfiguration);
        NavigationUI.setupWithNavController(navView,navController);

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller,
                                             @NonNull NavDestination destination, @Nullable Bundle arguments) {



                switch (destination.getId()){
                    case R.id.loginFragment:
//                      toolbar.setVisibility(View.GONE);
                        navView.setVisibility(View.GONE);
                        getSupportActionBar().hide();
                        break;
                    case R.id.registerFragment:
//                      toolbar.setVisibility(View.GONE);
                        navView.setVisibility(View.GONE);
                        getSupportActionBar().hide();
                        break;
                    case R.id.homeFragment:
                        navView.setVisibility(View.GONE);
                        getSupportActionBar().hide();
                        break;
                    case R.id.recoveryPasswordFragment:
                        navView.setVisibility(View.GONE);
                        getSupportActionBar().hide();
                        break;
                    case R.id.recoveryPasswordFragment2:
                        navView.setVisibility(View.GONE);
                        getSupportActionBar().hide();
                        break;
                    case R.id.recoveryPasswordFragment3:
                        navView.setVisibility(View.GONE);
                        getSupportActionBar().hide();
                        break;
                    case R.id.recoveryPasswordFragment4:
                        navView.setVisibility(View.GONE);
                        getSupportActionBar().hide();
                        break;
                    case R.id.detalleElementoFragment:
                        navView.getMenu().clear();
                        navView.inflateMenu(R.menu.bottom_nav_menu2);
                        tipoMenu = 2;
                        getSupportActionBar().show();
                        break;
                    default:
//                      toolbar.setVisibility(View.VISIBLE);
                        navView.setVisibility(View.VISIBLE);
                        getSupportActionBar().show();
                        if(tipoMenu != 0){
                            navView.getMenu().clear();
                            navView.inflateMenu(R.menu.bottom_nav_menu);
                        }
                        tipoMenu = 0;
                }
            }
        });    }
}
