package exercicio2;

import exercicio2.Pais;
import java.util.ArrayList;

public class Teste {
	public static void main(String[] args) {
		Pais pais = new Pais(9, "teste", 600851475143L, 444.4);
	//	pais.criar();
	//	pais.atualizar();
	//	pais.excluir();
		System.out.println(pais.menorArea());
		
		ArrayList<Pais> testeP = new ArrayList<Pais>();
				
		testeP = pais.vetPaises();
				
		for(int i = 0; i < testeP.size(); i++) {
			System.out.println("Pa�s: " + testeP.get(i).getNome()+ "\n" + 
							   "  - Popula��o: " + testeP.get(i).getPopulacao()+ "\n" + 
							   "  - �rea: " + testeP.get(i).getArea()+ "\n" );
		}
		

	}
}
