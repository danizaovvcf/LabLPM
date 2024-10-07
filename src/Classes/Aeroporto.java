package Classes;
import java.util.Scanner;

public class Aeroporto {
    private String nome;
    private String sigla;
    private String cidade;
    private String estado;
    private String país;

    public Aeroporto(String nome, String sigla, String cidade, String estado, String país) {
        this.nome = nome;
        this.sigla = sigla;
        this.cidade = cidade;
        this.estado = estado;
        this.país = país;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPaís() {
        return país;
    }

    public void setPaís(String país) {
        this.país = país;
    }

    public static Aeroporto CadastrarAeroporto() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do aeroporto: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a sigla do aeroporto: ");
        String sigla = scanner.nextLine();

        System.out.print("Digite a cidade do aeroporto: ");
        String cidade = scanner.nextLine();

        System.out.print("Digite o estado do aeroporto: ");
        String estado = scanner.nextLine();

        System.out.print("Digite o país do aeroporto: ");
        String pais = scanner.nextLine();

        Aeroporto aeroporto = new Aeroporto(nome, sigla, cidade, estado, pais);
        System.out.println("Aeroporto cadastrado com sucesso!");
        return aeroporto;
    }

    
}
