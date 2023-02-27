package conta_bancaria;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);

		ContaController contas = new ContaController();

		System.out.println("\nCriar Contas\n");

		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000f, 100.0f);
		contas.cadastrar(cc1);

		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Maria da Silva", 2000f, 100.0f);
		contas.cadastrar(cc2);

		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Mariana dos Santos", 4000f, 12);
		contas.cadastrar(cp1);

		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Juliana Ramos", 8000f, 15);
		contas.cadastrar(cp2);

		contas.listarTodas();

		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		float saldo, limite, valor;
		String titular;

		while (true) {
			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
					+ "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("              BANCO DO BRAZIL COM Z                  ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("          1 - Criar conta                            ");
			System.out.println("          2 - Listar todas as contas                 ");
			System.out.println("          3 - Buscar conta por número                ");
			System.out.println("          4 - Atualizar dados da conta               ");
			System.out.println("          5 - Apagar conta                           ");
			System.out.println("          6 - Sacar                                  ");
			System.out.println("          7 - Depositar                              ");
			System.out.println("          8 - Transferir valores entre contas        ");
			System.out.println("          9 - Sair                                   ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     " + Cores.TEXT_RESET);

			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Digite valores inteiros!");
				leia.nextLine();
				opcao = 0;
			}

			if (opcao == 9) {
				System.out.println("Programa finalizado.");
				System.out.println("\nBanco do Brazil com Z - O seu futuro começa aqui!");
				leia.close();
				System.exit(9);
			}

			switch (opcao) {
			case 1:
				System.out.println("Criar conta \n\n");

				System.out.println("Número da agência: ");
				agencia = leia.nextInt();

				System.out.println("Nome do titular: ");
				leia.skip("\\R?");
				titular = leia.nextLine();

				do {
					System.out.println("Tipo da conta (1 - CC | 2 - CP): ");
					tipo = leia.nextInt();
				} while (tipo < 1 && tipo > 2);

				System.out.println("Saldo da conta: ");
				saldo = leia.nextFloat();

				switch (tipo) {
				case 1 -> {
					System.out.println("Limite da conta corrente: ");
					limite = leia.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));

				}
				case 2 -> {
					System.out.println("Aniversário da conta poupança: ");
					aniversario = leia.nextInt();
					contas.cadastrar(
							new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));

				}

				}

				keyPress();
				break;
			case 2:
				System.out.println("Listar todas as contas \n\n");

				contas.listarTodas();

				keyPress();
				break;
			case 3:
				System.out.println("Consultar dados da conta por número\n\n");

				System.out.println("Número da conta: ");
				numero = leia.nextInt();

				contas.procurarPorNumero(numero);

				keyPress();
				break;
			case 4:
				System.out.println("Atualizar dados da conta \n\n");

				System.out.println("Número da conta: ");
				numero = leia.nextInt();

				if (contas.buscarNaCollection(numero) != null) {

					System.out.println("Número da agência: ");
					agencia = leia.nextInt();

					System.out.println("Nome do titular: ");
					leia.skip("\\R?");
					titular = leia.nextLine();

					tipo = contas.retornaTipo(numero);

					System.out.println("Saldo da conta: ");
					saldo = leia.nextFloat();

					switch (tipo) {
					case 1 -> {
						System.out.println("Limite da conta corrente: ");
						limite = leia.nextFloat();
						contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
					}
					case 2 -> {
						System.out.println("Aniversário da conta poupança: ");
						aniversario = leia.nextInt();
						ContaPoupanca cp = (new ContaPoupanca(0, agencia, tipo, titular, saldo, aniversario));
					}
					}
				} else {
					System.out.println("A conta não foi encontrada!");

					keyPress();
					break;
				}
			case 5:
				System.out.println("Apagar a conta \n\n");

				System.out.println("Número da conta: ");
				numero = leia.nextInt();

				contas.deletar(numero);

				keyPress();
				break;
			case 6:
				System.out.println("Saque \n\n");

				System.out.println("Número da conta: ");
				numero = leia.nextInt();

				System.out.println("Valor do saque: ");
				valor = leia.nextFloat();
				
				contas.sacar(numero, valor);

				keyPress();
				break;
			case 7:
				System.out.println("Depósito \n\n");

				System.out.println("Número da conta: ");
				numero = leia.nextInt();

				System.out.println("Valor do depósito: ");
				valor = leia.nextFloat();

				contas.depositar(numero, valor);

				keyPress();
				break;
			case 8:
				System.out.println("Transferência entre contas \n\n");

				System.out.println("Número da conta origem: ");
				numero = leia.nextInt();

				System.out.println("Número da conta destino: ");
				numeroDestino = leia.nextInt();

				System.out.println("Valor da transferência: ");
				valor = leia.nextFloat();

				contas.transferir(numero, numeroDestino, valor);

				keyPress();
				break;
			default:
				System.out.println("\nOpção inválida\n");

				keyPress();
				break;
			}

		}

	}

	public static void keyPress() {

		try {

			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para continuar");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de enter!");

		}
	}

}
