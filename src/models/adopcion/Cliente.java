package models.adopcion;

import models.animal.Animal;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private Ocupacion ocupacion;
    private int mascotas;
    private String motivoAdopcion;
    private List<Animal> mascotasAdoptadas;
    public Cliente(String nombre, String apellido, String email, String telefono, Ocupacion ocupacion, int mascotas, String motivoAdopcion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.ocupacion = ocupacion;
        this.mascotas = mascotas;
        this.motivoAdopcion = motivoAdopcion;
        mascotasAdoptadas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Ocupacion getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(Ocupacion ocupacion) {
        this.ocupacion = ocupacion;
    }

    public int getMascotas() {
        return mascotas;
    }

    public void setMascotas(int mascotas) {
        this.mascotas = mascotas;
    }

    public String getMotivoAdopcion() {
        return motivoAdopcion;
    }

    public void setMotivoAdopcion(String motivoAdopcion) {
        this.motivoAdopcion = motivoAdopcion;
    }

    public List<Animal> getMascotasAdoptadas() {
        return mascotasAdoptadas;
    }

    public void setMascotasAdoptadas(List<Animal> mascotasAdoptadas) {
        this.mascotasAdoptadas = mascotasAdoptadas;
    }

    public void adoptar(Animal animal) {
        mascotasAdoptadas.add(animal);
    }


}
