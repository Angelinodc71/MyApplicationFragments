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
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final BottomNavigationView navView = findViewById(R.id.nav_view);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.homeFragment, R.id.loginFragment, R.id.registerFragment, R.id.inicioFragment).build();
        NavController navController = Navigation.findNavController(this,R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this,navController,appBarConfiguration);
        NavigationUI.setupWithNavController(navView,navController);

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller,
                                             @NonNull NavDestination destination, @Nullable Bundle arguments) {
                switch (destination.getId()){
                    case R.id.loginFragment:
//                      toolbar.setVisibility(View.GONE);
                        navView.setVisibility(View.GONE);
                        break;
                    case R.id.registerFragment:
//                      toolbar.setVisibility(View.GONE);
                        navView.setVisibility(View.GONE);
                        break;
                    case R.id.homeFragment:
                        navView.setVisibility(View.GONE);
                        break;
                    default:
//                      toolbar.setVisibility(View.VISIBLE);
                        navView.setVisibility(View.VISIBLE);
                }
            }
        });    }
}
