import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Entrega {
    private int id;
    private String endereco;
    private double peso;
    private Date prazo;
    private boolean statusPedido;

    private static List<Entrega> entregas = new ArrayList<>();

    public Entrega(int id, String endereco, double peso, Date prazo, boolean statusPedido) {
        if (!validarEndereco(endereco)) {
            throw new IllegalArgumentException("Endereço inválido.");
        }
        if (peso <= 0) {
            throw new IllegalArgumentException("Peso inválido.");
        }

        this.id = id;
        this.endereco = endereco;
        this.peso = peso;
        this.prazo = prazo;
        this.statusPedido = statusPedido;
    }

    private boolean validarEndereco(String endereco) {
        return endereco != null && endereco.length() >= 5;
    }

    public int getId() {
         return id; 
        }
    public String getEndereco() {
         return endereco; 
        }
    public double getPeso() { 
        return peso; 
    }
    public Date getPrazo() { 
        return prazo; 
    }
    public boolean getStatusPedido() { 
        return statusPedido; 
    }

    public static void addEntrega(Entrega e) {
        entregas.add(e);
    }

    public static List<Entrega> listarEntregas() {
        return entregas;
    }
}
