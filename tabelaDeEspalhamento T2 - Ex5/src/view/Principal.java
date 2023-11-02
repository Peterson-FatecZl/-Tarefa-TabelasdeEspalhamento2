package view;

import javax.swing.JOptionPane;

import controller.ControleDeContas;
import model.ListaEncadeadaSimples_TipoGenerico;
import model_cliente.Cliente;

public class Principal {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		ListaEncadeadaSimples_TipoGenerico<Cliente>[] Clientes = new ListaEncadeadaSimples_TipoGenerico[5];
		ListaEncadeadaSimples_TipoGenerico<Cliente>[] ClientesPremium = new ListaEncadeadaSimples_TipoGenerico[5];
		ControleDeContas controllerContas = new ControleDeContas();

		for(int i = 0; i < Clientes.length; i++) {
			Clientes[i] = new ListaEncadeadaSimples_TipoGenerico<Cliente>();
			ClientesPremium[i] = new ListaEncadeadaSimples_TipoGenerico<Cliente>();
		}
		
		try {
			int opc = Integer.parseInt(JOptionPane.showInputDialog(null,
					"INSIRA O NUMERO DA OPÇÃO DESEJADA\n"+
					"1 - Inserir Conta\n"+
					"2 - Consultar Conta\n"+
					"3 - Remover Conta\n"+
					"9 - Sair",
					"Sistema Bancário",
					JOptionPane.PLAIN_MESSAGE));
			
			while(opc != 9) {
				switch (opc) {
					case 1:
						int number = Integer.parseInt(JOptionPane.showInputDialog("Insira o Número da Conta"));
						if(number > 9999) {//valida número
							System.err.println("Número Inválido");
							System.exit(0);
						}
						String name = JOptionPane.showInputDialog("Insira o Nome do Cliente");
						double saldo = Double.parseDouble(JOptionPane.showInputDialog("Insira o Saldo da Conta"));
						
						Cliente conta = new Cliente(number,name,saldo);
						controllerContas.adicionaConta(Clientes, ClientesPremium, conta);
						break;
					
					case 2:
						number = Integer.parseInt(JOptionPane.showInputDialog("Insira o Número da Conta"));
						controllerContas.consultaConta(Clientes, ClientesPremium, number);
						break;
				
					case 3:
						number = Integer.parseInt(JOptionPane.showInputDialog("Insira o Número da Conta"));
						controllerContas.removeConta(Clientes, ClientesPremium, number);
						break;
						
					case 9:
						//pass
						break;
					default:
						System.err.println("Opção Inválida");
				}
				opc = Integer.parseInt(JOptionPane.showInputDialog(null,"INSIRA O NUMERO DA OPÇÃO DESEJADA\n"+"1 - Inserir Conta\n"+"2 - Consultar Conta\n"+"3 - Remover Conta\n"+"9 - Sair","Sistema Bancário",JOptionPane.PLAIN_MESSAGE));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	
	}
	
	
}

