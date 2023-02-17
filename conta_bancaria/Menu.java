package conta_bancaria;

import java.util.Scanner;

import conta_bancaria.model.Conta;
import conta_bancaria.util.Cores;

public class Menu {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);
		
		//cria o objeto conta c1
		Conta c1 = new Conta(1, 123, 1, "Katiana Xavier", 30000.0f);
		
		//mostra as infos da conta
		c1.visualizar();
		
		//altera o valor da conta
		c1.setSaldo(35000.0f);
		
		//visualiza apenas o saldo da conta c1
		System.out.println(c1.getSaldo());
		
		//cria o objeto conta c2
		Conta c2 = new Conta(2, 456, 2, "Lunna Xavier", 30000.0f);
		
		//mostra as infos da conta
		c2.visualizar();
		
		//efetua um saque na conta c2 e visualizamos o novo saldo
		if (c2.sacar(10000.0f)) {
			System.out.println("\n\n" + c2.getSaldo());
		}

		//depósito na conta c1
		c1.depositar(10000.0f);
		//visualiza os dados da conta c1 após o depósito
		c1.visualizar();
		
		int opcao;
		
		while (true) {
			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND + "*****************************************************");
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
				break;
			case 2:
				System.out.println("Listar todas as contas \n\n");
				break;
			case 3:
				System.out.println("Consultar dados da conta por número \n\n");
				break;
			case 4:
				System.out.println("Atualizar dados da conta \n\n");
				break;
			case 5:
				System.out.println("Apagar a conta \n\n");
				break;
			case 6:
				System.out.println("Saque \n\n");
				break;
			case 7:
				System.out.println("Depósito \n\n");
				break;
			case 8:
				System.out.println("Transferência entre contas \n\n");
				break;
			default:
				System.out.println("\nOpção inválida\n");
				break;
			}


	}

	}
}

