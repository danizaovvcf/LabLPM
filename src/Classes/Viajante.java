package Classes;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Viajante {
    private String nome;
    private String sobrenome;
    private String documento;

    // Construtor
    public Viajante(String nome, String sobrenome, String documento) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
    }


    public String getNome() {
        return nome;
    }



    public void setNome(String nome) {
        this.nome = nome;
    }



    public String getSobrenome() {
        return sobrenome;
    }



    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }



    public String getDocumento() {
        return documento;
    }



    public void setDocumento(String documento) {
        this.documento = documento;
    }



    // Método para pesquisar voos
    public List<PassagemAerea> PesquisarVoo(Aeroporto origem, Aeroporto destino, Date data) {
        List<PassagemAerea> voosDisponiveis = new ArrayList<>();
        return voosDisponiveis;
    }

    // Método para emitir bilhete
    public void EmitirBilhete() {
        System.out.println("Bilhete emitido com sucesso para o viajante " + nome + " " + sobrenome);
    }
}
