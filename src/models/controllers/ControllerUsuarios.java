package models.controllers;

import models.usuarios.*;

import java.util.List;

public class ControllerUsuarios {
    private Usuario usuarioLoggeado;
    private static ControllerUsuarios instancia = null;
    private IAdapterUsuario adapter;

    public static ControllerUsuarios getInstancia(){
        if(instancia==null){
            instancia = new ControllerUsuarios();
        }
        return instancia;
    }

    private ControllerUsuarios(){
        adapter = new AdapterUsuario();
        usuarioLoggeado = null;
    }
    public List<Veterinario> getVeterinarios(){
        return adapter.getVeterinarios();
    }
    public List<Visitante> getVisitantes(){
        return adapter.getVisitantes();
    }
    public void iniciarSesion(String usuario, String contrasena){
        usuarioLoggeado = adapter.iniciarSesion(usuario, contrasena);
    }

    public Usuario getUsuarioLoggeado() {
        return usuarioLoggeado;
    }

    public void setUsuarioLoggeado(Usuario usuarioLoggeado) {
        this.usuarioLoggeado = usuarioLoggeado;
    }
}
