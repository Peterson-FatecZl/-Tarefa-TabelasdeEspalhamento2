package view;

import model.ListaEncadeadaSimples_TipoGenerico;

public class Principal {
	public static void main(String[] args) {

		int[] v = { 12, 647, 158, 136, 467, 156, 600, 551, 263, 414, 882, 945, 914, 953, 629, 884,
					795, 194, 513,591, 847, 66, 337, 979, 768, 53, 114, 803, 90, 339, 550, 574,
					977, 216, 99, 617, 88, 142, 148, 227, 939, 585, 338, 206, 569, 708, 844 };

		@SuppressWarnings("unchecked")
		ListaEncadeadaSimples_TipoGenerico<Integer>[] hashTable = new ListaEncadeadaSimples_TipoGenerico[5];
		for (int i = 0; i < hashTable.length; i++) { hashTable[i] = new ListaEncadeadaSimples_TipoGenerico<Integer>(); }

		try {
			for (int i = 0; i < v.length; i++) {
				int posicao = hash(v[i]);
				hashTable[posicao].addLast(v[i]);
			}
		
			System.out.println("New Hash Table");
			for(int i = 0; i < hashTable.length; i++) {
				System.out.print(i+ " - ");
				for(int ctd = 0; ctd < hashTable[i].size(); ctd++) {
					System.out.print(hashTable[i].getValue(ctd)+" ");
				}System.out.println();
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Função Hash
	private static int hash(int value) {
		int func = (int) (((Math.sqrt(7) + 1) * value) % 5);
		return func;
	}
	

}
