import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class AgenciaViagens {

    private static List<Funcionario> funcionarios = new ArrayList<>();
    private static List<Usuario> usuarios = new ArrayList<>();
    private static List<CompanhiaAerea> companhiasAereas = new ArrayList<>();
    private static List<Aeroporto> aeroportos = new ArrayList<>();
    private static List<PassagemAerea> passagens = new ArrayList<>();
    private static final double TAXA_REMUNERACAO = 0.1; // 10% de taxa de remuneração

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    cadastrarFuncionario(scanner);
                    break;
                case 2:
                    cadastrarUsuario(scanner);
                    break;
                case 3:
                    realizarLogin(scanner);
                    break;
                case 4:
                    cadastrarCompanhiaAerea(scanner);
                    break;
                case 5:
                    cadastrarAeroporto(scanner);
                    break;
                case 6:
                    cadastrarPassagem(scanner);
                    break;
                case 7:
                    pesquisarVoos(scanner);
                    break;
                case 8:
                    comprarPassagem(scanner);
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n===== Agência de Viagens =====");
        System.out.println("1. Cadastrar Funcionário");
        System.out.println("2. Cadastrar Usuário");
        System.out.println("3. Realizar Login");
        System.out.println("4. Cadastrar Companhia Aérea");
        System.out.println("5. Cadastrar Aeroporto");
        System.out.println("6. Cadastrar Passagem");
        System.out.println("7. Pesquisar Voos");
        System.out.println("8. Comprar Passagem");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarFuncionario(Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("E-mail: ");
        String email = scanner.nextLine();

        Funcionario funcionario = new Funcionario(nome, cpf, email);
        funcionarios.add(funcionario);
        System.out.println("Funcionário cadastrado com sucesso!");
    }

    private static void cadastrarUsuario(Scanner scanner) {
        System.out.print("CPF do funcionário: ");
        String cpfFuncionario = scanner.nextLine();

        Funcionario funcionario = buscarFuncionarioPorCpf(cpfFuncionario);
        if (funcionario == null) {
            System.out.println("Funcionário não encontrado!");
            return;
        }

        System.out.print("Login: ");
        String login = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        Usuario usuario = new Usuario(funcionario, login, senha);
        usuarios.add(usuario);
        System.out.println("Usuário cadastrado com sucesso!");
    }

    private static void realizarLogin(Scanner scanner) {
        System.out.print("Login: ");
        String login = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        for (Usuario usuario : usuarios) {
            if (usuario.realizarLogin(login, senha)) {
                System.out.println("Login realizado com sucesso!");
                return;
            }
        }

        System.out.println("Login ou senha inválidos!");
    }

    private static void cadastrarCompanhiaAerea(Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        System.out.print("Razão Social: ");
        String razaoSocial = scanner.nextLine();
        System.out.print("CNPJ: ");
        String cnpj = scanner.nextLine();
        System.out.print("Valor da primeira bagagem: ");
        double valorPrimeiraBagagem = scanner.nextDouble();
        System.out.print("Valor das bagagens adicionais: ");
        double valorBagagemAdicional = scanner.nextDouble();

        CompanhiaAerea companhia = new CompanhiaAerea(nome, codigo, razaoSocial, cnpj, valorPrimeiraBagagem, valorBagagemAdicional);
        companhiasAereas.add(companhia);
        System.out.println("Companhia aérea cadastrada com sucesso!");
    }

    private static void cadastrarAeroporto(Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Sigla (3 letras): ");
        String sigla = scanner.nextLine();
        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();
        System.out.print("Estado: ");
        String estado = scanner.nextLine();
        System.out.print("País: ");
        String pais = scanner.nextLine();

        Aeroporto aeroporto = new Aeroporto(nome, sigla, cidade, estado, pais);
        aeroportos.add(aeroporto);
        System.out.println("Aeroporto cadastrado com sucesso!");
    }

    private static void cadastrarPassagem(Scanner scanner) {
        System.out.print("Sigla do aeroporto de origem: ");
        String siglaOrigem = scanner.nextLine();
        Aeroporto aeroportoOrigem = buscarAeroportoPorSigla(siglaOrigem);
        if (aeroportoOrigem == null) {
            System.out.println("Aeroporto de origem não encontrado!");
            return;
        }

        System.out.print("Sigla do aeroporto de destino: ");
        String siglaDestino = scanner.nextLine();
        Aeroporto aeroportoDestino = buscarAeroportoPorSigla(siglaDestino);
        if (aeroportoDestino == null) {
            System.out.println("Aeroporto de destino não encontrado!");
            return;
        }

        System.out.print("Data e hora do voo (dd/MM/yyyy HH:mm): ");
        Date dataHora = null;
        try {
            dataHora = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(scanner.nextLine());
        } catch (ParseException e) {
            System.out.println("Formato de data e hora inválido!");
            return;
        }

        System.out.print("Código do voo (XX9999): ");
        String codigoVoo = scanner.nextLine();

        System.out.print("Código da companhia aérea: ");
        String codigoCompanhia = scanner.nextLine();
        CompanhiaAerea companhia = buscarCompanhiaAereaPorCodigo(codigoCompanhia);
        if (companhia == null) {
            System.out.println("Companhia aérea não encontrada!");
            return;
        }

        System.out.print("Valor da tarifa básica: ");
        double valorTarifaBasica = scanner.nextDouble();
        System.out.print("Valor da tarifa business: ");
        double valorTarifaBusiness = scanner.nextDouble();
        System.out.print("Valor da tarifa premium: ");
        double valorTarifaPremium = scanner.nextDouble();

        PassagemAerea passagem = new PassagemAerea(aeroportoOrigem, aeroportoDestino, dataHora, codigoVoo,
                companhia, valorTarifaBasica, valorTarifaBusiness, valorTarifaPremium);
        passagens.add(passagem);
        System.out.println("Passagem cadastrada com sucesso!");
    }

    private static void pesquisarVoos(Scanner scanner) {
        System.out.print("Sigla do aeroporto de origem: ");
        String siglaOrigem = scanner.nextLine();
        Aeroporto aeroportoOrigem = buscarAeroportoPorSigla(siglaOrigem);
        if (aeroportoOrigem == null) {
            System.out.println("Aeroporto de origem não encontrado!");
            return;
        }

        System.out.print("Sigla do aeroporto de destino: ");
        String siglaDestino = scanner.nextLine();
        Aeroporto aeroportoDestino = buscarAeroportoPorSigla(siglaDestino);
        if (aeroportoDestino == null) {
            System.out.println("Aeroporto de destino não encontrado!");
            return;
        }

        System.out.println("Voos disponíveis:");
        for (PassagemAerea passagem : passagens) {
            if (passagem.getAeroportoOrigem().equals(aeroportoOrigem) &&
                passagem.getAeroportoDestino().equals(aeroportoDestino)) {
                System.out.println(passagem);
            }
        }
    }

    private static void comprarPassagem(Scanner scanner) {
        System.out.print("Código da passagem: ");
        String codigoPassagem = scanner.nextLine();

        for (PassagemAerea passagem : passagens) {
            if (passagem.getCodigoVoo().equals(codigoPassagem)) {
                System.out.println("Passagem encontrada: " + passagem);
                System.out.print("Deseja comprar essa passagem? (s/n): ");
                String resposta = scanner.nextLine();
                if (resposta.equalsIgnoreCase("s")) {
                    System.out.println("Passagem comprada com sucesso!");
                } else {
                    System.out.println("Compra cancelada.");
                }
                return;
            }
        }

        System.out.println("Passagem não encontrada!");
    }

    private static Funcionario buscarFuncionarioPorCpf(String cpf) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCpf().equals(cpf)) {
                return funcionario;
            }
        }
        return null;
    }

    private static Aeroporto buscarAeroportoPorSigla(String sigla) {
        for (Aeroporto aeroporto : aeroportos) {
            if (aeroporto.getSigla().equals(sigla)) {
                return aeroporto;
            }
        }
        return null;
    }

    private static CompanhiaAerea buscarCompanhiaAereaPorCodigo(String codigo) {
        for (CompanhiaAerea companhia : companhiasAereas) {
            if (companhia.getCodigo().equals(codigo)) {
                return companhia;
            }
        }
        return null;
    }
}
