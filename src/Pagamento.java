import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pagamento {
    private int id;
    private Pedido pedido;
    private double valor;
    private String formaPagamento;   
    private String status;
    private Date data;

    private static List<Pagamento> pagamentos = new ArrayList<>();

    public Pagamento(int id, Pedido pedido, String formaPagamento) {
        this.id = id;
        this.pedido = pedido;
        this.valor = pedido.valorTotal();
        this.formaPagamento = formaPagamento;
        this.status = "Pendente";
        this.data = null;
    }

    public void confirmar() {
        this.status = "Pago";
    }

    public void cancelar() {
        this.status = "Recusado";
    }

    public int getId() { 
        return id; 
    }
    public Pedido getPedido() {
         return pedido; 
    }
    public double getValor() { 
        return valor;
     }
    public String getMetodo() { 
        return formaPagamento;
    }
    public String getStatus() { 
        return status;
    }


    public static void addPagamento(Pagamento p) {
        pagamentos.add(p);
    }

    public static List<Pagamento> listarPagamentos() {
        return pagamentos;
    }

}

