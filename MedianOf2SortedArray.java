package leetcode2;

public class MedianOf2SortedArray {

	public static void main(String[] args) {
/*Test cases:
		int A[]={1,2};
        int B[]={3};

		int A[]={1,3};
		int B[]={2};
		
		int A[]={100001};
        int B[]={100000};

*/

		int A[]={1,2,3, 5,7};
		int B[]={4, 6};
		System.out.println(findMedianSortedArrays(B , A));
	}
	
	static double findMedian(int A[], int B[], int l, int r) {
		int nA=A.length;
		int nB=B.length;
		int i = (l+r)/2;
		int j = ((nA+nB)/2)- i-1;
		System.out.println("i is: "+ i +"; j is: "+ j);
		
		if(j<0 && l==r){
			if ( (nA+nB)%2 == 1 ) 
				  return Math.min(A[i], B[0]);
			else
			    return((Math.min(A[i], B[0])+A[i-1])/2.0);
		}	
		if (l>r || j<0 || j>=nB || i>=nA) 
			return findMedian(B, A, Math.max(0, (nA+nB)/2-nA), Math.min(nB, (nA+nB)/2));

		if ( A[i] < B[j])
			return findMedian(A, B, i+1, r);
		else if (j<nB-1 && A[i] > B[j+1]) 
			return findMedian(A, B, l, i-1);
		else {
		  if ( (nA+nB)%2 == 1 ){ 
			  return A[i];
		  }else{//even numbers
			  if(j>=0){
			     if (i>0 )
				    return (A[i]+Math.max(B[j], A[i-1]))/2.0;
			     else 
				   return (A[i]+B[j])/2.0;
			  }else{//j<0
				  return((A[i]+A[i-1])/2.0);
				  
			  }
		  }
		}
	}

	static	double findMedianSortedArrays(int A[],int B[]) {
		int nA=A.length;
		int nB=B.length;
		if(A.length==0)
			return getMedian(B);
		else if(B.length==0) 
		    return getMedian(A);

		if(A.length>B.length)
			   //return findMedian(A, B, 0, A.length-1);
		    return findMedian(A, B, Math.max(0, (nA+nB)/2-nB), Math.min(nA, (nA+nB)/2));
	    else
	           //return findMedian(B, A, 0, B.length-1);
	        return findMedian(B, A, Math.max(0, (nA+nB)/2-nA), Math.min(nB, (nA+nB)/2));

	}

	 static double getMedian(int c[]){
			
		 if (c.length==1) return (double)c[0];
		 
		 if(c.length %2 ==1)
		 {
			 return c[c.length/2];
		 }else{
			 int tmp = c[c.length/2-1]+c[c.length/2];
			 return (double)(tmp/2.0);
		 }
		 
	 }
}
