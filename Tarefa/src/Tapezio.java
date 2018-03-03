
public class Tapezio extends Poligono{
	private double baseMenor;

	public Tapezio(double area, double base, double baseMenor) {
		super(area, base);
		this.setBaseMenor(baseMenor);
	}

	public double getBaseMenor() {
		return baseMenor;
	}

	public void setBaseMenor(double baseMenor) {
		this.baseMenor = baseMenor;
	}
	

	@Override
	public double area() {
		double bases = getBase() + getBaseMenor();
		return (bases * getAltura()) / 2;
	}
	
	@Override
	public double perimetro() {
		
		return getBase() + getBaseMenor() + (getAltura() * 2);
	}

}
