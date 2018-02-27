import java.lang.*;
public class PH2Lab3 {
	final static double xa = 5.4 / 100.0;
	final static double xc1 = 4.0 / 100.0;
	final static double xb1 = 5.6 / 100.0;
	final static double xc2 = 4.2 / 100.0;
	final static double xb2 = 5.5 / 100.0;
	final static double xc3 = 4.0 / 100.0;
	final static double xb3 = 5.7 / 100.0;
	final static double xc4 = 4.1 / 100.0;
	final static double xb4 = 5.6 / 100.0;
	final static double xc5 = 4.2 / 100.0;
	final static double xb5 = 5.5 / 100.0;
	final static double xc6 = 4.1 / 100.0;
	final static double xb6 = 5.6 / 100.0;
	
	final static double K = 9000000000.0;
	final static double g = 9.80;
	final static double L = 22.5 / 100.0;
	final static double unL = 0.5 / 100.0;
	final static double m = 0.07 / 1000.0;
	final static double unm = 0.01 / 1000.0;
	final static double unx = 0.05 / 100.0;
	final static double ung = 0.001;
	
	
	public double deflection(double xb) {
		return xb - xa;
	}
	
	public double undeflection() {
		return unx + unx;
	}
	
	public double r(double xb, double xc) {
		return xb - xc;
	}
	
	public double unr() {
		return unx + unx;
	}
	
	public double FE(double xb) {
		return (m * g * deflection(xb)) /  L;
	}
	
	public double unFE(double xb) {
		double fractun = (unm / m) + (ung / g) + (undeflection() / deflection(xb)) + (unL / L);
		return fractun * FE(xb);
	}
	
	public double q1q2(double xb, double xc) {
		return (r(xb, xc) * r(xb, xc) * FE(xb)) / K;
	}
	
	public double unq1q2(double xb, double xc) {
		double fractun = (2 * (unr() / r(xb, xc))) + (unFE(xb) / FE(xb));
		return fractun * q1q2(xb, xc);
	}
	
	public double q(double xb, double xc) {
		return Math.sqrt(q1q2(xb, xc));
	}
	
	public double unq(double xb, double xc) {
		double fractun = 0.5 * (unq1q2(xb, xc) / q1q2(xb, xc));
		return fractun * q(xb, xc);
	}
	
	
	
	public static void main(String args[]) {
		PH2Lab3 lab = new PH2Lab3();
		System.out.println("Trial 1:");
		System.out.println("Deflection: " + lab.deflection(xb1));
		System.out.println("Uncertain Deflection: " + lab.undeflection());
		System.out.println("r: " + lab.r(xb1, xc1));
		System.out.println("Uncertain r: " + lab.unr());
		System.out.println("FE: " + lab.FE(xb1));
		System.out.println("Uncertain FE: " + lab.unFE(xb1));
		System.out.println("q1q2: " + lab.q1q2(xb1, xc1));
		System.out.println("Uncertain q1q2: " + lab.unq1q2(xb1, xc1));
		System.out.println("q: " + lab.q(xb1, xc1));
		System.out.println("Uncertain q: " + lab.unq(xb1, xc1) + '\n');
		
		System.out.println("Trial 2:");
		System.out.println("Deflection: " + lab.deflection(xb2));
		System.out.println("Uncertain Deflection: " + lab.undeflection());
		System.out.println("r: " + lab.r(xb2, xc2));
		System.out.println("Uncertain r: " + lab.unr());
		System.out.println("FE: " + lab.FE(xb2));
		System.out.println("Uncertain FE: " + lab.unFE(xb2));
		System.out.println("q1q2: " + lab.q1q2(xb2, xc2));
		System.out.println("Uncertain q1q2: " + lab.unq1q2(xb2, xc2));
		System.out.println("q: " + lab.q(xb2, xc2));
		System.out.println("Uncertain q: " + lab.unq(xb2, xc2) + '\n');
		
		System.out.println("Trial 3:");
		System.out.println("Deflection: " + lab.deflection(xb3));
		System.out.println("Uncertain Deflection: " + lab.undeflection());
		System.out.println("r: " + lab.r(xb3, xc3));
		System.out.println("Uncertain r: " + lab.unr());
		System.out.println("FE: " + lab.FE(xb3));
		System.out.println("Uncertain FE: " + lab.unFE(xb3));
		System.out.println("q1q2: " + lab.q1q2(xb3, xc3));
		System.out.println("Uncertain q1q2: " + lab.unq1q2(xb3, xc3));
		System.out.println("q: " + lab.q(xb3, xc3));
		System.out.println("Uncertain q: " + lab.unq(xb3, xc3) + '\n');
		
		System.out.println("Trial 4:");
		System.out.println("Deflection: " + lab.deflection(xb4));
		System.out.println("Uncertain Deflection: " + lab.undeflection());
		System.out.println("r: " + lab.r(xb4, xc4));
		System.out.println("Uncertain r: " + lab.unr());
		System.out.println("FE: " + lab.FE(xb4));
		System.out.println("Uncertain FE: " + lab.unFE(xb4));
		System.out.println("q1q2: " + lab.q1q2(xb4, xc4));
		System.out.println("Uncertain q1q2: " + lab.unq1q2(xb4, xc4));
		System.out.println("q: " + lab.q(xb4, xc4));
		System.out.println("Uncertain q: " + lab.unq(xb4, xc4) + '\n');
		
		System.out.println("Trial 5:");
		System.out.println("Deflection: " + lab.deflection(xb5));
		System.out.println("Uncertain Deflection: " + lab.undeflection());
		System.out.println("r: " + lab.r(xb5, xc5));
		System.out.println("Uncertain r: " + lab.unr());
		System.out.println("FE: " + lab.FE(xb5));
		System.out.println("Uncertain FE: " + lab.unFE(xb5));
		System.out.println("q1q2: " + lab.q1q2(xb5, xc5));
		System.out.println("Uncertain q1q2: " + lab.unq1q2(xb5, xc5));
		System.out.println("q: " + lab.q(xb5, xc5));
		System.out.println("Uncertain q: " + lab.unq(xb5, xc5) + '\n');
		
		System.out.println("Trial 6:");
		System.out.println("Deflection: " + lab.deflection(xb6));
		System.out.println("Uncertain Deflection: " + lab.undeflection());
		System.out.println("r: " + lab.r(xb6, xc6));
		System.out.println("Uncertain r: " + lab.unr());
		System.out.println("FE: " + lab.FE(xb6));
		System.out.println("Uncertain FE: " + lab.unFE(xb6));
		System.out.println("q1q2: " + lab.q1q2(xb6, xc6));
		System.out.println("Uncertain q1q2: " + lab.unq1q2(xb6, xc6));
		System.out.println("q: " + lab.q(xb6, xc6));
		System.out.println("Uncertain q: " + lab.unq(xb6, xc6) + '\n');
		
	}
}
