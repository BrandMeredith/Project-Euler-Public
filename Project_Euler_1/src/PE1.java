
public class PE1 {
	

	     public static void main(String []args){
	        int sum, i;
	        sum=0;
	        System.out.println("How the hell you doing?");
	        for (i=1;i<1000;i++)
	        {
	            if (i%3==0) sum=sum+i;
	            else if (i%5==0) sum=sum+i;
	        }
	        System.out.println(sum);
	     }


}
