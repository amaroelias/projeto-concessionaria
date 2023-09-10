import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Scanner;

public class Main implements Serializable {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Concessionaria concessionaria = Concessionaria.carregaDados("dados_concessionaria.ser");


        final int cliente = 1,
                funcionario = 2,
                verCatalogo = 1,
                pesquisarModelo = 2,
                simularCompra = 3,
                agendarNegociacao = 4,
                exibirVeiculos = 1,
                adicionarVeiculos = 2,
                efetuarVenda = 3,
                efetuarTroca = 4,
                exibirAgendamentos = 5,
                exibirRelatorios = 6,
                sair = 0;


        final String menuLoja =
                "Olá! Bem-vindo(a) ao sistema da A&C concessionária\n " +
                        "Escolha uma opção de usuario:\n " +
                        " 1. Cliente\n " +
                        " 2. Funcionario\n " +
                        " 0. Sair\n";

        final String menuCliente =
                "Funcionalidades disponíveis:\n" +
                        "Escolha uma opção:\n " +
                        " 1. Ver Catálogo\n " +
                        " 2. Pesquisar Modelo\n " +
                        " 3. Simular Compra\n " +
                        " 4. Agendar negociação\n " +
                        " 0. Sair\n";

        final String menuFuncionario =
                "Funcionalidades disponíveis:\n " +
                        "Escolha uma opção:\n " +
                        " 1. Exibir veículos da loja\n " +
                        " 2. Adicionar veículo ao estoque\n " +
                        " 3. Efetuar Venda de veículo\n " +
                        " 4. Efetuar Troca de veículo\n " +
                        " 5. Exibir agendamentos realizados por clientes\n " +
                        " 6. Exibir relatório de vendas e faturamento total\n" +
                        " 0. Sair\n";

        final String menuTipoCompra =
                "Tipos de compra diponíveis:\n" +
                        " 1. Avista\n" +
                        " 2. Financiamento em até 48x\n";

        boolean encerrar = false;

        while (!encerrar) {
            System.out.println(menuLoja);
            int escolhaLoja = input.nextInt();
            input.nextLine();

            if (escolhaLoja == sair) {
                System.out.println("Sistema concessionária A&C encerrado!");
                encerrar = true;
            }

            if (escolhaLoja == cliente) {
                while (!encerrar) {
                    System.out.println(menuCliente);
                    int escolhaCliente = input.nextInt();
                    input.nextLine();

                    switch (escolhaCliente) {
                        case verCatalogo:
                            System.out.println("Lista de veículos disponíveis para venda: \n");
                            System.out.println(concessionaria.listarVeiculosDisponiveis());
                            break;

                        case pesquisarModelo:
                            System.out.println("Para pesquisar modelo informe as seguintes informações:\n");
                            System.out.println("Por favor, digite a marca e modelo do veiculo:\n");
                            String referenciaMarca = input.nextLine();
                            System.out.println("Agora, Digite a categoria do veiculo:\n");
                            String referenciaCategoria = input.nextLine();
                            System.out.println("Veiculos dísponoveis de acordo com as referências informadas:\n");
                            System.out.println(concessionaria.buscarCarro(referenciaMarca, referenciaCategoria));
                            break;

                        case simularCompra:
                            System.out.println("Para simular uma compra digite as seguintes informações: \n");
                            System.out.println("Por favor, digite a marca e modelo do veiculo:\n");
                            referenciaMarca = input.nextLine();
                            System.out.println("Agora, digite a categoria:\n");
                            referenciaCategoria = input.nextLine();
                            Veiculo veiculo = concessionaria.buscarCarro(referenciaMarca, referenciaCategoria);
                            System.out.println("Condições de compra do veículo informado:");
                            CalcularValorVenda precoAvista = new CalcularValorVenda();
                            System.out.println(" \n" + precoAvista.exibirValorVenda(veiculo,1));
                            CalcularValorVenda precoFinanciamento = new CalcularValorVenda();
                            System.out.println(" \n" + precoFinanciamento.exibirValorVenda(veiculo,2));
                            break;

                        case agendarNegociacao:
                            System.out.println("Para agendar uma negociação, precisaremos de algumas informações pessoais: ");
                            System.out.println("Digite seu nome: ");
                            String nome = input.nextLine();
                            System.out.println("Digite seu CPF: ");
                            String stringCpf = input.nextLine();
                            CPF cpf = new CPF(stringCpf);
                            System.out.println("Digite seu telefone: ");
                            String telefone = input.nextLine();
                            Cliente novoCliente = new Cliente(nome, cpf, telefone);
                            concessionaria.agendarNegociacao(novoCliente);
                            System.out.println("Pedido de negociação efetuado, entraremos em contato. Obrigado!");
                            break;

                        case sair:
                            System.out.println("Sistema concessionária A&C encerrado!");
                            encerrar = true;
                            break;

                    }
                }
            }

            if (escolhaLoja == funcionario) {

                System.out.println("Digite a senha de funcionario para ter acessar o sistema: ");
                String senha = input.next();

                if (Objects.equals(senha, "12345678")) {

                    while (!encerrar) {
                        System.out.println(menuFuncionario);
                        int escolhaFuncionario = input.nextInt();
                        input.nextLine();
                        switch (escolhaFuncionario) {
                            case exibirVeiculos:
                                System.out.println(concessionaria.listarVeiculosDisponiveis());
                                break;

                            case adicionarVeiculos:
                                System.out.println("Digite a marca e modelo do veículo: ");
                                String marca = input.nextLine();
                                System.out.println("Digite a categoria do veículo: ");
                                String categoria = input.nextLine();
                                System.out.println("Digite o ano do veículo: ");
                                String ano = input.nextLine();
                                System.out.println("Digite a valor do veículo: ");
                                double preco = input.nextDouble();
                                Carro carro = new Carro(marca, categoria, ano, preco);
                                concessionaria.adicionarCarro(carro);
                                System.out.println("Carro adicionado ao estoque!");
                                break;

                            case efetuarVenda:
                                System.out.println("Digite as informções do cliente: ");
                                System.out.println("Nome do cliente: ");
                                String nome = input.nextLine();
                                System.out.println("CPF do cliente: ");
                                String cpfCliente = input.nextLine();
                                System.out.println("Telefone do cliente: ");
                                String telefone = input.nextLine();
                                CPF cpf = new CPF(cpfCliente);
                                Cliente cliente1 = new Cliente(nome, cpf, telefone);
                                System.out.println("Agora digite as informações do veiculo: ");
                                System.out.println("Digite marca e modelo  do veiculo: ");
                                marca = input.nextLine();
                                System.out.println("Digite a categoria do veiculo: ");
                                categoria = input.nextLine();
                                Veiculo veiculoVenda = concessionaria.buscarCarro(marca, categoria);
                                System.out.println("Adicionar Acessorios?\n 1. Sim\n 2. Não\n");
                                int acessorio = input.nextInt();
                                input.nextLine();
                                if (acessorio == 1) {
                                    int adiciona = 0;
                                    while (adiciona != 2) {
                                        System.out.println("Digite o nome do acessorio a adicionar: ");
                                        String tipo = input.nextLine();
                                        System.out.println("Digite o valor: ");
                                        double valor = input.nextDouble();
                                        Acessorio acessorio1 = new Acessorio(tipo, valor);
                                        System.out.println("Adicionar mais?\n 1. Sim\n 2. Não");
                                        adiciona = input.nextInt();
                                        input.nextLine();
                                    }
                                }
                                System.out.println("Digite a forma de pagamento:\n 1. A Vista\n 2. Financiamento\n");
                                int escolhaPagamento = input.nextInt();
                                input.nextLine();
                                if (escolhaPagamento == 2) {
                                    System.out.println("Para fazer um financiamento é sujeito a analise de crédito: ");
                                    System.out.println("Digite a quantidade de parcelas até 48x");
                                    int parcelas = input.nextInt();
                                    input.nextLine();
                                    System.out.println("Digite o salario para calcular financiamento");
                                    double salario = input.nextDouble();
                                    if ((veiculoVenda.getPreco() / parcelas) > (salario * 0.30)) {
                                        System.out.println("Não foi possivel aprovar o financiamento");
                                        encerrar = true;
                                        break;
                                    }else {
                                        System.out.println("Financiamento Aprovado!");
                                    }
                                }
                                Venda venda = new Venda(cliente1, veiculoVenda, LocalDateTime.now());
                                System.out.println(venda.getDescricaoDaVenda(escolhaPagamento));
                                concessionaria.realizarVenda(venda);
                                break;

                            case efetuarTroca:
                                System.out.println("Para realizar troca digite algumas informções: ");
                                System.out.println("Nome do cliente: ");
                                nome = input.nextLine();
                                System.out.println("CPF do cliente: ");
                                cpfCliente = input.nextLine();
                                System.out.println("Telefone do cliente: ");
                                telefone = input.nextLine();
                                cpf = new CPF(cpfCliente);
                                cliente1 = new Cliente(nome, cpf, telefone);
                                System.out.println("Digite o carro do cliente para troca:\n");
                                System.out.println("Digite a marca do veículo: ");
                                String marcaTroca = input.nextLine();
                                System.out.println("Digite a categoria e modelo do veículo: ");
                                String categoriaTroca = input.nextLine();
                                System.out.println("Digite o ano do veículo: ");
                                String anoTroca = input.nextLine();
                                System.out.println("Digite a valor do veículo: ");
                                double precoTroca = input.nextDouble();
                                input.nextLine();
                                Carro carroTroca = new Carro(marcaTroca, categoriaTroca, anoTroca, precoTroca);
                                System.out.println("Digite o carro da loja para troca: ");
                                System.out.println("Digite marca e modelo do veiculo: ");
                                marca = input.nextLine();
                                System.out.println("Digite a categoria do veiculo: ");
                                categoria = input.nextLine();
                                veiculoVenda = concessionaria.buscarCarro(marca, categoria);
                                TrocaVeiculo troca = new TrocaVeiculo();
                                System.out.println("Qual tipo de pagamento:\n 1. A Vista\n 2. Financiamento");
                                int tipoVenda = input.nextInt();
                                input.nextLine();
                                if (tipoVenda == 2) {
                                    System.out.println("Para fazer um financiamento é sujeito a analise de crédito: ");
                                    System.out.println("Digite a quantidade de parcelas até 48x");
                                    int parcelas = input.nextInt();
                                    input.nextLine();
                                    System.out.println("Digite o salario para calcular financiamento");
                                    double salario = input.nextDouble();
                                    if ((troca.valorVenda(veiculoVenda, carroTroca, tipoVenda) / parcelas) > (salario * 0.30)) {
                                        System.out.println("Não foi possivel aprovar o financiamento");
                                        encerrar = true;
                                        break;
                                    }else {
                                        System.out.println("Financiamento Aprovado!");
                                    }
                                }
                                veiculoVenda.calculaPreco(tipoVenda);
                                veiculoVenda.setPreco(troca.valorVenda(veiculoVenda, carroTroca, tipoVenda));
                                venda = new Venda(cliente1, veiculoVenda, LocalDateTime.now());
                                concessionaria.realizarVenda(venda);
                                concessionaria.adicionarCarro(carroTroca);
                                System.out.println("Troca realizada!");
                                System.out.println(venda.getDescricaoDaVenda(tipoVenda));

                                break;

                            case exibirAgendamentos:
                                System.out.println(concessionaria.listarAgendamentos());
                                break;

                            case exibirRelatorios:
                                System.out.println(concessionaria.listarVendas());
                                System.out.println(concessionaria.gerarRelatorio());
                                break;

                            case sair:
                                System.out.println("Sistema concessionária A&C encerrado!");
                                encerrar = true;
                                break;
                        }
                    }
                }
                else{
                    System.out.println("Senha Incorreta!\n Sistema concessionária A&C encerrado!\n");
                    encerrar = true;
                    break;
                }
            }

            if (escolhaLoja != cliente && escolhaLoja!= sair && escolhaLoja != funcionario) {
                System.out.println("Opção escolhida inválida!");
            }

        }

        concessionaria.salvaDados("dados_concessionaria.ser");
    }
}
