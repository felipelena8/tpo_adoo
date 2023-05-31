package models.acciones;

public class Accion {
    private boolean completada;
    private String titulo;

    public void ejecutar(){
        completada=true;
        System.out.println("Se ha ejecutado: " + titulo);
    }
    public Accion(String titulo){
        this.titulo = titulo;
  }

    @Override
    public String toString() {
        return titulo;

    }
}
