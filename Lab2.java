
public class Lab2 {
	
	double uncertainM = 0.01;
	double uncertainMtotal = 0.02;
	double uncertaing = 0.01;
	double g = 9.80;
	static double acceltrial1 = 0.18789;
	static double uncertaintrial1 = 0.014431;
	static double acceltrial2 = 0.28421;
	static double uncertaintrial2 = 0.010628;
	static double acceltrial3 = 0.46691;
	static double uncertaintrial3 = 0.0068437;
	static double m_1 = 324.30;
	
	public double calculateMtotal(double m1, double m2) {
		return m1 + m2;
	}
	
	public double calculateAcceleration(double m1, double m2) {
		double N = m2 * g;
		double Mtotal = calculateMtotal(m1, m2);
		return N / Mtotal;
	}
	
	public double calculateUncertaintityAccerleration(double m1, double m2) {
		//double uncertainM2 = uncertainM / m2;
		//double uncertainMtot = uncertainMtotal /
		double uncertanity = (uncertainM / m2) + (uncertainMtotal / calculateMtotal(m1,m2)) + (uncertaing / g);
		double uncertainAcceleration = calculateAcceleration(m1,m2) * uncertanity;
		return uncertainAcceleration;
	}
	
	public double calculateN(double m1, double m2, double trialA, double trialUncertainA) {
		double diff = calculateAcceleration(m1, m2) - trialA;
		diff = Math.abs(diff);
		double sigma = calculateUncertaintityAccerleration(m1, m2) + trialUncertainA;
		double N = diff / sigma;
		return N;
		
	}
	
	
	
	public static void main(String args[]) {
		Lab2 myLab = new Lab2();
		System.out.println("Calculations");
		System.out.println("Trial 1 (Mass < 7 Grams)");
		System.out.println("Total mass: " + myLab.calculateMtotal(m_1, 6.93));
		System.out.println("Calculated Acceleneration: " + myLab.calculateAcceleration(m_1, 6.93));
		System.out.println("Calculated Acceleration Uncertainity: " + myLab.calculateUncertaintityAccerleration(m_1, 6.93));
		System.out.println("Trial 1 N: " + myLab.calculateN(m_1, 6.93, acceltrial1, uncertaintrial1));
		
		System.out.println();
		System.out.println("Trial 2 (Mass < 14 Grams)");
		System.out.println("Total mass: " + myLab.calculateMtotal(m_1, 10.85));
		System.out.println("Calculated Acceleneration: " + myLab.calculateAcceleration(m_1, 10.85));
		System.out.println("Calculated Acceleration Uncertainity: " + myLab.calculateUncertaintityAccerleration(m_1, 10.85));
		System.out.println("Trial 2 N: " + myLab.calculateN(m_1, 10.85, acceltrial2, uncertaintrial2));
		
		System.out.println();
		System.out.println("Trial 3 (Mass > 14 Grams)");
		System.out.println("Total mass: " + myLab.calculateMtotal(m_1, 16.95));
		System.out.println("Calculated Acceleneration: " + myLab.calculateAcceleration(m_1, 16.95));
		System.out.println("Calculated Acceleration Uncertainity: " + myLab.calculateUncertaintityAccerleration(m_1, 16.95));
		System.out.println("Trial 3 N: " + myLab.calculateN(m_1, 16.95, acceltrial3, uncertaintrial3));
		

	}
}

