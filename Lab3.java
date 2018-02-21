
public class Lab3 {

	double uncertainM = 0.01;
	double uncertainMtotal = 0.02;
	double uncertaing = 0.01;
	double uncertainv = 0.001;
	double g = 9.80;
	static double m_1 = 309.64;
	double d = 10.0;
	double x = .436;
	double uncertainx = 0.0005;
	
	
	public double calculateMtotal(double m1, double m2) {
		return m1 + m2;
	}
	
	public double calculateWork(double m2) {
		double work = m2 * g * x;
		return work;
	}
	
	public double calculateWorkUncertainity(double m2) {
		double uncertainWork = (uncertainM / m2) + (uncertaing / g) + (uncertainx / x);
		uncertainWork = uncertainWork * calculateWork(m2);
		return uncertainWork;
	}
	
	public double calculateK1(double m1, double m2, double v1) {
		double Mtotal = m1 + m2;
		double k1 = .5 * Mtotal * v1 * v1;
		return k1;
	}
	
	public double calculateK2(double m1, double m2, double v2) {
		double Mtotal = m1 + m2;
		double k2 = .5 * Mtotal * v2 * v2;
		return k2;
	}
	
	public double calculateK1Uncertainity(double m1, double m2, double v1) {
		double Mtotal = m1 + m2;
		double uncertainK1 = (uncertainMtotal / Mtotal) + (2 *(uncertainv / v1));
		uncertainK1 = uncertainK1 * calculateK1(m1, m2, v1);
		return uncertainK1;
	}
	
	public double calculateK2Uncertainity(double m1, double m2, double v2) {
		double Mtotal = m1 + m2;
		double uncertainK2 = (uncertainMtotal / Mtotal) + (2 *(uncertainv / v2));
		uncertainK2 = uncertainK2 * calculateK2(m1, m2, v2);
		return uncertainK2;
	}
	
	public double calculateDeltaK(double m1, double m2, double v1, double v2) {
		double deltaK = calculateK2(m1, m2, v2) - calculateK1(m1, m2, v1);
		return deltaK;
	}
	
	public double calculateDeltaKUncertainity(double m1, double m2, double v1, double v2) {
		double uncertainDeltaK = calculateK1Uncertainity(m1, m2, v1) + calculateK2Uncertainity(m1, m2 ,v2);
		return uncertainDeltaK;
	}
	
	public double calculateN(double m1, double m2, double v1, double v2) {
		double diff = calculateWork(m2) - calculateDeltaK(m1, m2, v1, v2);
		diff = Math.abs(diff);
		double sigma = calculateWorkUncertainity(m2) + calculateDeltaKUncertainity(m1 , m2, v1, v2);
		double N = diff / sigma;
		return N;
	}
			
	public static void main(String args[]) {
		Lab3 myLab = new Lab3();
		
		System.out.println("Calculations");
		System.out.println("Trial 1 (Mass < 7 Grams)");
		System.out.println("Total mass: " + myLab.calculateMtotal(m_1, 6.93));
		System.out.println("Calculated Wnet: " + myLab.calculateWork(4.88));
		System.out.println("Calculated Wnet Uncertainity: " + myLab.calculateWorkUncertainity(4.88));
		System.out.println("Calculated k1: " + myLab.calculateK1(m_1, 4.88, 0.282));
		System.out.println("Calculated K1 Uncertainity: " + myLab.calculateK1Uncertainity(m_1, 4.88, 0.282));
		System.out.println("Calculated k2: " + myLab.calculateK2(m_1, 4.88, 0.452));
		System.out.println("Calculated k2 Uncertainity: " + myLab.calculateK2Uncertainity(m_1, 4.88, 0.452));
		System.out.println("Calculated deltaK: " + myLab.calculateDeltaK(m_1, 4.88, 0.282, 0.452));
		System.out.println("Calculated deltaK Uncertainity: " + myLab.calculateDeltaKUncertainity(m_1, 4.88, 0.282, 0.452));
		System.out.println("Trial 1 N Value: " + myLab.calculateN(m_1, 4.88, 0.282, 0.452));
		
		System.out.println();
		
		System.out.println("Trial 2 (Mass < 14 Grams)");
		System.out.println("Total mass: " + myLab.calculateMtotal(m_1, 12.89));
		System.out.println("Calculated Wnet: " + myLab.calculateWork(12.89));
		System.out.println("Calculated Wnet Uncertainity: " + myLab.calculateWorkUncertainity(12.89));
		System.out.println("Calculated k1: " + myLab.calculateK1(m_1, 12.89, 0.455));
		System.out.println("Calculated K1 Uncertainity: " + myLab.calculateK1Uncertainity(m_1, 12.89, 0.455));
		System.out.println("Calculated k2: " + myLab.calculateK2(m_1, 12.89, 0.736));
		System.out.println("Calculated k2 Uncertainity: " + myLab.calculateK2Uncertainity(m_1, 12.89, 0.736));
		System.out.println("Calculated deltaK: " + myLab.calculateDeltaK(m_1, 12.89, 0.455, 0.736));
		System.out.println("Calculated deltaK Uncertainity: " + myLab.calculateDeltaKUncertainity(m_1, 12.89, 0.455, 0.736));
		System.out.println("Trial 3 N Value: " + myLab.calculateN(m_1, 12.89, 0.455, 0.736));
		
		System.out.println();
		
		System.out.println("Trial 3 (Mass > 14 Grams)");
		System.out.println("Total mass: " + myLab.calculateMtotal(m_1, 19.85));
		System.out.println("Calculated Wnet: " + myLab.calculateWork(19.85));
		System.out.println("Calculated Wnet Uncertainity: " + myLab.calculateWorkUncertainity(19.85));
		System.out.println("Calculated k1: " + myLab.calculateK1(m_1, 19.85, 0.558));
		System.out.println("Calculated K1 Uncertainity: " + myLab.calculateK1Uncertainity(m_1, 19.85, 0.558));
		System.out.println("Calculated k2: " + myLab.calculateK2(m_1, 19.85, 0.905));
		System.out.println("Calculated k2 Uncertainity: " + myLab.calculateK2Uncertainity(m_1, 19.85, 0.905));
		System.out.println("Calculated deltaK: " + myLab.calculateDeltaK(m_1, 19.85, 0.558, 0.905));
		System.out.println("Calculated deltaK Uncertainity: " + myLab.calculateDeltaKUncertainity(m_1, 19.85, 0.558, 0.905));
		System.out.println("Trial 3 N Value: " + myLab.calculateN(m_1, 19.85, 0.558, 0.905));
	}

}


