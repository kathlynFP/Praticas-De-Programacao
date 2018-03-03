
public class Losango extends Poligono{

	public Losango(double base, double altura) {
		super(base, altura);
	}
	
	@Override
	public double area() {
		//Analisando que o losango é a junção de dois triângulos isosceles
		
		double diametroMaior = getAltura() * 2;
		double diametroMenor = getBase();
		
		return (diametroMaior * diametroMenor)/2;
	}
	
	@Override
	public double perimetro() {
		return (getAltura() / 2) * 4;
	}

}
