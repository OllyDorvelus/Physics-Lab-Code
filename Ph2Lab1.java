import java.lang.*;
public class Ph2Lab1 {
	
final static double greenm = 8.22;
final static double greenl =  155.4 / 100;
final static double greenL = 63.8 / 100;
final static double gflow1 = 21.49;
final static double gfhigh1 = 27.5;
final static double gflow2 = 51.15;
final static double gfhigh2 = 54.00;
final static double gflow3 = 73.83;
final static double gfhigh3 = 76.57;
final static double bluem = 12.52;
final static double bluel = 173.4 / 100;
final static double blueL = 64.4 / 100;
final static double bflow1 = 20.19;
final static double bfhigh1 = 21.75;
final static double bflow2 = 42.49;
final static double bfhigh2 = 44.23;
final static double bflow3 = 65.05;
final static double bfhigh3 = 66.61;
final static double yellowm = 4.08;
final static double yellowl = 161.0 / 100;
final static double yellowL = 64.3 / 100;
final static double yflow1 = 31.73;
final static double yfhigh1 = 35.89;
final static double yflow2 = 70.63;
final static double yfhigh2 = 72.10;
final static double yflow3 = 105.72;
final static double yfhigh3 = 108.60;
final double uncertainObs = 0.05 / 100.0;
static final double M = 550.0;
final double gravity = 9.80;
final double uncertainCalc = 0.01;
final static double n1 = 1.0;
final static double n2 = 2.0;
final static double n3 = 3.0;

public double F(double HM) {
	return HM * gravity;
}

public double uncertainF(double HM) {
	double uHM = 0.05 / HM;
	double uG = uncertainCalc / gravity;
	return (uHM + uG) * F(HM);
}

public double dens(double m, double l) {
	return m / l;
}

public double uncertainDens(double m, double l) {
	double uM = uncertainCalc / m;
	double uL = uncertainObs / l;
	return (uM + uL) * dens(m, l);
}

public double VTH(double M, double m, double l) {
	return Math.sqrt(F(M) / dens(m,l));
}

public double uncertainVTH(double M, double m, double l) {
	double uF = (uncertainF(M) / F(M)) * 0.5;
	double uDens = (uncertainDens(m, l) / dens(m, l)) * 0.5;
	return (uF + uDens) * VTH(M, m, l);
}
//wavelength
public double WL(double L, double n) {
	return (2 * L) / n;
}

public double uncertainWL(double L, double n) {
	return (2 / n) * uncertainObs;
}

public double freq(double flow, double fhigh) {
	return (flow + fhigh) / 2;
}

public double uncertainFreq(double flow, double fhigh) {
	return (fhigh - flow) / 2;
}

public double VEXP(double L, double n, double flow, double fhigh) {
	return freq(flow, fhigh) * WL(L, n);
}

public double uncertainVEXP(double L, double n, double flow, double fhigh) {
	double uWL = uncertainWL(L, n) / WL(L, n);
	double uFreq = uncertainFreq(flow, fhigh) / freq(flow, fhigh);
	return (uWL + uFreq) * VEXP(L, n, flow, fhigh);
}

public double diff(double M, double m, double l, double L, double n, double flow, double fhigh) {
	return Math.abs(VTH(M, m, l) - VEXP(L, n, flow, fhigh));
}

public double sigma(double M, double m, double l, double L, double n, double flow, double fhigh) {
	return uncertainVTH(M, m, l) + uncertainVEXP(L, n, flow, fhigh);
}



public double N(double M, double m, double l, double L, double n, double flow, double fhigh) {
	return diff(M, m, l, L, n, flow, fhigh) / sigma(M, m, l, L, n, flow, fhigh);
}








public void printM() {
	System.out.println(M);
}
	
	public static void main(String args[]) {
		Ph2Lab1 lab = new Ph2Lab1();
		System.out.println("Green Node 1:");
		//System.out.println("Force: " + lab.F(M));
		//System.out.println("Uncertain Force: " + lab.uncertainF(M));
		System.out.println("Linear Density: " + lab.dens(greenm, greenl));
		System.out.println("Uncertain Linear Density: " + lab.uncertainDens(greenm, greenl));
		System.out.println("Theortical Velocity: " + lab.VTH(M, greenm, greenl));
		System.out.println("Uncertain Theortical Velocity: " + lab.uncertainVTH(M, greenm, greenl));
		//System.out.println("Wavelength: " + lab.WL(greenL, n1));
		//System.out.println("Uncertain Wavelength: " + lab.uncertainWL(greenL, n1));
		//System.out.println("Frequency: " + lab.freq(gflow1, gfhigh1));
		//System.out.println("Uncertain Frequency: " + lab.uncertainFreq(gflow1, gfhigh1));
		System.out.println("Experimental Velocity: " + lab.VEXP(greenL, n1, gflow1, gfhigh1));
		System.out.println("Uncertian Experimental Velocity: " + lab.uncertainVEXP(greenL, n1, gflow1, gfhigh1));
		//System.out.println("Diff: " + lab.diff(M, greenm, greenl, greenL, n1, gflow1, gfhigh1));
		//System.out.println("Sigma: " + lab.sigma(M, greenm, greenl, greenL, n1, gflow1, gfhigh1));
		System.out.println("N: " + lab.N(M, greenm, greenl, greenL, n1, gflow1, gfhigh1) + "\n");
		
		System.out.println("Green Node 2:");
		System.out.println("Experimental Velocity: " + lab.VEXP(greenL, n2, gflow2, gfhigh2));
		System.out.println("Uncertian Experimental Velocity: " + lab.uncertainVEXP(greenL, n2, gflow2, gfhigh2));
		System.out.println("N: " + lab.N(M, greenm, greenl, greenL, n2, gflow2, gfhigh2) + '\n');
		
		System.out.println("Green Node 3:");
		System.out.println("Experimental Velocity: " + lab.VEXP(greenL, n3, gflow3, gfhigh3));
		System.out.println("Uncertian Experimental Velocity: " + lab.uncertainVEXP(greenL, n3, gflow3, gfhigh3));
		System.out.println("N: " + lab.N(M, greenm, greenl, greenL, n3, gflow3, gfhigh3) + '\n');
		
		System.out.println("Blue Node 1:");
		System.out.println("Linear Density: " + lab.dens(bluem, bluel));
		System.out.println("Uncertain Linear Density: " + lab.uncertainDens(bluem, bluel));
		System.out.println("Theortical Velocity: " + lab.VTH(M, bluem, bluel));
		System.out.println("Uncertain Theortical Velocity: " + lab.uncertainVTH(M, bluem, bluel));
		System.out.println("Experimental Velocity: " + lab.VEXP(blueL, n1, bflow1, bfhigh1));
		System.out.println("Uncertian Experimental Velocity: " + lab.uncertainVEXP(blueL, n1, bflow1, bfhigh1));
		System.out.println("N: " + lab.N(M, bluem, bluel, blueL, n1, bflow1, bfhigh1) + "\n");
		
		System.out.println("Blue Node 2:");
		System.out.println("Experimental Velocity: " + lab.VEXP(blueL, n2, bflow2, bfhigh2));
		System.out.println("Uncertian Experimental Velocity: " + lab.uncertainVEXP(blueL, n2, bflow2, bfhigh2));
		System.out.println("N: " + lab.N(M, bluem, bluel, blueL, n2, bflow2, bfhigh2) + "\n");
		
		System.out.println("Blue Node 3:");
		System.out.println("Experimental Velocity: " + lab.VEXP(blueL, n3, bflow3, bfhigh3));
		System.out.println("Uncertian Experimental Velocity: " + lab.uncertainVEXP(blueL, n3, bflow3, bfhigh3));
		System.out.println("N: " + lab.N(M, bluem, bluel, blueL, n3, bflow3, bfhigh3) + "\n");
		
		System.out.println("Yellow Node 1:");
		System.out.println("Linear Density: " + lab.dens(yellowm, yellowl));
		System.out.println("Uncertain Linear Density: " + lab.uncertainDens(yellowm, yellowl));
		System.out.println("Theortical Velocity: " + lab.VTH(M, yellowm, yellowl));
		System.out.println("Uncertain Theortical Velocity: " + lab.uncertainVTH(M, yellowm, yellowl));
		System.out.println("Experimental Velocity: " + lab.VEXP(yellowL, n1, yflow1, yfhigh1));
		System.out.println("Uncertian Experimental Velocity: " + lab.uncertainVEXP(yellowL, n1, yflow1, yfhigh1));
		System.out.println("N: " + lab.N(M, yellowm, yellowl, yellowL, n1, yflow1, yfhigh1) + "\n");
		
		System.out.println("Yellow Node 2:");
		System.out.println("Experimental Velocity: " + lab.VEXP(yellowL, n2, yflow2, yfhigh2));
		System.out.println("Uncertian Experimental Velocity: " + lab.uncertainVEXP(yellowL, n2, yflow2, yfhigh2));
		System.out.println("N: " + lab.N(M, yellowm, yellowl, yellowL, n2, yflow2, yfhigh2) + "\n");
		
		System.out.println("Yellow Node 3:");
		System.out.println("Experimental Velocity: " + lab.VEXP(yellowL, n3, yflow3, yfhigh3));
		System.out.println("Uncertian Experimental Velocity: " + lab.uncertainVEXP(yellowL, n3, yflow3, yfhigh3));
		System.out.println("N: " + lab.N(M, yellowm, yellowl, yellowL, n3, yflow3, yfhigh3) + "\n");
		
	}
}
