import java.util.*;

public class Main {

    static ClienteDAOHash clienteDAO = new ClienteDAOHash();
    static DroneDAOHash droneDAO = new DroneDAOHash();
    static PedidoDAOHash pedidoDAO = new PedidoDAOHash();
    static ProdutoDAOHash produtoDAO = new ProdutoDAOHash();
    static ProdutoPedidoDAOHash produtoPedidoDAO = new ProdutoPedidoDAOHash();
    static PagamentoDAOHash.HashMapDAO pagamentoDAO = new PagamentoDAOHash.HashMapDAO();
    static EntregaDAOHash entregaDAO = new EntregaDAOHash();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== SISTEMA DE ENTREGAS POR DRONE =====");
            System.out.println("1. Cadastrar cliente");
            System.out.println("2. Cadastrar drone");
            System.out.println("3. Solicitar entrega");
            System.out.println("4. Ver histórico de entregas por cliente");
            System.out.println("5. Ver histórico de entregas por drone");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");

            int op = sc.nextInt();
            sc.nextLine();

            try {
                switch (op) {
                    case 1 -> cadastrarCliente();
                    case 2 -> cadastrarDrone();
                    case 3 -> solicitarEntrega();
                    case 4 -> historicoPorCliente();
                    case 5 -> historicoPorDrone();
                    case 0 -> {
                        System.out.println("Encerrado.");
                        return;
                    }
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    private static void cadastrarCliente() {
        System.out.println("\n=== CADASTRO DE CLIENTE ===");

        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Senha: ");
        String senha = sc.nextLine();

        // Endereço poderia virar uma entidade, mas aqui mantemos simples
        System.out.print("Endereço completo: ");
        String endereco = sc.nextLine(); // não usamos ainda, mas atende ao requisito

        Cliente c = new Cliente(id, nome, email, senha);
        clienteDAO.salvar(c);

        System.out.println("Cliente cadastrado!");
    }

    private static void cadastrarDrone() {
        System.out.println("\n=== CADASTRO DE DRONE ===");

        System.out.print("ID: ");
        int id = sc.nextInt();

        System.out.print("Bateria (%): ");
        int bateria = sc.nextInt();

        System.out.print("Capacidade de carga (kg): ");
        double capacidade = sc.nextDouble();

        Drone d = new Drone(id, bateria, capacidade);
        droneDAO.salvar(d);

        System.out.println("Drone cadastrado!");
    }

    private static void solicitarEntrega() {
        System.out.println("\n=== SOLICITAÇÃO DE ENTREGA ===");

        System.out.print("ID do cliente: ");
        int idCliente = sc.nextInt();
        sc.nextLine();

        Cliente cliente = clienteDAO.buscar(idCliente);
        if (cliente == null)
            throw new RuntimeException("Cliente não encontrado.");

        System.out.print("Destino (endereço completo): ");
        String destino = sc.nextLine();

        validarEndereco(destino);

        System.out.print("Peso do pacote (kg): ");
        double peso = sc.nextDouble();

        // Criar pedido
        int idPedido = gerarId();
        Pedido p = new Pedido(idPedido, idCliente);
        p.setValorTotal(0); // simples
        pedidoDAO.salvar(p);

        // Selecionar drone mais adequado
        Drone droneEscolhido = escolherDrone(peso);
        if (droneEscolhido == null)
            throw new RuntimeException("Nenhum drone disponível atende os requisitos.");

        // Criar entrega
        int idEntrega = gerarId();
        Entrega e = new Entrega(idEntrega, p.getId(), droneEscolhido.getIdDrone(), destino);
        entregaDAO.salvar(e);

        System.out.println("Entrega criada com sucesso!");
        System.out.println("Drone atribuído: " + droneEscolhido.getIdDrone());
    }

    private static void historicoPorCliente() {
        System.out.print("ID do cliente: ");
        int id = sc.nextInt();

        System.out.println("\n=== ENTREGAS DO CLIENTE " + id + " ===");

        boolean encontrou = false;

        for (Entrega e : HashDatabase.entregas.values()) {

            Pedido p = pedidoDAO.buscar(e.getIdPedido());

            if (p != null && p.getIdCliente() == id) {
                encontrou = true;
                System.out.println(
                        "Entrega " + e.getId() +
                                " - Pedido " + p.getId() +
                                " - Drone " + e.getIdDrone());
            }
        }

        if (!encontrou) {
            System.out.println("Nenhuma entrega encontrada para este cliente.");
        }
    }

    private static void historicoPorDrone() {
        System.out.print("ID do drone: ");
        int id = sc.nextInt();

        System.out.println("\n=== ENTREGAS DO DRONE " + id + " ===");
        for (Entrega e : HashDatabase.entregas.values()) {
            if (e.getIdDrone() == id) {
                System.out.println("Entrega " + e.getId() + " - Pedido " + e.getId());
            }
        }
    }

    private static int gerarId() {
        return new Random().nextInt(99999);
    }

    // Regra simples: endereço válido tem pelo menos 10 caracteres e um número
    private static void validarEndereco(String endereco) {
        if (endereco.length() < 6 || !endereco.matches(".*\\d.*")) {
            throw new RuntimeException("Endereço inválido.");
        }
    }

    private static Drone escolherDrone(double peso) {

        Drone melhor = null;

        for (Drone d : HashDatabase.drones.values()) {
            if (d.validarBateria() && d.validarPeso(peso)) {
                melhor = d;
                break; // arbitrário — pega o primeiro válido
            }
        }

        return melhor;
    }
}
