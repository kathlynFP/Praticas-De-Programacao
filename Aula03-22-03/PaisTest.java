package exercicio2;

import static org.junit.Assert.assertEquals;

import exercicio2.Pais;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PaisTest {
	Pais pais, copia;
	static int id = 0;
	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		pais = new Pais(id, "Japão", 1270000000, 3779620);
		copia = new Pais(id, "Japão", 1270000000, 3779620);
		System.out.println(pais);
		System.out.println(copia);
		System.out.println(id);
	}
	@Test
	public void test00Carregar() {
		System.out.println("carregar");
		Pais fixture = new Pais(1, "Brasil", 205002000, 8512000 );
		Pais novo = new Pais(1, null, 0, 0);
		novo.carregar();
		assertEquals("testa inclusao", novo, fixture);
	}
	@Test
	public void test01Criar() {
		System.out.println("criar");
		pais.criar();
		id = pais.getId();
		System.out.println(id);
		copia.setId(id);
		assertEquals("testa criacao", pais, copia);
	}
	@Test
	public void test02Atualizar() {
		System.out.println("atualizar");
		pais.setPopulacao(999999);
		copia.setPopulacao(999999);		
		pais.atualizar();
		pais.carregar();
		assertEquals("testa atualizacao", pais, copia);
	}
	@Test
	public void test03Excluir() {
		System.out.println("excluir");
		copia.setId(-1);
		copia.setNome(null);
		copia.setPopulacao(0);
		copia.setArea(0);
		pais.excluir();
		pais.carregar();
		assertEquals("testa exclusao", pais, copia);
	}
	
	@Test
	public void test04MaiorPopulacao(){
		System.out.println("-- maior pupulacao");
		String maiorPop = pais.maiorPopulacao();
		assertEquals("teste maiorpop", "China", maiorPop);
		
	}
	
	@Test
	public void test05MenorArea(){
		System.out.println("-- menor area");
		String menorArea = pais.menorArea();
		assertEquals("teste menorarea", "India", menorArea);
		
	}
}
