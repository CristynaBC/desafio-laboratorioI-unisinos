import java.util.Scanner;
public class Principal {
    public static void main(String[] args) {
        int opcaoSelecionada;
        Scanner input = new Scanner(System.in);

        System.out.println("Bem-vindo(a)! Por favor, digite o número referente à opção desejada:\n (1): criar uma loja \n (2): criar um produto \n (3): sair");
        opcaoSelecionada = input.nextInt();
        input.nextLine();

        switch (opcaoSelecionada) {
            case 1:
                criarLoja(input);
                break;
            case 2:
                criarProduto(input);
                input.close();
                break;
            case 3:
                System.out.println("Saindo do programa, até mais!");
                input.close();
                break;
            default:
                throw new IllegalStateException("Opção inválida");
        }
    }
    private static Endereco lerEndereco(Scanner input) {
        System.out.println("Endereço da loja: ");
        System.out.println("Nome da rua:");
        String nomeDaRua = input.nextLine();
        System.out.println("Cidade:");
        String cidade = input.nextLine();
        System.out.println("Estado:");
        String estado = input.nextLine();
        System.out.println("País:");
        String pais = input.nextLine();
        System.out.println("CEP:");
        String cep = input.nextLine();
        System.out.println("Número:");
        String numero = input.nextLine();
        System.out.println("Complemento:");
        String complemento = input.nextLine();

        return new Endereco(nomeDaRua, cidade, estado, pais, cep, numero, complemento);
    }
    private static Data lerData(Scanner input) {
        System.out.println("Dia:");
        int dia = input.nextInt();
        System.out.println("Mês:");
        int mes = input.nextInt();
        System.out.println("Ano:");
        int ano = input.nextInt();
        input.nextLine();

        return new Data(dia, mes, ano);
    }
    private static void criarLoja(Scanner input) {
        System.out.println("Nome da loja:");
        String nomeDaLoja = input.nextLine();
        System.out.println("Quantidade de funcionários:");
        int quantidadeDeFuncionarios = input.nextInt();
        System.out.println("Salário base dos funcionários:");
        double salarioBaseDosFuncionarios = input.nextDouble();
        input.nextLine();
        System.out.println("Tamanho do Estoque?");
        int tamanhoEstoque = input.nextInt();
        input.nextLine();
        Endereco endereco = lerEndereco(input);
        System.out.println("Data de fundação:");
        Data dataFundacao = lerData(input);

        Loja loja = new Loja(nomeDaLoja, quantidadeDeFuncionarios, salarioBaseDosFuncionarios, endereco, dataFundacao, tamanhoEstoque);

        System.out.println("Loja criada com sucesso! \nDados da loja:\n" +
                "Nome: " + nomeDaLoja + "\n" +
                "Quantidade de funcionários: " + quantidadeDeFuncionarios + "\n" +
                "Salário base dos Funcionários: " + salarioBaseDosFuncionarios + "\n" +
                "Endereço:\n" + endereco.toString() + "\n" +  "\nTamanho do estoque" + tamanhoEstoque +
                "Data de Fundação: " + dataFundacao.toString());

    }
    private static void criarProduto(Scanner input) {
        Data dataVencimento = new Data(20,10,2023);
        System.out.println("Nome do produto: ");
        String nomeDoProduto = input.nextLine();
        System.out.println("Preço do produto: ");
        int precoDoProduto = input.nextInt();
        input.nextLine();
        System.out.println("Data de validade:");
        Data dataValidade = lerData(input);

        Produto produto = new Produto(nomeDoProduto,precoDoProduto,dataValidade);
        String mensagemVencimento = produto.estaVencido(dataVencimento) ? "PRODUTO VENCIDO" : "PRODUTO NÃO VENCIDO";
        System.out.println(mensagemVencimento);

    }
}

