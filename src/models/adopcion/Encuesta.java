package models.adopcion;

public class Encuesta {
    private final EscalaValoracion estadoAnimal;
    private final EscalaValoracion limpiezaLugar;
    private final EscalaValoracion ambiente;

    public Encuesta(EscalaValoracion estadoAnimal, EscalaValoracion limpiezaLugar, EscalaValoracion ambiente) {
        this.estadoAnimal = estadoAnimal;
        this.limpiezaLugar = limpiezaLugar;
        this.ambiente = ambiente;
    }

    public EscalaValoracion getEstadoAnimal() {
        return estadoAnimal;
    }

    public EscalaValoracion getLimpiezaLugar() {
        return limpiezaLugar;
    }

    public EscalaValoracion getAmbiente() {
        return ambiente;
    }
}