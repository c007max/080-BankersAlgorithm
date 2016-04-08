import java.util.Arrays;
public class bankers
{
    private int procK	,resK;
    private int need[][]	,allocate[][]	,max[][]	,avail[] ;
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public bankers	(int alloc0[][]
    		,int max0[][]
    		)
    {
    	this.allocate	= alloc0.clone(); 
    	this.max	= max0.clone(); 
    	this.procK	= need.length ;		// number of processes; rows in need matrix
    	this.resK	= need[0].length ;	// number of resources; cols in need matrix
    }
    
    private void calc_need()
    {
       for(int row=0; row < procK; row++)
       {
    	  for(int col=0; col < resK; col++)  //calculating need matrix by cells
    		  need[row][col]	= max[row][col]	- allocate[row][col];  
        }
    }
 
    private boolean check(int i0)
    {
       //checking if all resources for ith process can be allocated
    	
       for(int ii=0; ii < procK ; ii++) 
       {
    	   if (avail[ii]	< need [i0][ii])
    		   return false ;
       }
    return true;
    }

    public void isSafe(){
       this.calc_need();
       
       boolean done[]	= new boolean[];
       int j=0;

       while(j < resK)
       {  //until all process allocated
    	   boolean allocated=false;
    	   for(int ii=0; ii < resK; ii++)
    		   if(!done[ii] && check(ii))
    		   {  //trying to allocate
    			   for(int kk=0; kk < procK; kk++)
    				   avail[kk] = avail[kk]	- need[ii][kk]	+ max[ii][kk];
    			   System.out.println("Allocated process : "+ii);
    			   allocated=done[ii]=true;
    			   j++;
    		   }
    	   if(!allocated) 
    		   break;  //if no allocation
       }

       if(j==resK)  //if all processes are allocated
    	   System.out.println("\nSafely allocated");
       else
    	   System.out.println("All proceess cant be allocated safely");
    }
//
//    public static void main(String[] args) {
//    	new bankers().isSafe();
//    }
}