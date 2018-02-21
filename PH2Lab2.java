import java.lang.*;
public class PH2Lab2 {
final static double t1_256 = 0.0004;
final static double t2_256 = 0.0472;
final static double N_256 = 12.0;
final static double l1_256 = 32.2 / 100.0;
final static double l2_256 = 100.9 / 100.0;
final static double lu1_256 = 1.0 / 100.0;
final static double lu2_256 = 1.3 / 100.0;

final static double t1_320 = 0.0014;
final static double t2_320 = 0.0484;
final static double N_320 = 15.0;
final static double l1_320 = 25.7 / 100.0;
final static double l2_320 = 79.5 / 100.0;
final static double lu1_320 = 0.7 / 100.0;
final static double lu2_320 = 1.3 / 100.0;

final static double t1_384 = 0.0016;
final static double t2_384 = 0.0485;
final static double N_384 = 18.0;
final static double l1_384 = 21.3 / 100.0;
final static double l2_384 = 66.2 / 100.0;
final static double lu1_384 =  1.5 / 100.0;
final static double lu2_384 = 1.4 / 100.0;

final static double t1_512 = 0.0010;
final static double t2_512 = 0.0479;
final static double N_512 = 24.0;
final static double l1_512 = 15.5 / 100.0;
final static double l2_512 = 49.2 / 100.0;
final static double lu1_512 = 0.7 / 100.0;
final static double lu2_512 = 1.6 / 100.0;

final static double ut = 0.0001;

//public double l(double l_low, double l_high) {
//	return (l_low + l_high) / 2;
//}
//
//public double uncertainl(double l_low, double l_high) {
//	return (l_high - l_low) / 2;
//}

public double wavelength(double l1, double l2) {
	return 2.0 * (l2 - l1);
}

public double unwavelength(double ul1, double ul2) {
	return (2.0 * ul1 ) + (2.0 * ul2);
}

public double period(double t1, double t2, double N) {
	return (t2 - t1) / N;
}

public double unperiod(double N) {
	return ut / N;
}

public double freq(double t1, double t2, double N) {
	return 1 / period(t1, t2, N); 
}

public double unfreq(double t1, double t2, double N) {
	double fractun = unperiod(N) / period(t1, t2, N);
	double freq = freq(t1, t2, N);
	return fractun * freq;
}

public double VEXP(double l1, double l2, double t1, double t2, double N) {
	return freq(t1, t2, N) * wavelength(l1, l2); 
}

public double unVEXP(double l1, double l2, double ul1, double ul2, double t1, double t2, double N) {
	double ufreq = unfreq(t1, t2, N) / freq(t1, t2, N);
	double uwavelength = unwavelength(ul1, ul2) / wavelength(l1, l2);
	double fractun = ufreq + uwavelength;
	return fractun * VEXP(l1, l2, t1, t2, N);
}

public double celsius() {
	return (5.0/9.0) * (73.0 - 32.0);
}

public double uncelsius() {
	return (5.0/9.0);
}

public double VTH() {
	return 331.0 + (0.6 * celsius());
}



public double unVTH() {
	return 0.6 * uncelsius();
}

public double diff(double l1, double l2, double t1, double t2, double N) {
	return Math.abs(VEXP(l1, l2, t1, t2, N) - VTH());
}

public double sigma(double l1, double l2, double ul1, double ul2, double t1, double t2, double N) {
	return unVTH() + unVEXP(l1, l2, ul1, ul2, t1, t2, N);
}

public double N(double l1, double l2, double ul1, double ul2, double t1, double t2, double N) {
	return diff(l1, l2, t1, t2, N) / sigma(l1, l2, ul1, ul2, t1, t2, N);
}



	
	public static void main(String args[]) {
		PH2Lab2 lab = new PH2Lab2();
		System.out.println("Celsius Temperature: " + lab.celsius());
		System.out.println("Theoritcal Velocity: " + lab.VTH() + '\n');
		
		System.out.println("256:");
//		System.out.println("l1: " + la));
//		System.out.println("Uncertain l1: " + lab.uncertainl(l1_low256, l1_high256));
//		System.out.println("l2: " + lab.l(l2_low256, l2_high256));
//		System.out.println("Uncertain l1: " + lab.uncertainl(l2_low256, l2_high256));
		System.out.println("wavelength: " + lab.wavelength(l1_256, l2_256));
		System.out.println("Uncertain wavelength: " + lab.unwavelength(lu1_256, lu2_256));
		System.out.println("period: " + lab.period(t1_256, t2_256, N_256));
		System.out.println("Uncertain period: " + lab.unperiod(N_256));
		System.out.println("freq: " + lab.freq(t1_256, t2_256, N_256));
		System.out.println("Uncertain freq: " + lab.unfreq(t1_256, t2_256, N_256));
		System.out.println("Experimental Velocity: " + lab.VEXP(l1_256, l2_256, t1_256, t2_256, N_256));
		System.out.println("Uncertain Expermental Velocity: " + lab.unVEXP(l1_256, l2_256, lu1_256, lu2_256, 
				t1_256, t2_256, N_256));
		System.out.println("N: " + lab.N(l1_256, l2_256, lu1_256, lu2_256, t1_256, t2_256, N_256) + '\n');
				
		System.out.println("320:");
		System.out.println("freq: " + lab.freq(t1_320, t2_320, N_320));
		System.out.println("Uncertain freq: " + lab.unfreq(t1_320, t2_320, N_320));
				System.out.println("Experimental Velocity: " + lab.VEXP(l1_320, l2_320, t1_320, t2_320, N_320));
		System.out.println("Uncertain Expermental Velocity: " + lab.unVEXP(l1_320, l2_320, lu1_320, lu2_320, 
				t1_320, t2_320, N_320));
		System.out.println("N: " + lab.N(l1_320, l2_320, lu1_320, lu2_320, t1_320, t2_320, N_320) + '\n');
				
		System.out.println("384");
		System.out.println("freq: " + lab.freq(t1_384, t2_384, N_384));
		System.out.println("Uncertain freq: " + lab.unfreq(t1_384, t2_384, N_384));
		System.out.println("Experimental Velocity: " + lab.VEXP(l1_384, l2_384, t1_384, t2_384, N_384));
		System.out.println("Uncertain Expermental Velocity: " + lab.unVEXP(l1_384, l2_384, lu1_384, lu2_384, 
				t1_384, t2_384, N_384));
		System.out.println("N: " + lab.N(l1_384, l2_384, lu1_384, lu2_384, t1_384, t2_384, N_384) + '\n');
				
		System.out.println("512");
		System.out.println("freq: " + lab.freq(t1_512, t2_512, N_512));
		System.out.println("Uncertain freq: " + lab.unfreq(t1_512, t2_512, N_512));
		System.out.println("Experimental Velocity: " + lab.VEXP(l1_512, l2_512, t1_512, t2_512, N_512));
		System.out.println("Uncertain Expermental Velocity: " + lab.unVEXP(l1_512, l2_512, lu1_512, lu2_512, 
				t1_512, t2_512, N_512));
		System.out.println("N: " + lab.N(l1_512, l2_512, lu1_512, lu2_512, t1_512, t2_512, N_512) + '\n');


		

		
	}
}
