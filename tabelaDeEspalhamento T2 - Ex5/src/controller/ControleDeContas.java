package controller;

import model.ListaEncadeadaSimples_TipoGenerico;
import model_cliente.Cliente;

public class ControleDeContas {
	
	
	public ControleDeContas() {
		super();
	}
	
	public void adicionaConta(ListaEncadeadaSimples_TipoGenerico<Cliente>[] clientes, ListaEncadeadaSimples_TipoGenerico<Cliente>[] clientesPremium, Cliente conta) throws Exception {
	
		int pos = hash(conta.NumeroConta);
		if(pos < 6) {
			clientes[pos].addLast(conta);
		}else {
			pos = pos % 5;
			clientesPremium[pos].addLast(conta);
		}
	}

	public void consultaConta(ListaEncadeadaSimples_TipoGenerico<Cliente>[] clientes, ListaEncadeadaSimples_TipoGenerico<Cliente>[] clientesPremium, int numeroConta) throws Exception {
		int pos = hash(numeroConta);
		boolean encontrado = false;
		if(pos < 6) {
			for(int i = 0; i < clientes[pos].size(); i++) {
				if(clientes[pos].getValue(i).NumeroConta == numeroConta) {
					System.out.println(clientes[pos].getValue(i));
					encontrado = true;
				}
			}
			if(encontrado != true) {
				System.out.println("Conta Não encontrada");
			}
			
		}else {
			pos = pos % 5;
			for(int i = 0; i < clientesPremium[pos].size(); i++) {
				if(clientesPremium[pos].getValue(i).NumeroConta == numeroConta) {
					System.out.println(clientesPremium[pos].getValue(i));
					encontrado = true;
				}
			}
			if(encontrado != true) {
				System.out.println("Conta Não encontrada");
			}
		}
		
	}
	
	public void removeConta(ListaEncadeadaSimples_TipoGenerico<Cliente>[] clientes, ListaEncadeadaSimples_TipoGenerico<Cliente>[] clientesPremium, int numeroConta) throws Exception {
		int pos = hash(numeroConta);
		boolean encontrado = false;
		if(pos < 6) {
			for(int i = 0; i < clientes[pos].size(); i++) {
				if(clientes[pos].getValue(i).NumeroConta == numeroConta) {
					clientes[pos].remove(i);
					System.out.println("Conta Removida");
					encontrado = true;
				}
			}
			if(encontrado != true) {
				System.out.println("Conta Não encontrada");
			}
			
		}else {
			pos = pos % 5;
			for(int i = 0; i < clientesPremium[pos].size(); i++) {
				if(clientesPremium[pos].getValue(i).NumeroConta == numeroConta) {
					clientesPremium[pos].remove(i);
					System.out.println("Conta Removida");
					encontrado = true;
				}
			}
			if(encontrado != true) {
				System.out.println("Conta Não encontrada");
			}
		}
	}
	
	private int hash(int valor) {
		int pos = (int)((Math.sqrt(Math.pow(valor, 2)))%10);
		return pos;
	}
	
	
	
	
}
