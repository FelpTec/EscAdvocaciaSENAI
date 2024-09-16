import java.util.*;

public class Processos {
    private final String descricao;
    private final String nome;
    private final String tribunal;
    private final String status;
    private final String areaProcesso;
    private final Advogado advogado;
    private ClientePJ clientePJ;
    private final ClientePF clientePF;

    public Processos(String descricao, String nome, String tribunal, String status,String areaProcesso, Advogado advogado, ClientePJ clientePJ, ClientePF clientePF) {
        this.descricao = descricao;
        this.nome = nome;
        this.tribunal = tribunal;
        this.status = status;
        this.areaProcesso = advogado.getAreaDeAtuacao();
        this.advogado = advogado;

        if (clientePJ != null) {
            this.clientePJ = clientePJ;
        }
        if (clientePF != null) {
            this.clientePF = clientePF;
        }
        else {
            this.clientePJ = null;
            this.clientePF = null;
        }
    }

    public String getNome() {
        return nome;
    }

    public String getStatus() {
        return status;
    }

    public static Processos InserirProcessos(List<Advogado> advogados, List<ClientePF> clientesPF, List<ClientePJ> clientesPJ) {
        Scanner sc = new Scanner(System.in);

        String tribunal = null;
        String status = "Em aberto.";

        System.out.println("=====================================");
        System.out.println("Inserção de Processos");
        System.out.print("Insira o nome do processo: ");
        String nome = sc.nextLine();
        System.out.println("Insira a descrição do processo: ");
        String descricao = sc.nextLine();
        System.out.println("Insira o tribunal do processo: ");

        System.out.println("""
                        1 - Supremo Tribunal Federal (STF)
                        2 - Superior Tribunal de Justiça (STJ)
                        3 - Tribunal Superior do Trabalho (TST)
                        4 - Tribunal Superior Eleitoral (TSE)
                        5 - Superior Tribunal Militar (STM).""");

        while (tribunal == null) {
            int opcao = sc.nextInt();
            sc.nextLine();
            if (opcao == 1) {
                tribunal = "Supremo Tribunal Federal (STF)";
            } else if (opcao == 2) {
                tribunal = "Superior Tribunal de Justiça (STJ)";
            } else if (opcao == 3) {
                tribunal = "Tribunal Superior do Trabalho (TST)";
            } else if (opcao == 4) {
                tribunal = "Tribunal Superior do Eleitoral (TSE)";
            } else if (opcao == 5) {
                tribunal = "Superior Tribunal Militar (STM)";
            } else {
                System.out.println("Tribunal inexistente, tente novamente.");
                System.out.print("Insira o tribunal do processo: ");
            }
        }

        System.out.println("Selecione um advogado:");
        for (int i = 0; i < advogados.size(); i++) {
            System.out.println((i + 1) + " - " + advogados.get(i).getNome() + " / " + advogados.get(i).getAreaDeAtuacao());
        }

        Advogado advogadoSelecionado = null;
        while (advogadoSelecionado == null) {
            int escolhaAdvogado = sc.nextInt();
            sc.nextLine();
            if (escolhaAdvogado >= 1 && escolhaAdvogado <= advogados.size()) {
                advogadoSelecionado = advogados.get(escolhaAdvogado - 1);
            } else {
                System.out.println("Advogado inválido, tente novamente.");
            }
        }

        // Seleção do cliente PJ ou PF
        ClientePJ clientePJSelecionado = null;
        ClientePF clientePFSelecionado = null;

        System.out.println("Selecione um cliente PJ ou PF:");
        System.out.println("1 - Selecionar Cliente PJ");
        System.out.println("2 - Selecionar Cliente PF");
        System.out.println("3 - Nenhum cliente");

        int tipoCliente = sc.nextInt();
        sc.nextLine();

        switch (tipoCliente) {
            case 1 -> {
                System.out.println("Selecione um cliente PJ:");
                for (int i = 0; i < clientesPJ.size(); i++) {
                    System.out.println((i + 1) + " - " + clientesPJ.get(i).getNome());
                }

                int escolhaClientePJ = sc.nextInt();
                sc.nextLine();
                if (escolhaClientePJ >= 1 && escolhaClientePJ <= clientesPJ.size()) {
                    clientePJSelecionado = clientesPJ.get(escolhaClientePJ - 1);
                } else {
                    System.out.println("Cliente PJ inválido.");
                }
            }
            case 2 -> {
                System.out.println("Selecione um cliente PF:");
                for (int i = 0; i < clientesPF.size(); i++) {
                    System.out.println((i + 1) + " - " + clientesPF.get(i).getNome());
                }

                int escolhaClientePF = sc.nextInt();
                sc.nextLine();
                if (escolhaClientePF >= 1 && escolhaClientePF <= clientesPF.size()) {
                    clientePFSelecionado = clientesPF.get(escolhaClientePF - 1);
                } else {
                    System.out.println("Cliente PF inválido.");
                }
            }
            case 3 -> System.out.println("Nenhum cliente selecionado.");
            default -> System.out.println("Opção inválida.");
        }
        System.out.println("Processo inserido com sucesso!");
        return new Processos(descricao, nome, tribunal, status,null , advogadoSelecionado, clientePJSelecionado, clientePFSelecionado);
    }

    public static void removerProcesso() {
        Scanner sc = new Scanner(System.in);

        System.out.println("=================================================");
        System.out.println("Selecione um Processo:");
        for (int i = 0; i < Busca.processos.size(); i++) {
            System.out.println((i + 1) + " - " + Busca.processos.get(i).getNome() + " / " + Busca.processos.get(i).getStatus());
        }

        int escolhaProcesso = sc.nextInt();
        sc.nextLine();
        if (escolhaProcesso >= 1 && escolhaProcesso <= Busca.processos.size()) {
            Processos processoSelecionado = Busca.processos.get(escolhaProcesso - 1);
            Busca.processos.remove(processoSelecionado); // Remova da lista ou coleção
            System.out.println("Processo removido com sucesso.");
        } else {
            System.out.println("Processo inválido.");
        }
    }

    public String relatorioProcesso() {
        System.out.println("===============================================");
        System.out.println("Relatório do Processo:");
        System.out.println("\nNome do Processo: " + this.nome);
        System.out.println("\nDescrição do Processo: " + this.descricao);
        System.out.println("\nTribunal do Processo: " + this.tribunal);
        System.out.println("\nStatus do processo: " + this.status);
        System.out.println("\nÁrea do Processo: " + this.areaProcesso);
        System.out.println("\nAdvogado(a) do processo: " + advogado.getNome());

        if (clientePJ != null) {
            System.out.println("\nCliente PJ: " + clientePJ.getNome());
        }
        else if (clientePF != null) {
            System.out.println("\nCliente PF: " + clientePF.getNome());
        }
        return null;
    }
}
