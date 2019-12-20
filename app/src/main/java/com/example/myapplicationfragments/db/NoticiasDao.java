package com.example.myapplicationfragments.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.myapplicationfragments.model.Usuario;

@Dao
public abstract class NoticiasDao {
    @Insert
    public abstract void insertarUsuario(Usuario usuario);

    @Query("SELECT * FROM Usuario WHERE email = :email AND password = :password")
    public abstract Usuario autenticar(String email, String password);

    @Query("SELECT * FROM Usuario WHERE username = :username")
    public abstract Usuario comprobarNombreDisponible(String username);
}
