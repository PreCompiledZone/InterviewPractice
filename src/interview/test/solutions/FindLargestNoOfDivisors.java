package interview.test.solutions;

/**
 * 
 * @author amol
 *
 */
public class FindLargestNoOfDivisors {

	static int findMaxDivisorCount(int end)
	{
		 int icount; 
		  int imaxDivisors;  
		  int inumwithmax;  
		  imaxDivisors = 1;  
		  inumwithmax = 1;
	  for ( icount = 2;  icount  <= end;  icount ++ ) {
			 int D;  
			 int idivisorCount;  
			  idivisorCount = 0;
		  for ( D = 1;  D <= icount;  D++ ) { 
			if ( icount % D == 0 )
					idivisorCount++;
			  }
			  
			  if (idivisorCount > imaxDivisors) {
				 imaxDivisors = idivisorCount;
				 inumwithmax = icount;
			  }
		  
		  }
	  return imaxDivisors;
	}
	
	public static void main(String[] args) {
		
		int res1 = findMaxDivisorCount(1000);
		System.out.println(res1);
		
	}
	
}
