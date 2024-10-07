package Classes;
import java.util.Scanner;

public class Usuario {
    private String nome;
    private String cpf;
    private String senha;

    public Usuario(String nome, String cpf, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public static Usuario RealizarCadastro() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do usuário: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o CPF do usuário: ");
        String cpf = scanner.nextLine();

        System.out.print("Digite a senha do usuário: ");
        String senha = scanner.nextLine();

        if (nome.isEmpty() || cpf.isEmpty() || senha.isEmpty()) {
            System.out.println("Todos os campos são obrigatórios.");
            return null;
        }

        Usuario usuario = new Usuario(nome, cpf, senha);
        System.out.println("Usuário cadastrado com sucesso!");
        return usuario;
    }

    
}
