package models.controllers;

import models.usuarios.*;

import java.util.List;

public class ControllerUsuarios {
    private static ControllerUsuarios instancia = null;
    private Usuario usuarioLoggeado;
    private TipoUsuario tipoUsuario;
    private IAdapterUsuario adapter;


    private ControllerUsuarios() {
        adapter = new AdapterUsuario();
        usuarioLoggeado = null;
    }

    public static ControllerUsuarios getInstancia() {
        if (instancia == null) {
            instancia = new ControllerUsuarios();
        }
        return instancia;
    }

    public List<Veterinario> getVeterinarios() {
        return adapter.getVeterinarios();
    }

    public List<Visitante> getVisitantes() {
        return adapter.getVisitantes();
    }

    public Usuario getUsuarioLoggeado() {
        return usuarioLoggeado;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setUsuarioLoggeado(Usuario usuarioLoggeado) {
        this.usuarioLoggeado = usuarioLoggeado;
    }

    public void iniciarSesion(String usuario, String password, TipoUsuario tipoUsuario) {
        usuarioLoggeado = adapter.iniciarSesion(usuario, password);
        setTipoUsuario(tipoUsuario);
    }

    private void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
