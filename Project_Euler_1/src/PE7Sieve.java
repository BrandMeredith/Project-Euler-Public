/**Used the seive of eratosthenes. Started with a large array listing the integers to 200,000 and "crossed out" numbers by replacing them with zeros. Used a function to find the index of the first non zero number in the array. 
 * 
 * @author mathcadd
 *
 */
public class PE7Sieve {
    public static void main(String []args){
    	int TOP = 200000;
    	int TOP_COUNT = 10001;
    	int[] intArr = new int[TOP]; // an integer array 
    	int prime = 0; // the variable that will hold the prime values. 
    	int count = 0; // which prime number we're on
    	
    	for (int i=0;i<TOP;i++) // set the values to be the integers from 0 to 99,999
    		intArr[i] = i;
    	
    	intArr[1] = 0; // one (1) is not a prime
    	System.out.println(intArr[0] + " " + intArr[1] + " " + intArr[2]);
    	
    	prime = firstNonzeroIndex(intArr);
    	
    	for (count=0;count<TOP_COUNT+1;count++){
    		System.out.println(prime + " " + count);
    		prime = firstNonzeroIndex(intArr); // eratosthenes tells us the first nonzero is prime
    	
    		intArr[prime]=0;
    		for (int j=0;j<TOP/prime;j++){ // set multiples of prime to zero
    			intArr[j*prime] = 0;
    		}
    	}
    	
    }
    
    public static int firstNonzeroIndex(int[] tempArr){
    	int ind=0; 
    	
    	while (tempArr[ind]==0) ind++;
    	return ind;
    }

}
