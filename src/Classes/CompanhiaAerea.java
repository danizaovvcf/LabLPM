package Classes;
import java.util.Scanner;

public class CompanhiaAerea {
    private String nome;
    private String codigo;
    private String razao_social;
    private String cnpj;

    public CompanhiaAerea(String nome, String codigo, String razao_social, String cnpj) {
        this.nome = nome;
        this.codigo = codigo;
        this.razao_social = razao_social;
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public static CompanhiaAerea CadastrarCompanhia() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome da companhia aérea: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o código da companhia aérea: ");
        String codigo = scanner.nextLine();

        System.out.print("Digite a razão social da companhia aérea: ");
        String razao_social = scanner.nextLine();

        System.out.print("Digite o CNPJ da companhia aérea: ");
        String cnpj = scanner.nextLine();

        CompanhiaAerea companhia = new CompanhiaAerea(nome, codigo, razao_social, cnpj);
        System.out.println("Companhia aérea cadastrada com sucesso!");
        return companhia;
    }

    
}
