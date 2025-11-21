public class Pagamento {

    private int IDpagamento;
    private double valor;
    private String formaPagamento;
    private String status = "pendente";

    public Pagamento(double valor, String formaPagamento) {
        this.valor = valor;
        this.formaPagamento = formaPagamento;
    }

    public boolean validarPagamento() {
        if (valor <= 0) return false;
        return true;
    }

    public void confirmarPagamento() {
        if (validarPagamento()) status = "pago";
        else status = "cancelado";
    }
}
