//	http://www.java2s.com/Tutorial/Java/0140__Collections/LinkedListClass.htm

import java.util.Comparator;
import java.util.Random ;

public class PCB implements Comparator<PCB>
{
	private String 	PCB_state;
	private int		PCB_ID ;
	private String	pgmCounter;
	private int		CPU_used;
	private int		CPU_max;
	private int		CPU_left;
	private int		timeWaiting;
	private int		memBase ;
	private int		memLimit ;
	private	int		CPU_res ;	// CPU resource max for deadlock detection
	private int		mem_res ;	// memory resource max for deadlock detection
	private int		IO_res ;	// I/O resource max for deadlock detection
	
	private static int	PCB__K;
	@SuppressWarnings("unused")
	private Random random__X ;
		
	// constructor methods
		
	public PCB ()
	{
		Random random__X	= new Random();

		PCB__K		+= 1 ;	//=====>	Increment the static variable for Process ID
		PCB_state	= "Ready" ;
		PCB_ID		= PCB__K ; 
		pgmCounter	= "" ;
		CPU_used	= 0 ;
		CPU_max		= random__X.nextInt(50) + 1 ;	// Assign max to be between 1:50
		CPU_left	= CPU_max ;
		timeWaiting	= 0 ;
		memBase	= 0 ;
		memLimit	= random__X.nextInt(25) + 26 ;	// Assign memory needed between 25:50
		
		CPU_res		= random__X.nextInt(2)	+ 1 ;	// Assign CPU resource max between 1 and 2
		mem_res		= random__X.nextInt(5)	+ 2 ;	// Assign memory resource max between 2 and 6
		IO_res		= random__X.nextInt(3)	+ 1 ;	// Assign I/O resource max between 1 and 4
	}	
	
	// constructor for memory tracking
			
	public PCB (int m0)
	{
		PCB__K		= 0 ;	
		PCB_state	= "@" ;
		PCB_ID		= 0 ; 
		pgmCounter	= "" ;
		CPU_used	= 0 ;
		CPU_max		= 0 ; 
		CPU_left	= 0 ; 
		timeWaiting	= 0 ;
		memBase	= 0 ;
		memLimit	= m0 ;
		CPU_res	= 0 ;
		mem_res	= 0 ;
		IO_res	= 0 ;
	}	
	
	
	public String showPCB()
	{
		return "state: " + PCB_state
			+ "\tID: "	+ Integer.toString(PCB_ID)
//			+ "\tK: "	+ pgmCounter
//			+ "\tCPU max: "	+ Integer.toString(CPU_max)
//			+ "\tCPU used: "	+ Integer.toString(CPU_used)	
//			+ "\tCPU left: "	+ Integer.toString(CPU_left)
//			+ "\tWait: "	+ Integer.toString(timeWaiting)
//			+ "\tmemBase: "	+ Integer.toString(memBase)
//			+ "\tmemLimit: "+ Integer.toString(memLimit)
			+ "\tCPU res: " + Integer.toString(CPU_res)
			+ "\tmem res: " + Integer.toString(mem_res)
			+ "\tIO res: "	+ Integer.toString(IO_res)
			;
	}

	public int compareTo (PCB pcb0) 
	{
		int mem0	= pcb0.get_memBase();
		return this.memBase - mem0 ;
	}	
	
	//	set methods
	
	public String get_state()
	{
		return PCB_state;
	}
	
	public int get_ID()
	{
		return PCB_ID;
	}
	
	public int get_CPU_used()
	{
		return CPU_used;
	}
	
	public int get_CPU_max()
	{
		return CPU_max;
	}	
	
	public int get_CPU_left()
	{
		return CPU_left;
	}	
	
	public String get_pgmCounter()
	{
		return pgmCounter;
	}	
	
	public int get_timeWaiting()
	{
		return timeWaiting;
	}	
	
	public int get_memBase()
	{
		return memBase;
	}	
	
	public int get_Limit()
	{
		return memLimit;
	}	
	
	public int get_CPU_res()
	{
		return CPU_res;
	}		
	
	public int get_mem_res()
	{
		return mem_res;
	}		
	
	public int get_IO_res()
	{
		return IO_res;
	}	
	
	// Set methods , void returns no value

	
	public void set_PCB_ID (int id0)
	{
		PCB_ID	= id0 ;
	}
	
	public void set_state(String state0)
	{
		PCB_state	= state0 ;
	}
	
	public void set_CPU_used(int CPU0)
	{
		CPU_used	= CPU0 ;
	}

//	public void set_CPU_left()
//	{
//		CPU_left	= CPU_max - CPU_used ;
//	}
	
	public void add_CPU_used(int c0)
	{
		CPU_used	+= c0 ;
		CPU_left	= CPU_max	- CPU_used;
	}
	
	public void set_CPU_max(int CPU0)
	{
		CPU_max	= CPU0 ;
	}
	
	public void set_pgmCounter(String pgmCounter0)
	{
		pgmCounter	= pgmCounter0 ;
	}
	
	public void set_timeWaiting(int timeWaiting0)
	{
		timeWaiting	= timeWaiting0 ;
	}
	
	public void add_timeWaiting(int t0)
	{
		timeWaiting	+= t0 ;
	}
	
	public void set_memBase (int m0)
	{
		memBase = m0 ;
	}
	
	public void set_memLimit (int m0)
	{
		memLimit = m0 ;
	}
	
	public void set_CPU_res (int i0)
	{
		CPU_res = i0 ;
	}	
	public void set_mem_res (int i0)
	{
		mem_res = i0 ;
	}	
	public void set_IO_res (int i0)
	{
		IO_res = i0 ;
	}
	@Override
	public int compare(PCB arg0, PCB arg1) {
		// TODO Auto-generated method stub
		return 0;
	}
}