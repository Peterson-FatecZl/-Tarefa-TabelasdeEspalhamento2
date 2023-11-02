package model_cliente;

public class Cliente {
	
	public int NumeroConta;
	public String NomeCliente;
	public double Saldo;
	
	public Cliente() {
		super();
	}
	
	public Cliente(int numeroConta, String nomeCliente, double saldo) {
		this.NumeroConta = numeroConta;
		this.NomeCliente = nomeCliente;
		this.Saldo = saldo;
		
	}
	
	public String toString() {
		return "Conta: " + NumeroConta + " Cliente: " + NomeCliente + " Saldo: " + Saldo;
	}

}
