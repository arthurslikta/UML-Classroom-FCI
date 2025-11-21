import java.util.ArrayList;
import java.util.List;

public class Drone {

    private int IDdrone;
    private int bateria;
    private float capacidadePeso;
    private boolean disponibilidade;

    private List<Entrega> entregas = new ArrayList<>();

    public boolean atribuiçãoAutomatica(Pedido pedido) {
        return validarPeso(pedido.getProduto().getPeso() * pedido.getQuantidade())
                && validarBateria();
    }

    public boolean validarPeso(double peso) {
        return peso <= capacidadePeso;
    }

    public boolean validarBateria() {
        return bateria >= 20;
    }

    public List<Entrega> historicoDrone() {
        return entregas;
    }
}
