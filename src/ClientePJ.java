import java.util.*;

public class ClientePJ extends Pessoa{
    private final String cnpj;

    public ClientePJ(String nome, String dataNascimento, String telefone, String endereco, String cnpj) {
        super(nome, dataNascimento, telefone, endereco);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public static ClientePJ inserirClientePJ() {
        Scanner sc = new Scanner(System.in);
        String dataNascimento = null;

        System.out.println("=====================================");
        System.out.println("Cadastro de Cliente PJ");
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

        return new ClientePJ(nome, dataNascimento, telefone, endereco, cnpj);
    }

    public static void removerClientePJ() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Selecione um cliente PJ:");
        for (int i = 0; i < Busca.clientesPJ.size(); i++) {
            System.out.println((i + 1) + " - " + Busca.clientesPJ.get(i).getNome());
        }

        int escolhaClientePJ = sc.nextInt();
        sc.nextLine();
        if (escolhaClientePJ >= 1 && escolhaClientePJ <= Busca.clientesPJ.size()) {
            ClientePJ clientePJSelecionado = Busca.clientesPJ.get(escolhaClientePJ - 1);
            Busca.clientesPJ.remove(clientePJSelecionado); // Remova da lista ou coleção
            System.out.println("Cliente PJ removido com sucesso.");
        } else {
            System.out.println("Cliente PJ inválido.");
        }
    }

    @Override
    public String mostrarDetalhes() {
        System.out.println("Nome: " + getNome());
        System.out.println("Data de Nascimento: " + getDataNascimento());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("Endereço: " + getEndereco());
        System.out.println("CNPJ: " + getCnpj());
        return null;
    }
}
