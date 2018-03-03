
public class TesteLosango {

	public TesteLosango() {
		
	}

	public static void main(String[] args) {
		
		Losango f = new Losango(5, 2);
		System.out.println("Losango: " + f.area());
		
		Quadrado quad = new Quadrado(8, 8);
		System.out.println("Quadrado: " + quad.area()+ " " + quad.calcDiagonal());
		
		Retangulo retang = new Retangulo(8, 8);
		System.out.println("Retangulo: " + retang.area()+ " " + retang.calcDiagonal());
		
		Triangulo triang = new Triangulo(3, 2);
		System.out.println("Triangulo: " + triang.area());

	}

}
