import java.util.*;

public class Advogado extends Pessoa {
    private final String identidadeAdv;
    private final Double honorario;
    private final String areaDeAtuacao;

    public Advogado(String nome, String dataNascimento, String telefone, String endereco, String identidadeAdv, Double honorario, String areaDeAtuacao) {
        super(nome, dataNascimento, telefone, endereco);
        this.identidadeAdv = identidadeAdv;
        this.honorario = honorario;
        this.areaDeAtuacao = areaDeAtuacao;
    }

    public String getIdentidadeAdv() {
        return identidadeAdv;
    }

    public Double getHonorario() {
        return honorario;
    }

    public String getAreaDeAtuacao() {
        return areaDeAtuacao;
    }

    public static Advogado inserirAdvogado() {
        Scanner sc = new Scanner(System.in);
        String dataNascimento = null;
        String areaDeAtuacao = null;

        System.out.println("=====================================");
        System.out.println("Cadastro de Advogado");

        System.out.print("Insira o nome do advogado: ");
            String nome = sc.nextLine();

        while(dataNascimento == null) {

            System.out.print("\nInsira a data de Nascimento do advogado (Formato yyyy-MM-dd): ");
            dataNascimento = sc.nextLine();

            if (validarDataNascimento(dataNascimento)) {
                System.out.println("Data de nascimento válida.");
            } else {
                System.out.println("Data de nascimento inválida.");
                dataNascimento = null;
            }
        }

        System.out.print("\nInsira o telefone do advogado: ");
            String telefone = sc.nextLine();

        System.out.print("\nInsira o endereço do advogado: ");
            String endereco = sc.nextLine();

        System.out.print("\nInsira a identidade do advogado: ");
            String identidadeAdv = sc.nextLine();

        System.out.print("\nInsira o valor de honorário do advogado: ");
            Double honorario = sc.nextDouble();
            sc.nextLine();

        System.out.println("""
                1 - Direito Digital
                2 - Direito do Consumidor
                3 - Direito Civil
                4 - Direito Tributário
                5 - Direito Ambiental
                6 - Direito Penal
                7 - Direito Trabalhista
                """);
        System.out.print("\nInsira a área de atuação do advogado: ");

        while (areaDeAtuacao == null) {
            int opcao = sc.nextInt();
            sc.nextLine();
            if (opcao == 1) {
                areaDeAtuacao = "Direito Digital";
            } else if (opcao == 2) {
                areaDeAtuacao = "Direito do Consumidor";
            } else if (opcao == 3) {
                areaDeAtuacao = "Direito Civil";
            } else if (opcao == 4) {
                areaDeAtuacao = "Direito Tributario";
            } else if (opcao == 5) {
                areaDeAtuacao = "Direito Ambiental";
            } else if (opcao == 6) {
                areaDeAtuacao = "Direito Penal";
            } else if (opcao == 7) {
                areaDeAtuacao = "Direito Trabalhista";
            }
            else {
                System.out.println("Área de atuação inexistente, tente novamente.");
                System.out.print("Insira a área de atuação do advogado: ");
            }
        }
        System.out.println("Advogado cadastrado com sucesso!");
        return new Advogado(nome, dataNascimento, telefone, endereco, identidadeAdv, honorario, areaDeAtuacao);
    }

    public static void removerAdvogado() {
        Scanner sc = new Scanner(System.in);

        System.out.println("=================================================");
        System.out.println("Selecione um Advogado(a):");
        for (int i = 0; i < Busca.advogados.size(); i++) {
            System.out.println((i + 1) + " - " + Busca.advogados.get(i).getNome());
        }

        int escolhaAdvogado = sc.nextInt();
        sc.nextLine();
        if (escolhaAdvogado >= 1 && escolhaAdvogado <= Busca.advogados.size()) {
            Advogado advogadoSelecionado = Busca.advogados.get(escolhaAdvogado - 1);
            Busca.advogados.remove(advogadoSelecionado); // Remova da lista ou coleção
            System.out.println("Advogado(a) removido com sucesso.");
        } else {
            System.out.println("Advogado(a) inválido.");
        }
    }

    @Override
    public String mostrarDetalhes() {
        System.out.println("Nome: " + getNome());
        System.out.println("Data de Nascimento: " + getDataNascimento());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("Endereço: " + getEndereco());
        System.out.println("Identidade: " + getIdentidadeAdv());
        System.out.println("Área de Atuação: " + getAreaDeAtuacao());
        System.out.println("Honorário: " + getHonorario() + "R$");
        return null;
    }
}
