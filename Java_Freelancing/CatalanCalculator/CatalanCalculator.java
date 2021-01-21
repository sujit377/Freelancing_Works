package Palindrome;
import java.lang.IllegalArgumentException;
public class CatalanCalculator {
	private int calculatedCatalanNumbersCount;
	private int[] calculatedCatalanNumberCount;
	private int maximumStackDepth=0;
	int first=0;

	public int catalan(int n) throws IllegalArgumentException {
		int res=0;
		if(n<0) {
			throw new IllegalArgumentException();
		}
		if(first==0) {
			calculatedCatalanNumberCount = new int[n+1];
			for(int i=0;i<calculatedCatalanNumberCount.length;i++)
				calculatedCatalanNumberCount[i] = 0;
				maximumStackDepth=n+1;
				calculatedCatalanNumbersCount=0;
				first=1;
		}
		calculatedCatalanNumberCount[n]++;
		calculatedCatalanNumbersCount++;
		if(n==0) {
			
			if(n==maximumStackDepth-1) {
				first=0;
			}
			return 1;
		}
		else {
			for(int i =0;i<n;i++) {
				res=res+catalan(i)*catalan(n-1-i);
			}
			if(n==maximumStackDepth-1) {
				first=0;
				return calculatedCatalanNumbersCount;
			}
			return res;
		}
	}
	 /**
	 * Returns the total number of Catalan numbers computed to compute the one
	 * requested by the user.
	 *
	 * @return number of calculated Catalan numbers.
	 * @throws IllegalStateException
	 * if this method is called before {@link #catalan(int)} was called.
	 */
	public int getCalculatedCatalanNumbersCount() throws IllegalArgumentException{
//		it will throw exception if it will used before calling catalan
		if(maximumStackDepth==0) {
			throw new IllegalArgumentException();
		}
//		return calculatedCatalanNumberCount
		return calculatedCatalanNumbersCount;
	}
	
/**
 * Returns the number of times the given Catalan number was computed to compute
 * 
 * the one requested by the user.
 *
 * @param i
 * the Catalan number whose computation statistics to return.
 * @return how often C(i) was computed.
 * @throws IllegalStateException
 * if this method is called before {@link #catalan(int)} was called.
 * @throws IllegalArgumentException
 * if the index i is invalid.
 */
	public int getCalculatedCatalanNumberCount(int i)  throws IllegalArgumentException {
 // Implement me as well!
//		it will throw exception if it will used before calling catalan and
//		it will throw exception if index is illegal
		if(maximumStackDepth<=0 || maximumStackDepth<i) {
			throw new IllegalArgumentException();
		}
//		return the ith value of array calculatedCatalanNumberCount[]
		return calculatedCatalanNumberCount[i];
 }
	
	/**
	 * Returns the maximum stack depth encountered while computing the requested
	 * Catalan number.
	 *
	 * @return maximum stack depth.
	 * @throws IllegalStateException
	 * if this method is called before {@link #catalan(int)} was called.
	 */
	
	public int getMaximumStackDepth() throws IllegalArgumentException{
//		it will throw exception if it will used before calling catalan
		if(maximumStackDepth==0) {
			throw new IllegalArgumentException();
		}
		return maximumStackDepth;
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CatalanCalculator c=new CatalanCalculator();
		int a = c.catalan(1);
		System.out.println(a);
		System.out.println(c.getCalculatedCatalanNumbersCount());
		System.out.println(c.getCalculatedCatalanNumberCount(0));
		System.out.println(c.getCalculatedCatalanNumberCount(1));
//		System.out.println(c.getCalculatedCatalanNumberCount(2));
//		System.out.println(c.getCalculatedCatalanNumberCount(3));
		System.out.println(c.getMaximumStackDepth());
		int b = c.catalan(0);
		System.out.println(b);
		int d = c.catalan(1);
		System.out.println(d);
	}

}
