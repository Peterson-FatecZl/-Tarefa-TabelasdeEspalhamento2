package view;

import javax.swing.JOptionPane;

import controller.ControleLoja;
import model.ListaEncadeadaSimples_TipoGenerico;
import model_departamentos.Departamento;

public class Principal {

	public static void main(String[] args) {
		@SuppressWarnings("unchecked")
		ListaEncadeadaSimples_TipoGenerico<Departamento>[] predio = new ListaEncadeadaSimples_TipoGenerico[4];
		ControleLoja controleDepartamentos = new ControleLoja();
		
		try {
			predio = iniciaPredio(predio);
			
			int opc = Integer.parseInt(JOptionPane.showInputDialog(null,
					"INSIRA O NUMERO DA OPÇÃO DESEJADA\n"+
					"1 - Inserir Novo Departamento\n"+
					"2 - Consultar Departamento\n"+
					"3 - Listar Todos Os Departamentos Do Andar\n"+
					"4 - Listar Todos Os Departamentos do Prédio\n"+
					"5 - Remover Departamento\n"+
					"9 - Sair",
					"Sistema de Controle Do Prédio",
					JOptionPane.PLAIN_MESSAGE));
			
			while(opc != 9) {
				switch (opc) {
					case 1:
						
						String nomeNovoDepartamento = JOptionPane.showInputDialog("Insira o Nome do Novo Departamento");
						String descricaoNovoDepartamento = JOptionPane.showInputDialog("Insira a Descrição do Novo Departamento");
						Departamento newDepartament = new Departamento(nomeNovoDepartamento, descricaoNovoDepartamento);
						
						String andar = JOptionPane.showInputDialog("Insira o número do Andar Desejado");
						
						controleDepartamentos.InserirDepartamento(predio, andar, newDepartament);
						break;
					
					case 2:
						
						andar = JOptionPane.showInputDialog("Insira o número do Andar Desejado");
						String nomeDepartamento = JOptionPane.showInputDialog("Insira o Nome do Departamento Buscado");
						
						controleDepartamentos.ConsultarDepartamento(predio, andar, nomeDepartamento);
						break;
				
					case 3:
						andar = JOptionPane.showInputDialog("Insira o número do Andar Desejado");
						controleDepartamentos.ConsultarTodosDepartamentosDoAndar(predio, andar);
						break;
						
					case 4:
						controleDepartamentos.ConsultarPredio(predio);
						break;
						
					case 5:
						
						nomeDepartamento = JOptionPane.showInputDialog("Insira o Nome do Departamento que Deseja remover");
						andar = JOptionPane.showInputDialog("Insira o número do Andar Deste Departamento");
						controleDepartamentos.RemoveDepartamento(predio, andar, nomeDepartamento);
						break;
						
					case 9:
						//faz nada
						break;
				
					default:
						throw new IllegalArgumentException("Opção Invalida");
				}						
				opc = Integer.parseInt(JOptionPane.showInputDialog(null,"INSIRA O NUMERO DA OPÇÃO DESEJADA\n"+"1 - Inserir Novo Departamento\n"+"2 - Consultar Departamento\n"+"3 - Listar Todos Os Departamentos Do Andar\n"+"4 - Listar Todos Os Departamentos do Prédio\n"+"5 - Remover Departamento\n"+"9 - Sair","Sistema de Controle Do Prédio",JOptionPane.PLAIN_MESSAGE));
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	
	
	
	/*↓↓↓↓↓ Funções Que Criam O Escopo Inicial Do Exercício ↓↓↓↓↓*/
	public static ListaEncadeadaSimples_TipoGenerico<Departamento>[] iniciaPredio(ListaEncadeadaSimples_TipoGenerico<Departamento>[] predio) throws Exception {
		
		for(int i = 0; i < predio.length; i++) {
			predio[i] = new ListaEncadeadaSimples_TipoGenerico<Departamento>();
		}
		Departamento[] vetorComDepartamentos = iniciaDepartamentos();
		for(int i = 0; i < vetorComDepartamentos.length; i++) {
			if(i < 8) {
				predio[0].addLast(vetorComDepartamentos[i]);
			}else if(i < 14) {
				predio[1].addLast(vetorComDepartamentos[i]);
			}else if(i < 18) {
				predio[2].addLast(vetorComDepartamentos[i]);
			}else {
				predio[3].addLast(vetorComDepartamentos[i]);
			}
		}
		return predio;
	}
	
	public static Departamento[] iniciaDepartamentos() {
	/*Departamentos Iniciais*/
		String[] departamentos = { "celulares e smartphones",
			"tv e vídeo",
			"consoles e games",
			"áudio",
			"telefonia fixa",
			"informática",
			"acessórios e periféricos",
			"pc gamer",
			
			"eletrodomésticos",
			"eletroportáteis",
			"ar e ventilação",
			"móveis e decoração",
			"casa e construção",
			"cama, mesa e banho",
			
			"livros",
			"instrumentos musicais",
			"música",
			"filmes e séries",
			
			"mercado",
			"automotivo",
			"brinquedos",
			"bebês",
			"gift cards",
			"pet shop",
			"papelaria" };

	/*Descrições dos Departamentos inicias*/
		String[] descricoes = {"Artigos para telefonia móvel"
			,"Artigos para televisores"
			,"Artigos para video games"
			,"Artigos de som"
			,"Artigos para telefonia"
			,"Computadores e laptops corporativos"
			,"Hardwares"
			,"Computadores e laptops gamers"

			,"Artigos Eletrodomésticos"
			,"Artigos Eletroportáteis"
			,"Ventiladores e Ar condicionado"
			,"Móveis"
			,"Materiais para construção"
			,"Artigos para cama, mesa e banho"

			,"Livraria"
			,"Instrumentos músicas e acessórios"
			,"Discos"
			,"DVD e Blu-ray"

			,"Itens de supermercado"
			,"Peças e acessórios para automóveis"
			,"Itens infantis"
			,"Itens para a primeira infância"
			,"Cartões presente"
			,"Comida e acessórios para pet"
			,"Itens de papelaria"};
	
		Departamento[] vetorComDepartamentos = new Departamento[25];
		for(int i=0; i < vetorComDepartamentos.length; i++) {
			vetorComDepartamentos[i] = new Departamento(departamentos[i],descricoes[i]);
		}
		return vetorComDepartamentos;
	}

}
