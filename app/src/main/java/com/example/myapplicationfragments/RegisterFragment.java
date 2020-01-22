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


public class RegisterFragment extends Fragment {
    EditText username,email, emailConfirm, password, passwordConfirm;
    Button registerButton;
    AuthViewModel authViewModel;
    NavController navController;
    public RegisterFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        authViewModel = ViewModelProviders.of(requireActivity()).get(AuthViewModel.class);
        navController = Navigation.findNavController(view);

        username = view.findViewById(R.id.EditextUsername);
        email = view.findViewById(R.id.EditextCorreo);
        emailConfirm = view.findViewById(R.id.EditextCorreoConfirm);
        password = view.findViewById(R.id.EditextPassword);
        passwordConfirm = view.findViewById(R.id.EditextPasswordConfirm);
        registerButton = view.findViewById(R.id.btnRegisterAndLogin);

        authViewModel.iniciarRegistro();

        TextView textViewLoginHere = view.findViewById(R.id.btnLoginHere);
        textViewLoginHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.loginFragment);

            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!email.getText().toString().equals(emailConfirm.getText().toString())){
                    Toast.makeText(getContext(),"El email no coincide", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!password.getText().toString().equals(passwordConfirm.getText().toString())){
                    Toast.makeText(getContext(),"El password no coincide", Toast.LENGTH_SHORT).show();
                    return;
                }

                authViewModel.crearCuentaEIniciarSesion(email.getText().toString(),password.getText().toString(),username.getText().toString());
            }
        });

        authViewModel.estadoDelRegistro.observe(getViewLifecycleOwner(), new Observer<AuthViewModel.EstadoDelRegistro>() {
            @Override
            public void onChanged(AuthViewModel.EstadoDelRegistro estadoDelRegistro) {
                switch (estadoDelRegistro){
                    case NOMBRE_NO_DISPONIBLE:
                        Toast.makeText(getContext(), "NOMBRE DE USUARIO NO DISPONIBLE", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        authViewModel.estadoDeLaAutenticacion.observe(getViewLifecycleOwner(), new Observer<AuthViewModel.EstadoDeLaAutenticacion>() {
            @Override
            public void onChanged(AuthViewModel.EstadoDeLaAutenticacion estadoDeLaAutenticacion) {
                switch (estadoDeLaAutenticacion){
                    case AUTENTICADO:
                        navController.navigate(R.id.categoryOneFragment);
                        break;
                }
            }
        });

    }
}
