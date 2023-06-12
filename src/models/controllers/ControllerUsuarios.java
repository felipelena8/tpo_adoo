package models.controllers;

import models.usuarios.*;

import java.util.List;

public class ControllerUsuarios {
    private static ControllerUsuarios instancia = null;
    private static Usuario usuarioLoggeado;
    private TipoUsuario tipoUsuario;
    private IAdapterUsuario adapter;


    private ControllerUsuarios() {
        adapter = new AdapterUsuario();
    }

    public static ControllerUsuarios getInstancia() {
        if (instancia == null) {
            instancia = new ControllerUsuarios();
        }
        return instancia;
    }

    public static Usuario getUsuarioLoggeado() {
        return usuarioLoggeado;
    }

    public static void setUsuarioLoggeado(Usuario usuarioLoggeado) {
        ControllerUsuarios.usuarioLoggeado = usuarioLoggeado;
    }

    public List<Veterinario> getVeterinarios() {
        return adapter.getVeterinarios();
    }

    public List<Visitante> getVisitantes() {
        return adapter.getVisitantes();
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Visitante buscarVisitante(String username) {
        return getVisitantes().stream().filter(visitante -> visitante.getUsuario().equalsIgnoreCase(username)).findFirst().orElse(null);
    }

    public void iniciarSesion(String usuario, String password, TipoUsuario tipoUsuario) {
        Usuario user = null;
        switch (tipoUsuario) {
            case VETERINARIO -> user = adapter.iniciarSesion(usuario, password).traerVeterinario();
            case VISITANTE -> user = adapter.iniciarSesion(usuario, password).traerVisitante();
        }
        setUsuarioLoggeado(user);
        setTipoUsuario(tipoUsuario);
        System.out.println("Bienvenido " + usuarioLoggeado.getNombre() + " has iniciado como " + tipoUsuario.getTipoUsuario().toLowerCase());
    }
}
