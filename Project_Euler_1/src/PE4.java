
public class PE4 {
    public static void main(String []args){
    	int[] intArr = new int[100000];
    	int[] primeArr = new int[10001];
    	int[] tempArr = new int[100000];
    	int count=0;
    	
    	for (int i=0;i<100000;i++)
    		intArr[i] = i+1;
    	System.out.println(intArr[35000]);
    			
    	for (int j=0;j<100000 && count<10001;j++)
    	{
    		
    		primeArr[count]=intArr[0];
    		count++;
    		if ((count%1000)==0 ) System.out.println(count + " " + primeArr[count-2]);
    		System.arraycopy(intArr, 0, intArr,0, 100000-j);
    		intArr = new int[100000-j-1];
    		System.arraycopy(tempArr, 1, intArr, 0, 100000-j-1);
    	}
    	
    	System.out.println(primeArr[50]);
    	
    }

}
