package models;

public class Animal {
    private String nombre;
    private double altura;
    private double peso;
    private double edad;
    private String tipoAnimal;
    private boolean esDomestico;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getEdad() {
        return edad;
    }

    public void setEdad(double edad) {
        this.edad = edad;
    }

    public String getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(String tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public boolean isEsDomestico() {
        return esDomestico;
    }

    public void setEsDomestico(boolean esDomestico) {
        this.esDomestico = esDomestico;
    }

    public Animal(String nombre, double altura, double peso, double edad, String tipoAnimal, boolean esDomestico) {
        this.nombre = nombre;
        this.altura = altura;
        this.peso = peso;
        this.edad = edad;
        this.tipoAnimal = tipoAnimal;
        this.esDomestico = esDomestico;
    }
}
