/**Summation of primes - Problem 10
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * 
 * Find the sum of all the primes below two million.
 * 
 * Here I altered the code from PE7sieve to turn an array of the first intArr 
 * n=TOP integers into an array of prime numbers by changing the composite
 * numbers into zeros (0). Then I summed this array. 
 * 
 * It ended up being very fast after I optimized the firstNonzeroIndex function
 * 
 * @author mathcadd
 *
 */
public class PE10 {
	public static final int TOP = 2000000;
	
    public static void main(String []args){
    	int[] intArr = new int[TOP+1]; // an integer array that will be from 0 to TOP
    	int prime = 0; // the variable that will hold the prime values and the current location. 
    	long sum = 0; // will be used to sum the elts of the array intArr (very big)
    	
    	for (int i=0;i<=TOP;i++) // set the values to be the integers from 0 to TOP
    		intArr[i] = i;
    	
    	intArr[1] = 0; // one (1) is not a prime
    	
    	prime = 2; // the first prime
    	
    	// Replace all the composite ints in intArr with zeros (0)
    	while (prime<TOP-1){
    		
    		// Set multiples of "prime" to zero (0)
    		for (int j=2;j<=TOP/prime;j++){ 
    			intArr[j*prime] = 0;
    		}
    		
    		// eratosthenes tells us the first nonzero is prime
    		prime = firstNonzeroIndex(intArr,prime+1); 
    		
    	}
 
    	// Sum the array of primes
    	for (int i : intArr)
    	    sum += i;
    	
    	// Output the sum
    	System.out.println("The sum is " + sum);
    	
    }
    
    // Looks for the first nonzero index in an array "tempArr" beginning with index "start"
    public static int firstNonzeroIndex(int[] tempArr, int start){
    	int ind=0; 
    	
    	for (ind=start;ind<TOP;ind++){
    		if (tempArr[ind]!=0) return ind;
    	}
    	return ind;
    }

}
