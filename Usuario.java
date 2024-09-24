public class Usuario {
    private Funcionario funcionario;
    private String login;
    private String senha;

    // Construtor
    public Usuario(Funcionario funcionario, String login, String senha) {
        this.funcionario = funcionario;
        this.login = login;
        this.senha = senha;
    }

    // Getters e Setters
    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // Método para realizar login
    public boolean realizarLogin(String login, String senha) {
        return this.login.equals(login) && this.senha.equals(senha);
    }
}
