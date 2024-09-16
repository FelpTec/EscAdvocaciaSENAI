import java.util.*;
import java.util.function.Predicate;

public class Busca {
    public static List<ClientePF> clientesPF = new ArrayList<>();
    public static List<ClientePJ> clientesPJ = new ArrayList<>();
    public static List<Advogado> advogados = new ArrayList<>();
    public static List<Processos> processos = new ArrayList<>();


    public static void cadastrarClientePF(ClientePF clientePF) {
        clientesPF.add(clientePF);
    }

    public static void cadastrarClientePJ(ClientePJ clientePJ) {
        clientesPJ.add(clientePJ);
    }

    public static void cadastrarAdvogado(Advogado advogado) {
        advogados.add(advogado);
    }

    public static void cadastrarProcesso(Processos processo) {
        processos.add(processo);
    }

    /**
     * Método para buscar o primeiro objeto que corresponde ao predicado fornecido.
     *  list      Lista de objetos a ser pesquisada.
     *  predicate Condição para a busca.
     *  <T>       Tipo dos objetos na lista.
     *  Um Optional contendo o objeto encontrado, ou um Optional vazio se não for encontrado.
     */

    public static <T> Optional<T> findFirst(List<T> list, Predicate<T> predicate) {
        return list.stream()
                .filter(predicate)
                .findFirst();
    }

    public static void buscaAdvogado() {
        Scanner sc = new Scanner(System.in);
        System.out.println("=====================================");
        System.out.print("Insira o nome do Advogado: ");
        String nomeAdvogado = sc.nextLine();

        Optional<Advogado> encontrarAdvogado = Busca.findFirst(Busca.advogados, Advogados -> Advogados.getNome().equals(nomeAdvogado));

        if (encontrarAdvogado.isPresent()) {
            System.out.println("Processo Encontrado: " + encontrarAdvogado.get().mostrarDetalhes());
        } else {
            System.out.println("Processo Não Encontrado: " + nomeAdvogado);
        }
    }

    public static void buscaClientePF() {
        Scanner sc = new Scanner(System.in);
        System.out.println("=====================================");
        System.out.print("Insira o nome do ClientePF: ");
        String nomeClientePF = sc.nextLine();

        Optional<ClientePF> encontrarClientePF = Busca.findFirst(Busca.clientesPF, ClientesPF -> ClientesPF.getNome().equals(nomeClientePF));

        if (encontrarClientePF.isPresent()) {
            System.out.println("Processo Encontrado: " + encontrarClientePF.get().mostrarDetalhes());
        } else {
            System.out.println("Processo Não Encontrado: " + nomeClientePF);
        }
    }

    public static void buscaClientePJ() {
        Scanner sc = new Scanner(System.in);
        System.out.println("=====================================");
        System.out.print("Insira o nome do Cliente PJ: ");
        String nomeClientePJ = sc.nextLine();

        Optional<ClientePJ> encontrarClientePJ = Busca.findFirst(Busca.clientesPJ, ClientePJ -> ClientePJ.getNome().equals(nomeClientePJ));

        if (encontrarClientePJ.isPresent()) {
            System.out.println("Processo Encontrado: " + encontrarClientePJ.get().mostrarDetalhes());
        } else {
            System.out.println("Processo Não Encontrado: " + nomeClientePJ);
        }
    }

    public static void buscaProcessos() {
        Scanner sc = new Scanner(System.in);
        System.out.println("=====================================");
        System.out.print("Insira o nome do Processo: ");
        String nomeProcesso = sc.nextLine();

        Optional<Processos> encontrarProcesso = Busca.findFirst(Busca.processos, Processos -> Processos.getNome().equals(nomeProcesso));

        if (encontrarProcesso.isPresent()) {
            System.out.println("Processo Encontrado: " + encontrarProcesso.get().relatorioProcesso());
        } else {
            System.out.println("Processo Não Encontrado: " + nomeProcesso);
        }
    }

    public static void listarClientes() {
        System.out.println("=================================================");
        System.out.println("Clientes Cadastrados: ");

        for (int i = 0; i < Busca.clientesPJ.size(); i++) {
            System.out.println((i + 1) + " - PJ - " + Busca.clientesPJ.get(i).getNome());
        }

        for (int i = 0; i < Busca.clientesPF.size(); i++) {
            System.out.println((i + 1) + " - PF - " + Busca.clientesPF.get(i).getNome());
        }
    }

    public static void listarAdvogados() {
        System.out.println("=================================================");
        System.out.println("Advogados(as) da Firma: ");

        for (int i = 0; i < Busca.advogados.size(); i++) {
            System.out.println((i + 1) + " - PJ - " + Busca.advogados.get(i).getNome());
        }
    }

    public static void listarProcessos() {
        System.out.println("=================================================");
        System.out.println("Processos Cadastrados: ");
        for (int i = 0; i < Busca.processos.size(); i++) {
            System.out.println((i + 1) + " - " + Busca.processos.get(i).getNome() + " / " + Busca.processos.get(i).getStatus());
        }
    }
}