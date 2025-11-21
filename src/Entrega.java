import java.util.Date;

public class Entrega {

    private int IDentrega;
    private String endereco;
    private double peso;
    private Date prazo;
    private boolean statusPedido;

    private Drone drone;

    public Entrega(String endereco, double peso, Date prazo) {
        this.endereco = endereco;
        this.peso = peso;
        this.prazo = prazo;
    }

    public boolean validarEndereco() {
        return endereco != null && !endereco.isBlank();
    }

    public void atualizarStatus(boolean status) {
        this.statusPedido = status;
    }

    public void atribuirDrone(Drone drone) {
        this.drone = drone;
    }
}
