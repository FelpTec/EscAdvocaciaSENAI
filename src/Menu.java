import java.util.*;

public class Menu {
    static int opcao1 = 0;

    public static void exibirMenu() {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("=================================================");
            System.out.print("""
                    Escritório de Advocacia
                    Menu Inicial

                    1 - Clientes.
                    2 - Advogados.
                    3 - Processos.
                    4 - Sair.

                    O que deseja?""");

            opcao1 = sc.nextInt();
            sc.nextLine(); // Limpar o buffer do scanner

            switch (opcao1) {
                case 1:
                    menuClientes(sc);
                    break;
                case 2:
                    menuAdvogados(sc);
                    break;
                case 3:
                    menuProcessos(sc);
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao1 != 4);
    }

    private static void menuClientes(Scanner sc) {
        int opcaoCliente;

        do {
            System.out.println("=================================================");
            System.out.println("""
                    1 - Cadastrar novo Cliente.
                    2 - Remover Cliente.
                    3 - Listar Clientes.
                    4 - Buscar por Cliente.
                    5 - Voltar ao Menu Inicial.
                    """);

            opcaoCliente = sc.nextInt();
            sc.nextLine(); // Limpar o buffer do scanner

            switch (opcaoCliente) {
                case 1:
                    System.out.println("=================================================");
                    System.out.println("""
                            1 - Cliente Pessoa Física.
                            2 - Cliente Pessoa Jurídica.
                            3 - Voltar ao Menu Inicial.
                            """);
                    int opcaoC = sc.nextInt();
                    sc.nextLine(); // Limpar o buffer do scanner

                    if (opcaoC == 1) {
                        ClientePF clientePF = ClientePF.inserirClientePF();
                        Busca.cadastrarClientePF(clientePF);
                    } else if (opcaoC == 2) {
                        ClientePJ clientePJ = ClientePJ.inserirClientePJ();
                        Busca.cadastrarClientePJ(clientePJ);
                    }
                    break;
                case 2:
                    System.out.println("=================================================");
                    System.out.println("""
                            1 - Cliente Pessoa Física.
                            2 - Cliente Pessoa Jurídica.
                            3 - Voltar ao Menu Inicial.
                            """);
                    int opcaoC2 = sc.nextInt();
                    sc.nextLine(); // Limpar o buffer do scanner

                    if (opcaoC2 == 1) {
                        ClientePF.removerClientePF();
                    } else if (opcaoC2 == 2) {
                        ClientePJ.removerClientePJ();
                    }
                    break;
                case 3:
                    Busca.listarClientes();
                    break;
                case 4:
                    System.out.println("=================================================");
                    System.out.println("""
                            1 - Cliente Pessoa Física.
                            2 - Cliente Pessoa Jurídica.
                            3 - Voltar ao Menu Inicial.
                            """);
                    int opcaoC4 = sc.nextInt();
                    sc.nextLine(); // Limpar o buffer do scanner

                    if (opcaoC4 == 1) {
                        Busca.buscaClientePF();
                    } else if (opcaoC4 == 2) {
                        Busca.buscaClientePJ();
                    }
                    break;
                case 5:
                    // Voltar ao Menu Inicial
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcaoCliente != 5);
    }

    private static void menuAdvogados(Scanner sc) {
        int opcaoAdvogado;

        do {
            System.out.println("=================================================");
            System.out.println("""
                    1 - Cadastrar novo Advogado.
                    2 - Remover Advogado.
                    3 - Listar Advogados.
                    4 - Buscar por Advogado.
                    5 - Voltar ao Menu Inicial.
                    """);

            opcaoAdvogado = sc.nextInt();
            sc.nextLine();

            switch (opcaoAdvogado) {
                case 1:
                    Advogado advogado = Advogado.inserirAdvogado();
                    Busca.cadastrarAdvogado(advogado);
                    break;
                case 2:
                    Advogado.removerAdvogado();
                    break;
                case 3:
                    Busca.listarAdvogados();
                    break;
                case 4:
                    Busca.buscaAdvogado();
                    break;
                case 5:

                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcaoAdvogado != 5);
    }

    private static void menuProcessos(Scanner sc) {
        int opcaoProcesso;

        do {
            System.out.println("=================================================");
            System.out.println("""
                    1 - Inserir novo Processo.
                    2 - Remover Processo.
                    3 - Listar Processos.
                    4 - Buscar por Processo.
                    5 - Voltar ao Menu Inicial.
                    """);

            opcaoProcesso = sc.nextInt();
            sc.nextLine(); // Limpar o buffer do scanner

            switch (opcaoProcesso) {
                case 1:
                    Processos processo = Processos.InserirProcessos(Busca.advogados, Busca.clientesPF, Busca.clientesPJ);
                    Busca.cadastrarProcesso(processo);
                    break;
                case 2:
                    Processos.removerProcesso();
                    break;
                case 3:
                    Busca.listarProcessos();
                    break;
                case 4:
                    Busca.buscaProcessos();
                    break;
                case 5:
                    // Voltar ao Menu Inicial
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcaoProcesso != 5);
    }
}
