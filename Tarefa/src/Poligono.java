
public abstract class Poligono extends Figura{
	 private double base;
	 private double altura;
	 
	public Poligono(double base, double altura) {
		this.altura = altura;
		this.base = base;		
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public double area() {
		return 0.0;
	};
	public double perimetro() {
		return 0.0;
	};
}
