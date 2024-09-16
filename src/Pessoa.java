import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.*;

abstract class Pessoa {
    protected  String nome;
    protected  String dataNascimento; // Formato: "dd/MM/yyyy"
    protected  String telefone;
    protected  String endereco;

    public Pessoa(String nome, String dataNascimento, String telefone, String endereco) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public String mostrarDetalhes() {
        System.out.println("Nome: " + getNome());
        System.out.println("Data de Nascimento: " + getDataNascimento());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("Endereço: " + getEndereco());
        return null;
    }

    public static boolean validarDataNascimento(String dataStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dataNascimento;

        try {
            // Tenta analisar a data com o formato fornecido
            dataNascimento = LocalDate.parse(dataStr, formatter);
        } catch (DateTimeParseException e) {
            // A data está no formato errado ou é inválida
            return false;
        }

        // Verifica se a data não está no futuro
        LocalDate hoje = LocalDate.now();
        if (dataNascimento.isAfter(hoje)) {
            return false;
        }

        // Verifica se a pessoa é maior de idade (por exemplo, 18 anos)
        LocalDate dezoitoAnosAtras;
        dezoitoAnosAtras = hoje.minusYears(18);
        return !dataNascimento.isAfter(dezoitoAnosAtras);
    }
}
