package conta_bancaria;

import java.io.IOException;
import java.util.Scanner;

import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);

		// cria o objeto conta c1
		Conta c1 = new Conta(1, 123, 1, "Katiana Xavier", 30000.0f);

		// mostra as infos da conta
		c1.visualizar();

		// altera o valor da conta
		c1.setSaldo(35000.0f);

		// visualiza apenas o saldo da conta c1
		System.out.println(c1.getSaldo());

		// cria o objeto conta c2
		Conta c2 = new Conta(2, 456, 2, "Lunna Xavier", 30000.0f);

		// mostra as infos da conta
		c2.visualizar();

		// efetua um saque na conta c2 e visualizamos o novo saldo
		if (c2.sacar(10000.0f)) {
			System.out.println("\n\n" + c2.getSaldo());
		}

		// depósito na conta c1
		c1.depositar(10000.0f);
		// visualiza os dados da conta c1 após o depósito
		c1.visualizar();

		ContaCorrente c3 = new ContaCorrente(3, 123, 1, "Rafael Xavier", 30000.0f, 1000.0f);

		c3.visualizar();

		c3.sacar(32000);

		c3.visualizar();

		ContaPoupanca c4 = new ContaPoupanca(4, 123, 2, "Francisca Xavier", 20000.0f, 5);

		c4.visualizar();

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

			opcao = leia.nextInt();

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
					ContaCorrente cc = new ContaCorrente(0, agencia, tipo, titular, saldo, limite);
					cc.visualizar();
				}
				case 2 -> {
					System.out.println("Aniversário da conta poupança: ");
					aniversario = leia.nextInt();
					ContaPoupanca cp = new ContaPoupanca(0, agencia, tipo, titular, saldo, aniversario);
					cp.visualizar();
				}

				}

				keyPress();
				break;
			case 2:
				System.out.println("Listar todas as contas \n\n");

				keyPress();
				break;
			case 3:
				System.out.println("Consultar dados da conta por número \n\n");

				System.out.println("Número da conta: ");
				numero = leia.nextInt();

				keyPress();
				break;
			case 4:
				System.out.println("Atualizar dados da conta \n\n");

				System.out.println("Número da conta: ");
				numero = leia.nextInt();

				// TODO condicional pra ver se a conta existe

				System.out.println("Número da agência: ");
				agencia = leia.nextInt();

				System.out.println("Nome do titular: ");
				leia.skip("\\R?");
				titular = leia.nextLine();

				// TODO busca do tipo
				tipo = 0;

				System.out.println("Saldo da conta: ");
				saldo = leia.nextFloat();

				switch (tipo) {
				case 1 -> {
					System.out.println("Limite da conta corrente: ");
					limite = leia.nextFloat();
					ContaCorrente cc = new ContaCorrente(0, agencia, tipo, titular, saldo, limite);
					cc.visualizar();
				}
				case 2 -> {
					System.out.println("Aniversário da conta poupança: ");
					aniversario = leia.nextInt();
					ContaPoupanca cp = new ContaPoupanca(0, agencia, tipo, titular, saldo, aniversario);
					cp.visualizar();
				}

				}

				keyPress();
				break;
			case 5:
				System.out.println("Apagar a conta \n\n");

				System.out.println("Número da conta: ");
				numero = leia.nextInt();

				// TODO chamada para o método deletar

				keyPress();
				break;
			case 6:
				System.out.println("Saque \n\n");

				System.out.println("Número da conta: ");
				numero = leia.nextInt();

				System.out.println("Valor do saque: ");
				valor = leia.nextFloat();

				// TODO chamada para o método sacar

				keyPress();
				break;
			case 7:
				System.out.println("Depósito \n\n");

				System.out.println("Número da conta: ");
				numero = leia.nextInt();

				System.out.println("Valor do depósito: ");
				valor = leia.nextFloat();

				// TODO chamada para o método depositar

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

				// TODO chamada para o método transferir

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

			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar.");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de enter!");

		}
	}

}
