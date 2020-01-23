package com.example.myapplicationfragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    Toolbar toolbar;

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

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bottomNavigationView = findViewById(R.id.bottom_nav_view);


        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.homeFragment, R.id.loginFragment, R.id.registerFragment,R.id.newsFragment, R.id.messageFragment, R.id.favouriteFragment,
                R.id.recoveryPasswordFragment, R.id.recoveryPasswordFragment2, R.id.recoveryPasswordFragment3, R.id.recoveryPasswordFragment4).build();
        NavController navController = Navigation.findNavController(this,R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this,navController,appBarConfiguration);
        NavigationUI.setupWithNavController(bottomNavigationView,navController);

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onDestinationChanged(@NonNull NavController controller,
                                             @NonNull NavDestination destination, @Nullable Bundle arguments) {




                switch (destination.getId()){
                    case R.id.loginFragment:
//                      toolbar.setVisibility(View.GONE);
                        bottomNavigationView.setVisibility(View.GONE);
                        toolbar.setVisibility(View.VISIBLE);
                        break;
                    case R.id.registerFragment:
                        toolbar.setVisibility(View.GONE);
                        bottomNavigationView.setVisibility(View.GONE);
                        break;
                    case R.id.homeFragment:
                        bottomNavigationView.setVisibility(View.GONE);
                        getSupportActionBar().hide();
                        break;
                    case R.id.recoveryPasswordFragment:
                        bottomNavigationView.setVisibility(View.GONE);
                        getSupportActionBar().hide();
                        break;
                    case R.id.recoveryPasswordFragment2:
                        bottomNavigationView.setVisibility(View.GONE);
                        getSupportActionBar().hide();
                        break;
                    case R.id.recoveryPasswordFragment3:
                        bottomNavigationView.setVisibility(View.GONE);
                        getSupportActionBar().hide();
                        break;
                    case R.id.recoveryPasswordFragment4:
                        bottomNavigationView.setVisibility(View.GONE);
                        getSupportActionBar().hide();
                        break;
                    case R.id.detalleElementoFragment:
                        bottomNavigationView.getMenu().clear();
                        bottomNavigationView.inflateMenu(R.menu.bottom_nav_menu2);
                        tipoMenu = 2;
                        getSupportActionBar().hide();
                        break;
                    default:
//                      toolbar.setVisibility(View.VISIBLE);
                        bottomNavigationView.setVisibility(View.VISIBLE);
                        getSupportActionBar().hide();
                        if(tipoMenu != 0){
                            bottomNavigationView.getMenu().clear();
                            bottomNavigationView.inflateMenu(R.menu.bottom_nav_menu);
                        }
                        tipoMenu = 0;
                }
            }
        });
    }
}
