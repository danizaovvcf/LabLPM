public class Funcionario {
    private String nome;
    private String cpf;
    private String email;

    // Construtor
    public Funcionario(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    // Getters e Setters
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Método toString para facilitar a visualização dos dados
    @Override
    public String toString() {
        return "Funcionario [Nome: " + nome + ", CPF: " + cpf + ", Email: " + email + "]";
    }
}
