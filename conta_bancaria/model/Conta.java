package conta_bancaria.model;

public class Conta {
	// aqui não tem método main!
	// model porque aqui define-se o pacote do modelo model. características
	// (ATRIBUTOS) que toda conta terá: CC, CP etc

	// atributos ficam privados, porque depois serão criados métodos para acessar
	// esses atributos. source > gereate constructor using fields
	private int numero;
	private int agencia;
	private int tipo;
	private String titular;
	private float saldo;

	// método construtor: responsável por construir, criar o objeto. dá vida aos
	// objetos. é especial porque sempre tem o mesmo nome da classe e como
	// parâmetros tem os mesmos parâmetros dos atributos.
	public Conta(int numero, int agencia, int tipo, String titular, float saldo) {
		// this: identifica o que é atributo e o que é parâmetro. this = esse é um
		// atributo da classe
		this.numero = numero;
		this.agencia = agencia;
		this.tipo = tipo;
		this.titular = titular;
		this.saldo = saldo;
	}

	// métodos de acesso e modificação (get e set)
	// para cada método, gerar um método set e um get. set: altera o conteúdo/valor
	// do objeto | get: pega o número e o devolve (consulta). método set não retorna
	// nada, só altera, por isso é void. source > generate getters e setters

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public boolean sacar(float valor) {

		if (this.getSaldo() < valor) {
			System.out.println("\nSaldo insuficiente!");
			// indica que o saque não foi feito
			return false;
		}

		this.setSaldo(this.getSaldo() - valor);
		return true;

	}

	// saldo + valor do depósito
	public void depositar(float valor) {
		this.setSaldo(this.getSaldo() + valor);
	}

	// visualizar todas as infos do objeto conta
	public void visualizar() {

		String tipo = "";

		// isso dá p usar no projeto!!
		switch (this.tipo) {
		case 1 -> tipo = "Conta Corrente";
		case 2 -> tipo = "Conta Poupança";
		}

		System.out.println("******************");
		System.out.println("  DADOS DA CONTA  ");
		System.out.println("******************");
		System.out.println("Número da conta: " + this.numero);
		System.out.println("Número da agência: " + this.agencia);
		// se for tipo 1, mostra CC, se for 2, mostra CP, por isso só a variável tipo,
		// sem o this
		System.out.println("Tipo da conta: " + tipo);
		System.out.println("Nome do titular: " + this.titular);
		System.out.println("Saldo da conta: " + this.saldo);

	}

}
