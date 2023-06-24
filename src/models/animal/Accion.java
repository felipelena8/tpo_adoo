package models.animal;

public class Accion {

    private final String titulo;

    public Accion(String titulo) {
        this.titulo = titulo;
    }

    public void ejecutar() {
        System.out.println("Se ha ejecutado: " + titulo);
    }

    @Override
    public String toString() {
        return titulo;

    }
}
