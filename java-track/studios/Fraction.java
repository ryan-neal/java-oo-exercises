
public class Fraction {
	private int mNumerator;
	private int mDenominator;
	
	public Fraction(int numerator, int denominator){
		mNumerator = numerator;
		mDenominator = denominator;
	}
	
	public int getNumerator(){
		return this.mNumerator;
	}
	
	public int getDenominator(){
		return this.mDenominator;
	}
	
	public Fraction multiply(Fraction fract){
		int numerator = this.mNumerator * fract.mNumerator;
		int denominator = this.mDenominator * fract.mDenominator;
		Fraction fract2 = new Fraction(numerator, denominator);
		return fract2;
	}
	
	public Fraction add(Fraction fract){
		int numerator1 = this.mNumerator * fract.mDenominator;
		int numerator2 = fract.mNumerator * this.mDenominator;
		int denominator = this.mDenominator * fract.mDenominator;
		int numerator3 = numerator1 + numerator2;
		Fraction fract2 = new Fraction(numerator3, denominator);
		fract2 = fract2.simplify();
		return fract2;
	}
	
	public void printFraction(){
		System.out.println(this.mNumerator + "/" + this.mDenominator);
	}
	
	public Fraction reciprocal(){
		int numerator = this.mDenominator;
		int denominator = this.mNumerator;
		Fraction fract2 = new Fraction(numerator, denominator);
		return fract2;
	}
	
	public int gcd(){
		int numerator = this.mNumerator;
		int denominator = this.mDenominator;
		while (denominator != 0){
			if (numerator > denominator){
				numerator -= denominator;
			}
			else{
				denominator -= numerator;
			}
		}
		return numerator;
	}
	
	public Fraction simplify(){
		int divisor = this.gcd();
		int numerator = this.mNumerator / divisor;
		int denominator = this.mDenominator / divisor;
		Fraction fract2 = new Fraction(numerator, denominator);
		return fract2;
	}
	
	public static void main(String[] args){
		Fraction rectangle1 = new Fraction(3, 5);
		Fraction rectangle2 = new Fraction(4, 6);
		Fraction fract1 = rectangle1.multiply(rectangle2);
		fract1.printFraction();
		Fraction fract2 = rectangle1.add(rectangle2);
		fract2.printFraction();
		Fraction fract3 = rectangle1.reciprocal();
		fract3.printFraction();
		int answer = fract1.gcd();
		System.out.println(answer);
		Fraction fract4 = fract1.simplify();
		fract4.printFraction();
	}
}
