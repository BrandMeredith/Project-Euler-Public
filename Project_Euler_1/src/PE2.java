
public class PE2 {

	     public static void main(String []args){
	        int sum,a,b,c; 
	        a=1;
	        b=2;
	        c=3;
	        sum=2;
	        
	        while(c<4000000)
	        {
	            if (c%2==0) sum=sum+c;
	            a=b;
	            b=c;
	            c=a+b;
	        }
	        System.out.println(sum);
	     }


}
