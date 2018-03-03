import java.util.ArrayList;

public class TesteFigura {

	public static void main(String[] args) {
		 ArrayList<String> figuras = new ArrayList<String>();
		 
		Losango f = new Losango(5, 2);
		System.out.println("Losango: " + f.area());
		
		Quadrado quad = new Quadrado(8, 8);
		System.out.println("Quadrado: " + quad.area()+ " " + quad.calcDiagonal());
		
		Retangulo retang = new Retangulo(8, 8);
		System.out.println("Retangulo: " + retang.area()+ " " + retang.calcDiagonal());
		
		Triangulo triang = new Triangulo(3, 2);
		System.out.println("Triangulo: " + triang.area());
		 
		 figuras.add("-Losango\n  Area: " + f.area() + "\n  Perimetro: " + f.perimetro());
		 figuras.add("\n-Quadrado\n  Area: " + quad.area() + "\n  Perimetro: " + quad.perimetro() + "\n  Diagonal: " + quad.calcDiagonal());
		 
		 for (int i = 0; i < figuras.size(); i++) {
		    System.out.printf(figuras.get(i));
		 }

	}

}
