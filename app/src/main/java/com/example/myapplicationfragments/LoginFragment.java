package com.example.myapplicationfragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplicationfragments.viewModel.AuthViewModel;

import es.dmoral.toasty.Toasty;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    Button buttonLogin;
    EditText txtEmail;
    EditText txtPassword;

    String email;
    String password;
    private AuthViewModel authViewModel;
    private NavController navController;

    public LoginFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }


    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        authViewModel = ViewModelProviders.of(requireActivity()).get(AuthViewModel.class);
        navController = Navigation.findNavController(view);
        // Initialize Firebase Auth
        txtEmail = view.findViewById(R.id.EditextCorreo);
        txtPassword = view.findViewById(R.id.EditextPassword);

        buttonLogin = view.findViewById(R.id.btnLogin);

        Button buttonCreateAccount = view.findViewById(R.id.btnCreateAccount);
        buttonCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.registerFragment);

            }
        });

        TextView textViewForgetPass = view.findViewById(R.id.txtForgetPassword);
        textViewForgetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.recoveryPasswordFragment);

            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = txtEmail.getText().toString();
                password = txtPassword.getText().toString();
                authViewModel.iniciarSesion(email,password);

            }
        });
        authViewModel.estadoDeLaAutenticacion.observe(getViewLifecycleOwner(), new Observer<AuthViewModel.EstadoDeLaAutenticacion>() {
            @Override
            public void onChanged(AuthViewModel.EstadoDeLaAutenticacion estadoDeLaAutenticacion) {
                switch (estadoDeLaAutenticacion){
                    case AUTENTICADO:
                        navController.navigate(R.id.newsFragment);
                        break;

                    case AUTENTICACION_INVALIDA:
                        Toasty.info(getContext(), "CREDENCIALES NO VALIDAS", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }


}