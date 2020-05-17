package provaTecnicaApiSul;

import com.google.gson.annotations.SerializedName;


public class Resposta{
   
    @SerializedName("andar")
    private int andar;
    
    @SerializedName("elevador")
    private Character elevador;
    
    @SerializedName("turno")
    private Character turno;

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    public Character getElevador() {
        return elevador;
    }

    public void setElevador(Character elevador) {
        this.elevador = elevador;
    }

    public Character getTurno() {
        return turno;
    }

    public void setTurno(Character turno) {
        this.turno = turno;
    }
    
}
