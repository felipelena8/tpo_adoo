package models.adopcion;

public class Encuesta {
    private EscalaValoracion estadoAnimal;
    private EscalaValoracion limpiezaLugar;
    private EscalaValoracion ambiente;

    public Encuesta(EscalaValoracion estadoAnimal, EscalaValoracion limpiezaLugar, EscalaValoracion ambiente) {
        this.estadoAnimal = estadoAnimal;
        this.limpiezaLugar = limpiezaLugar;
        this.ambiente = ambiente;
    }
}
