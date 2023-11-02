package controller;

import model.ListaEncadeadaSimples_TipoGenerico;
import model_departamentos.Departamento;

public class ControleLoja {

	public ControleLoja() {
		
		@SuppressWarnings("unchecked")
		ListaEncadeadaSimples_TipoGenerico<Departamento>[] loja = new ListaEncadeadaSimples_TipoGenerico[4];//Cria vetor de andares
		for(int i = 0; i < loja.length ; i++) {//instância cada andar
			loja[i] = new ListaEncadeadaSimples_TipoGenerico<Departamento>(); 
		}
	}
	
	// Inserir //
	public void InserirDepartamento(ListaEncadeadaSimples_TipoGenerico<Departamento>[] predio, String andar, Departamento novoDepartamento) throws Exception {
		int pos = hash(andar);
		predio[pos].addLast(novoDepartamento);
	}
	
	// Consultar Departamento //
	public void ConsultarDepartamento(ListaEncadeadaSimples_TipoGenerico<Departamento>[] predio, String andar,String nomeDepartamento ) throws Exception{
		int pos = hash(andar);
		boolean encontrado = false;
		for(int i = 0; i < predio[pos].size();i++) {
			if(nomeDepartamento.equals(predio[pos].getValue(i).NomeDepartamento)) {
				System.out.println(predio[pos].getValue(i));
				encontrado = true;
			}
		}
		if(encontrado != true) {
			System.out.println("Departamento não encontrado neste Andar");
		}
	}
	
	// Consultar Andar //
	public void ConsultarTodosDepartamentosDoAndar(ListaEncadeadaSimples_TipoGenerico<Departamento>[] predio, String andar) throws Exception{
		int pos = hash(andar);
		for(int i = 0; i < predio[pos].size();i++) {
			System.out.println(predio[pos].getValue(i));
		}
	}
	
	// Consulta Predio
	public void ConsultarPredio(ListaEncadeadaSimples_TipoGenerico<Departamento>[] predio) throws Exception{
		for(int i = 0; i < predio.length; i++) {
			if(i == 0) {
				System.out.println("TÉRREO:");
			}else {
				System.out.println(i+"° ANDAR:");
			}
			for(int ctd = 0; ctd < predio[i].size(); ctd++) {
				System.out.println(predio[i].getValue(ctd));
			}
		}System.out.println("");
	}
	
	// Remover //
	public void RemoveDepartamento(ListaEncadeadaSimples_TipoGenerico<Departamento>[] predio, String andar,String nomeDepartamento ) throws Exception{
		int pos = hash(andar);
		boolean encontrado = false;
		for(int i = 0; i < predio[pos].size();i++) {
			if(nomeDepartamento.equals(predio[pos].getValue(i).NomeDepartamento)) {
				System.out.println(predio[pos].getValue(i).NomeDepartamento);
				if(i == 0) {
					predio[pos].removeFirst();
					encontrado = true;
					System.out.println("Departamento Removido");
					
				}else {
					predio[pos].remove(i);
					encontrado = true;
					System.out.println("Departamento Removido");
					break;
				}
			}
		}
		if(encontrado != true) {
			System.out.println("Departamento não encontrado neste Andar");
		}
	}
	
	//função hash
	private int hash(String andar) throws Exception {
		andar = andar.toLowerCase();
		if(andar.equals("t")||andar.equals("0")) {
			return 0;
		}else if(andar.equals("1")) {
			return 1;
		}else if(andar.equals("2")) {
			return 2;
		}else if(andar.equals("3")) {
			return 3;
		}else {
			throw new Exception("Andar Inexistente");
		}
		
	}
	
	
}
