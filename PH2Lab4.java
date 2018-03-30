import java.lang.*;
public class PH2Lab4 {
	
	final static double v1t1 = 1.01;
	final static double v2t1 = 2.03;
	final static double v3t1 = 3.04;
	final static double v4t1 = 4.06;
	final static double v5t1 = 5.07;
	final static double v6t1 = 6.10;
	final static double v7t1 = 7.10;
	final static double v8t1 = 8.10;
	final static double v9t1 = 9.11;
	final static double v10t1 = 10.10;
	
	final static double i1t1 = 2.00;
	final static double i2t1 = 4.00;
	final static double i3t1 = 6.00;
	final static double i4t1 = 8.02;
	final static double i5t1 = 10.01;
	final static double i6t1 = 12.04;
	final static double i7t1 = 14.02;
	final static double i8t1 = 16.02;
	final static double i9t1 = 18.03;
	final static double i10t1 = 20.02;
	
	final static double v1t2 = 0.58;
	final static double v2t2 = 0.88;
	final static double v3t2 = 1.31;
	final static double v4t2 = 1.76;
	final static double v5t2 = 2.21;
	final static double v6t2 = 2.63;
	final static double v7t2 = 3.10;
	final static double v8t2 = 3.53;
	final static double v9t2 = 3.96;
	final static double v10t2 = 4.39;
	
	final static double i1t2 = 2.65;
	final static double i2t2 = 4.00;
	final static double i3t2 = 5.95;
	final static double i4t2 = 7.99;
	final static double i5t2 = 10.04;
	final static double i6t2 = 11.98;
	final static double i7t2 = 14.08;
	final static double i8t2 = 16.02;
	final static double i9t2 = 18.01;
	final static double i10t2 = 19.98;
	
	public double R(double v, double i) {
		return v / i;
	}
	
	public double mean(double ... R) {
		double total = 0.0;
		double mean;
		for(double i: R) {
			total += i;
		}
		mean = total / R.length;
		return mean;
	}
	
	public double standardDev(double ... R) {
		double mean = mean(R);
		double squared;
		double total = 0.0;
		double numberslength = R.length - 1;
		double finalnum;
		for(double i: R) {
			squared = i - mean;
			squared = squared * squared;
			total += squared;
		}
		finalnum = total / numberslength;
		finalnum = Math.sqrt(finalnum);
		return finalnum;
	}
	

			
	public static void main(String[] args) {
		PH2Lab4 lab = new PH2Lab4();
		double r1t1 = lab.R(v1t1, i1t1);
		double r2t1 = lab.R(v2t1, i2t1);
		double r3t1 = lab.R(v3t1, i3t1);
		double r4t1 = lab.R(v4t1, i4t1);
		double r5t1 = lab.R(v5t1, i5t1);
		double r6t1 = lab.R(v6t1, i6t1);
		double r7t1= lab.R(v7t1, i7t1);
		double r8t1 = lab.R(v8t1, i8t1);
		double r9t1 = lab.R(v9t1, i9t1);
		double r10t1 = lab.R(v10t1, i10t1);
		
		double r1t2 = lab.R(v1t2, i1t2);
		double r2t2 = lab.R(v2t2, i2t2);
		double r3t2 = lab.R(v3t2, i3t2);
		double r4t2 = lab.R(v4t2, i4t2);
		double r5t2 = lab.R(v5t2, i5t2);
		double r6t2 = lab.R(v6t2, i6t2);
		double r7t2= lab.R(v7t2, i7t2);
		double r8t2 = lab.R(v8t2, i8t2);
		double r9t2 = lab.R(v9t2, i9t2);
		double r10t2 = lab.R(v10t2, i10t2);
		
		System.out.println("First Test");
		System.out.println("R1: " + r1t1);
		System.out.println("R2: " + r2t1);
		System.out.println("R3: " + r3t1);
		System.out.println("R4: " + r4t1);
		System.out.println("R5: " + r5t1);
		System.out.println("R6: " + r6t1);
		System.out.println("R7: " + r7t1);
		System.out.println("R8: " + r8t1);
		System.out.println("R9: " + r9t1);
		System.out.println("R10: " + r10t1);
		System.out.println("Mean: " + lab.mean(r1t1, r2t1, r3t1, r4t1, r5t1, 
												 r6t1, r7t1, r8t1, r9t1, r10t1));
		System.out.println("Standard Deviation: " + lab.standardDev(r1t1, r2t1, r3t1, r4t1, r5t1, 
				 								r6t1, r7t1, r8t1, r9t1, r10t1));
		System.out.println();
		
		System.out.println("Second Test");
		System.out.println("R1: " + r1t2);
		System.out.println("R2: " + r2t2);
		System.out.println("R3: " + r3t2);
		System.out.println("R4: " + r4t2);
		System.out.println("R5: " + r5t2);
		System.out.println("R6: " + r6t2);
		System.out.println("R7: " + r7t2);
		System.out.println("R8: " + r8t2);
		System.out.println("R9: " + r9t2);
		System.out.println("R10: " + r10t2);
		System.out.println("Mean: " + lab.mean(r1t2, r2t2, r3t2, r4t2, r5t2, 
											  r6t2, r7t2, r8t2, r9t2, r10t2));
		System.out.println("Standard Deviation: " + lab.standardDev(r1t2, r2t2, r3t2, r4t2, r5t2, 
				  										     r6t2, r7t2, r8t2, r9t2, r10t2));
	}
}
