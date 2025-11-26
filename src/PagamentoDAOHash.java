import java.util.HashMap;

public class PagamentoDAOHash {

    public interface Operacoes {
        void inserir(Pagamento pagamento);
        Pagamento buscar(int idPagamento);
        void atualizar(Pagamento pagamento);
        void remover(int idPagamento);
    }

    public static class HashMapDAO implements Operacoes {

        private HashMap<Integer, Pagamento> tabelaPagamentos = new HashMap<>();

        @Override
        public void inserir(Pagamento pagamento) {
            tabelaPagamentos.put(pagamento.getIdPagamento(), pagamento);
        }

        @Override
        public Pagamento buscar(int idPagamento) {
            return tabelaPagamentos.get(idPagamento);
        }

        @Override
        public void atualizar(Pagamento pagamento) {
            tabelaPagamentos.put(pagamento.getIdPagamento(), pagamento);
        }

        @Override
        public void remover(int idPagamento) {
            tabelaPagamentos.remove(idPagamento);
        }
    }
}