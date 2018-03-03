
public class Quadrado extends Poligono implements Diagonal{
	
	public Quadrado(double base, double altura) {
		super(base, altura);
	}
	
	@Override
	public double area() {
		return (this.getBase() * this.getAltura());
	}
	
	@Override
	public double perimetro() {
		return (this.getBase() * 4);
	}
	
	public double calcDiagonal() {
		return (getAltura() * Math.sqrt(2));
	}

}
