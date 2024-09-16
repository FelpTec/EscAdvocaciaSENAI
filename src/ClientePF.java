import java.util.Scanner;

public class ClientePF extends Pessoa {
    private final String identidade;

    public ClientePF(String nome, String dataNascimento, String telefone, String endereco, String identidade) {
        super(nome, dataNascimento, telefone, endereco);
        this.identidade = identidade;
    }

    public String getIdentidade() {
        return identidade;
    }

    public static ClientePF inserirClientePF() {
        Scanner sc = new Scanner(System.in);
        String dataNascimento = null;

        System.out.println("=====================================");
        System.out.println("Cadastro de Cliente PF");
        System.out.print("Insira o nome do cliente: ");
        String nome = sc.nextLine();

        while(dataNascimento == null) {

            System.out.print("\nInsira a data de Nascimento do Cliente (Formato yyyy-MM-dd): ");
            dataNascimento = sc.nextLine();

            if (validarDataNascimento(dataNascimento)) {
                System.out.println("Data de nascimento válida.");
            } else {
                System.out.println("Data de nascimento inválida.");
                dataNascimento = null;
            }
        }

        System.out.println("Insira o telefone do cliente: ");
        String telefone = sc.nextLine();

        System.out.println("Insira o endereco do cliente: ");
        String endereco = sc.nextLine();

        System.out.println("Insira o cnpj do cliente: ");
        String cnpj = sc.nextLine();

        System.out.println("Cliente cadastrado com sucesso!");
        return new ClientePF(nome, dataNascimento, telefone, endereco, cnpj);
    }

    public static void removerClientePF() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Selecione um cliente PF:");
        for (int i = 0; i < Busca.clientesPF.size(); i++) {
            System.out.println((i + 1) + " - " + Busca.clientesPF.get(i).getNome());
        }

        int escolhaClientePF = sc.nextInt();
        sc.nextLine();
        if (escolhaClientePF >= 1 && escolhaClientePF <= Busca.clientesPF.size()) {
            ClientePF clientePFSelecionado = Busca.clientesPF.get(escolhaClientePF - 1);
            Busca.clientesPF.remove(clientePFSelecionado); // Remova da lista ou coleção
            System.out.println("Cliente PF removido com sucesso.");
        } else {
            System.out.println("Cliente PF inválido.");
        }
    }

    @Override
    public String mostrarDetalhes() {
        System.out.println("Nome: " + getNome());
        System.out.println("Data de Nascimento: " + getDataNascimento());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("Endereço: " + getEndereco());
        System.out.println("Identidade: " + getIdentidade());
        return null;
    }
}
