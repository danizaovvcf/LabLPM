package Classes;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Criar listas para armazenar objetos criados
        List<Funcionario> funcionarios = new ArrayList<>();
        List<Usuario> usuarios = new ArrayList<>();
        List<CompanhiaAerea> companhias = new ArrayList<>();
        List<Aeroporto> aeroportos = new ArrayList<>();
        List<PassagemAerea> passagens = new ArrayList<>();

        // Cadastrar um funcionário
        System.out.println("=== Cadastrar Funcionário ===");
        Funcionario funcionario = Funcionario.CadastrarFuncionario();
        if (funcionario != null) {
            funcionarios.add(funcionario);
        }

        // Realizar cadastro de usuário
        System.out.println("\n=== Cadastrar Usuário ===");
        Usuario usuario = Usuario.RealizarCadastro();
        if (usuario != null) {
            usuarios.add(usuario);
        }

        // Cadastrar uma companhia aérea
        System.out.println("\n=== Cadastrar Companhia Aérea ===");
        CompanhiaAerea companhiaAerea = CompanhiaAerea.CadastrarCompanhia();
        if (companhiaAerea != null) {
            companhias.add(companhiaAerea);
        }

        // Cadastrar um aeroporto de origem
        System.out.println("\n=== Cadastrar Aeroporto de Origem ===");
        Aeroporto aeroportoOrigem = Aeroporto.CadastrarAeroporto();
        if (aeroportoOrigem != null) {
            aeroportos.add(aeroportoOrigem);
        }

        // Cadastrar um aeroporto de destino
        System.out.println("\n=== Cadastrar Aeroporto de Destino ===");
        Aeroporto aeroportoDestino = Aeroporto.CadastrarAeroporto();
        if (aeroportoDestino != null) {
            aeroportos.add(aeroportoDestino);
        }

        // Cadastrar uma passagem aérea
        System.out.println("\n=== Cadastrar Passagem Aérea ===");
        System.out.print("Digite a data e hora do voo (em milissegundos desde a época): ");
        long dataHora = scanner.nextLong();
        scanner.nextLine();  // Consumir nova linha

        System.out.print("Digite o código do voo: ");
        String codigoVoo = scanner.nextLine();

        System.out.print("Digite o valor da tarifa básica: ");
        double valorBasico = scanner.nextDouble();

        System.out.print("Digite o valor da tarifa business: ");
        double valorBusiness = scanner.nextDouble();

        System.out.print("Digite o valor da tarifa premium: ");
        double valorPremium = scanner.nextDouble();

        System.out.print("Digite o valor da primeira bagagem: ");
        double valorBagagem = scanner.nextDouble();

        System.out.print("Digite o valor das bagagens adicionais: ");
        double valorAdicional = scanner.nextDouble();
        scanner.nextLine();  // Consumir nova linha

        System.out.print("Digite a moeda: ");
        String moeda = scanner.nextLine();

        System.out.print("O voo é internacional? (true/false): ");
        boolean internacional = scanner.nextBoolean();

        PassagemAerea passagem = PassagemAerea.CadastrarPassagem(
            aeroportoOrigem, aeroportoDestino, companhiaAerea, new Date(dataHora),
            codigoVoo, valorBasico, valorBusiness, valorPremium, valorBagagem,
            valorAdicional, moeda, internacional
        );
        passagens.add(passagem);

        System.out.println("\n=== Realizar Compra ===");
        Compra compra = new Compra(passagens, 0.1);
        compra.RealizarCompra();

        Viajante viajante = new Viajante("João", "Silva", "123456789");
        viajante.EmitirBilhete();

        System.out.println("Valor total da compra: " + compra.CalcularRemuneracao());

        scanner.close();
    }
}
