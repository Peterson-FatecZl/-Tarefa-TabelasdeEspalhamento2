package view;

import java.util.Random;

import model.ListaEncadeadaSimples_TipoGenerico;

public class Principal {

	public static void main(String[] args) {

		@SuppressWarnings("unchecked")
		ListaEncadeadaSimples_TipoGenerico<Integer>[] listaEncadeada = new ListaEncadeadaSimples_TipoGenerico[2];
		Random random = new Random();
		int[] v = new int[100];
		String[] impOUpar = {"Par", "Impar"};

		try {
			for (int i = 0; i < v.length; i++) {// preenche Vetor
				int value = (random.nextInt(1000) + 1);
				v[i] = value;
			}
			for (int i = 0; i < 2; i++) {
				listaEncadeada[i] = new ListaEncadeadaSimples_TipoGenerico<Integer>();
			}

			for (int i = 0; i < v.length; i++) {
				int pos = hash(v[i]);
				listaEncadeada[pos].addLast(v[i]);;
			}

			System.out.println("HashTable:");
			for (int i = 0; i < listaEncadeada.length; i++) {
				System.out.print(impOUpar[i] + ": ");
				for (int ctd = 0; ctd < listaEncadeada[i].size(); ctd++) {
					System.out.print(listaEncadeada[i].getValue(ctd) + " ");
				}
				System.out.println();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// TODO: a) função hash
	private static int hash(int value) {
		if (value % 2 == 0) {
			return 0;
		} else {
			return 1;
		}

	}

}
