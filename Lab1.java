import static java.lang.Math.pow;
import static java.lang.Math.PI;
import static java.lang.Math.abs;

public class Lab1 {
	double uncertainLcal = 0.003;
	double uncertaindcal = 0.003;
	double uncertainWcal = 0.003;
	double uncertainTcal = 0.003;
	double uncertaindrul = 0.05;
	double uncertainLrul = 0.05;
	double uncertainWrul = 0.05;
	double uncertainTrul = 0.05;
	double uncertainM = 0.05;
	
	
	public double rectangleVrul(double L, double W, double T) {
		double V;
		V = L * W * T;
		return V;
	}
	
	public double uncertainRectangleVrul(double L, double W, double T) {
		double deltaV;
		deltaV = ((uncertainLrul / L) + (uncertainWrul / W) + (uncertainTrul / T));
		deltaV = deltaV * rectangleVrul(L, W, T);
		return deltaV;
	}
	
	public double rectangleDrul(double L, double W, double T, double m) {
		double density;
		density = m / rectangleVrul(L, W, T);
		return density;
	}
	
	public double uncertainRectangleDrul(double L, double W, double T, double m) {
		double deltaDensity;
		deltaDensity = ( (uncertainM / m) + (uncertainRectangleVrul(L, W, T) / rectangleVrul(L, W, T)) );
		deltaDensity = deltaDensity * rectangleDrul(L, W, T, m);
		return deltaDensity;
	}
	
	
	
	public double rectangleVcal(double L, double W, double T) {
		double V;
		V = L * W * T;
		return V;
	}
	
	public double uncertainRectangleVcal(double L, double W, double T) {
		double deltaV;
		deltaV = ((uncertainLcal / L) + (uncertainWcal / W) + (uncertainTcal / T));
		deltaV = deltaV * rectangleVcal(L, W, T);
		return deltaV;
	}
	
	public double rectangleDcal(double L, double W, double T, double m) {
		double density;
		density = m / rectangleVcal(L, W, T);
		return density;
	}
	
	public double uncertainRectangleDcal(double L, double W, double T, double m) {
		double deltaDensity;
		deltaDensity = (uncertainM / m) + ( uncertainRectangleVcal(L, W, T) / rectangleVcal(L, W, T) );
		deltaDensity = deltaDensity * rectangleDcal(L, W, T, m);
		return deltaDensity;
	}
	
	public double Vout(double dout, double L) {
		double Vout;
		Vout = (Math.PI / 4) * (dout * dout) * L;
		return Vout;
	}
	
	public double Vin(double din, double L) {
		double Vin;
		Vin = (Math.PI / 4) * (din * din) * L;
		return Vin;
	}
	
	public double Vcyl(double dout, double din, double L) {
		double Vcyl;
		Vcyl = Vout(dout, L) - Vin(din, L);
		return Vcyl;
	}
	
	public double uncertainVoutcal(double dout, double L) {
		double deltaVout;
		deltaVout = 2 * (uncertaindcal / dout) + (uncertainLcal / L);
		deltaVout = deltaVout * Vout(dout, L);
		return deltaVout;
	}
	
	public double uncertainVincal(double din, double L) {
		double deltaVin;
		deltaVin = 2 * (uncertaindcal / din) + (uncertainLcal / L);
		deltaVin = deltaVin * Vin(din, L);
		return deltaVin;
	}
	
	public double uncertainVcylcal(double dout, double din, double L) {
		double deltaVcyl;
		deltaVcyl = uncertainVoutcal(dout, L) + uncertainVincal(din, L);
		return deltaVcyl;
	}

	public double cylDensity(double dout, double din, double L, double m) {
		double density;
		density = m / Vcyl(dout, din, L);
		return density;
	}
	
	public double uncertainDcal(double dout, double din, double L, double m) {
		double deltaDensity;
		deltaDensity = (uncertainM / m) + (uncertainVcylcal(dout, din, L) / Vcyl(dout, din, L));
		deltaDensity = deltaDensity * cylDensity(dout, din, L, m);
		return deltaDensity;
	}
	
	public double uncertainVoutrul(double dout, double L) {
		double deltaVout;
		deltaVout = 2 * (uncertaindrul / dout) + (uncertainLrul / L);
		deltaVout = deltaVout * Vout(dout, L);
		return deltaVout;
	}
	
	public double uncertainVinrul(double din, double L) {
		double deltaVin;
		deltaVin = 2 * (uncertaindrul / din) + (uncertainLrul / L);
		deltaVin = deltaVin * Vin(din, L);
		return deltaVin;
	}
	
	public double uncertainVcylrul(double dout, double din, double L) {
		double deltaVcyn;
		deltaVcyn = uncertainVoutrul(dout, L) + uncertainVinrul(din, L);
		return deltaVcyn;
	}
	
	public double uncertainDrul(double dout, double din, double L, double m) {
		double deltaDensity;
		deltaDensity = (uncertainM / m) + (uncertainVcylrul(dout, din, L) / Vcyl(dout, din, L));
		deltaDensity = deltaDensity * cylDensity(dout, din, L, m);
		return deltaDensity;
	}
	
	public double rectangleVolumeN(double L, double W, double T, double cL, double cW, double cT) {
		double N;
		double diff = Math.abs(rectangleVrul(L, W, T) - rectangleVcal(cL, cW, cT) );
		double sigma = uncertainRectangleVrul(L, W, T) + uncertainRectangleVcal(cL,cW,cT);
		N = diff / sigma;
		return N;
	}
	
	public double rectangleDensityN(double L, double W, double T, double cL, double cW, double cT, double m) {
		double N;
		double diff = Math.abs(rectangleDrul(L, W, T, m) - rectangleDcal(cL, cW, cT, m));
		double sigma = uncertainRectangleDrul(L, W, T, m) + uncertainRectangleDcal(cL, cW, cT, m);
		N = diff / sigma;
		return N;
	}
	
	
	public double cylVolumeN(double doutrul, double dinrul, double Lrul, double doutcal, double dincal, double Lcal) {
		double N;
		double diff = Math.abs(Vcyl(doutrul, dinrul, Lrul) - Vcyl(doutcal, dincal, Lcal));
		double sigma = uncertainVcylrul(doutrul, dinrul, Lrul) + uncertainVcylcal(doutcal, dincal, Lcal);
		N = diff / sigma;
		return N;
	}
	
	public double cylDensityN(double doutrul, double dinrul, double Lrul, double doutcal, double dincal, double Lcal, double m) {
		double N;
		double diff = Math.abs(cylDensity(doutrul, dinrul, Lrul, m) - cylDensity(doutcal, dincal, Lcal, m));
		double sigma = uncertainDrul(doutrul, dinrul, Lrul, m) + uncertainDcal(doutcal, dincal, Lcal, m);
		N = diff / sigma;
		return N;
	}
	
	public static void main(String args[]) {
		
		Lab1 myLab = new Lab1();
		//Example Set
//		System.out.println(myLab.rectangleVcal(5.104,2.536, 0.313));
//		System.out.println(myLab.uncertainRectangleVcal(5.104,2.536, 0.313));
//		System.out.println(myLab.rectangleDcal(5.104,2.536, 0.313, 31.9));
//		System.out.println(myLab.uncertainRectangleDcal(5.104,2.536, 0.313, 31.9));
//		System.out.println(myLab.rectangleVrul(5.1, 2.5, 0.3));
//		System.out.println(myLab.uncertainRectangleVrul(5.1, 2.5, 0.3));
//		System.out.println(myLab.rectangleDrul(5.1, 2.5, 0.3, 31.9));
//		System.out.println(myLab.uncertainRectangleDrul(5.1, 2.5, 0.3, 31.9));
		
		//CYL example set
//		System.out.println();
//		System.out.println(myLab.Vout(2.543, 3.812) + " - " + (myLab.Vin(1.273, 3.812)));
//		//System.out.println(myLab.Vin(1.273, 3.812));
//		System.out.println(myLab.Vcyl(2.543, 1.273, 3.812));
//		System.out.println(myLab.uncertainVoutcal(2.543, 3.812));
//		System.out.println(myLab.uncertainVincal(1.273, 3.812));
//		System.out.println(myLab.uncertainVcylcal(2.543, 1.273, 3.812));
		
		System.out.println();
		//SFB Ruler
		System.out.println("SFB Ruler");
		System.out.println("SFB Ruler Volume = " + myLab.rectangleVrul(3.70, 2.60, 0.70));
		System.out.println("SFB Uncertain Ruler Volume = " + myLab.uncertainRectangleVrul(3.70, 2.60, 0.70));
		System.out.println("SFB Ruler Density = " +myLab.rectangleDrul(3.70, 2.60, 0.70, 16.05));
		System.out.println("SFB Uncertain Ruler Density = " + myLab.uncertainRectangleDrul(3.70, 2.60, 0.70, 16.05));
		
		//SFB Caliper
		System.out.println();
		System.out.println("SFB Caliper");
		System.out.println("SFB Caliper Volume = " + myLab.rectangleVcal(3.764,2.533, 0.633));
		System.out.println("SFB Caliper Uncertain Volume = " + myLab.uncertainRectangleVcal(3.764,2.533, 0.633));
		System.out.println("SFB Caliper Density = " + myLab.rectangleDcal(3.764,2.533, 0.633, 16.05));
		System.out.println("SFB Uncertain Caliper Density = " + myLab.uncertainRectangleDcal(3.764,2.533, 0.633, 16.05));
		
		//SFB N
		
		System.out.println();
		System.out.println("Volume N = " + myLab.rectangleVolumeN(3.70, 2.60, 0.70, 3.764,2.533, 0.633));
		System.out.println("Density N = " + myLab.rectangleDensityN(3.70, 2.60, 0.70, 3.764,2.533, 0.633, 16.05));
		//LSB Ruler
		System.out.println();
		System.out.println("LSB Ruler");
		
		System.out.println("LSB Ruler Volume = " + myLab.rectangleVrul(2.60, 5.10, 0.30));
		System.out.println("LSB Ruler Uncertain Volume = " + myLab.uncertainRectangleVrul(2.60, 5.10, 0.30));
		System.out.println("LSB Ruler Density = " + myLab.rectangleDrul(2.60, 5.10, 0.30, 31.98));
		System.out.println("LSB Ruler Uncertain Density = " + myLab.uncertainRectangleDrul(2.60, 5.10, 0.30, 31.98));
		
		//LSB Caliper
		System.out.println();
		
		System.out.println("LSB Caliper Volume = " + myLab.rectangleVcal(2.540, 5.082, 0.316));
		System.out.println("LSB Caliper Uncertain Volume = " + myLab.uncertainRectangleVcal(2.540, 5.082, 0.316));
		System.out.println("LSB Caliper Density = " + myLab.rectangleDcal(2.540, 5.082, 0.316, 31.98));
		System.out.println("LSB Caliper Uncertain Density = " + myLab.uncertainRectangleDcal(2.540, 5.082, 0.316, 31.98));
		
		//LSB N
		System.out.println();
		System.out.println("Volume N = " + myLab.rectangleVolumeN(2.60, 5.10, 0.30, 2.540, 5.082, 0.316));
		System.out.println("Density N = " + myLab.rectangleDensityN(2.60, 5.10, 0.30, 2.540, 5.082, 0.316, 31.98));
		
		
		System.out.println();

		
		System.out.println();
		
		//System.out.println(myLab.rectangleVolumeN(5.1, 2.5, 0.3, 5.104,2.536, 0.313));


		System.out.println("Hollow Cylinder Ruler");
		System.out.println(myLab.Vout(2.60, 3.80 ) + " - " + (myLab.Vin(1.40, 3.830)));
		System.out.println("Ruler Vcyl = " + myLab.Vcyl(2.60, 1.40, 3.80));
		System.out.println("Ruler Uncertain Vout = " + myLab.uncertainVoutrul(2.60, 3.80));
		System.out.println("Ruler Uncertain Vin = " + myLab.uncertainVinrul(1.40, 3.80));
		System.out.println("Ruler Uncertain Vcyl = " + myLab.uncertainVcylrul(2.60, 1.40, 3.80));
		System.out.println("Ruler Density = " + myLab.cylDensity(2.60, 1.40, 3.80, 112.95));
		System.out.println("Ruler Uncertain Density = " + myLab.uncertainDrul(2.60, 1.40, 3.80, 112.95));

		
		System.out.println();
		
		System.out.println("Hollow Cylinder Caliper");
		System.out.println(myLab.Vout(2.541, 3.830) + " - " + (myLab.Vin(1.265, 3.830)));
		System.out.println("Caliper Vcyl = " + myLab.Vcyl(2.541, 1.265, 3.830));
		System.out.println("Caliper Uncertain Vout = " + myLab.uncertainVoutcal(2.541, 3.830));
		System.out.println("Caliper Uncertain Vin = " + myLab.uncertainVincal(1.265, 3.830));
		System.out.println("Caliper Uncertain Vcyl = " + myLab.uncertainVcylcal(2.541, 1.265, 3.830));
		System.out.println("Caliper Density = " + myLab.cylDensity(2.541, 1.265, 3.830, 112.95));
		System.out.println("Ruler Uncertain Density = " +  myLab.uncertainDcal(2.541, 1.265, 3.830, 112.95));
		
		System.out.println();
		
		System.out.println("Volume N = " + myLab.cylVolumeN(2.60, 1.40, 3.80, 2.541, 1.265, 3.830));
		System.out.println("Density N = " + myLab.cylDensityN(2.60, 1.40, 3.80, 2.541, 1.265, 3.830, 112.95));
	}
}
