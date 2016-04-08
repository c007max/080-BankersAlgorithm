import java.util.Collections;
import java.util.LinkedList ;
import java.util.Random ;

public class bankersDriver 
{			
	public static void main(String args[]) 	
	{
		Random random__X	= new Random();
		int QREADY__T = 5 ;	final int mem__T = 256;
		
		LinkedList<PCB> QReady	= new LinkedList<PCB>();	//#0010 Create List QReady
				
		PCB PCB_Ready	; 	//#0040 Create the field: PCB_Ready
		@SuppressWarnings("unused")
		CPU_event ce	= new CPU_event();

		for (int ii = 0; ii < QREADY__T; ii++)
		{
			PCB pcb0 = new PCB();		//#0050 new PCB STATE:New
			pcb0.set_state("Ready");	//#0060 set PCB STATE:Ready
			QReady.add(pcb0) ;			//#0070 Add PCB object onto QReady 
		}
		
		for (PCB loopI : QReady)
			System.out.printf("%s\n"	,loopI.showPCB()) ;
		System.out.println("");
		
		Collections.sort(QReady, new comparator_by_CPU_left());
		
		for (PCB loopI : QReady)
			System.out.printf("@CPUleft\t%s\n"	,loopI.showPCB()) ;		
		System.out.println("");

		Collections.sort(QReady, new comparator_by_memLimit());
		
		for (PCB loopI : QReady)
			System.out.printf("@memLimit\t%s\n"	,loopI.showPCB()) ;		
		System.out.println("");
		
		PCB_Ready	= Collections.max(QReady , new comparator_by_memLimit());
		System.out.printf("@max: %s\n"
				,PCB_Ready.showPCB()
				);

		PCB_Ready	= Collections.min(QReady , new comparator_by_memLimit());
		System.out.printf("@min: %s\n"
				,PCB_Ready.showPCB()
				);			
		
		System.out.println("\t***** Shuffled *****");
		Collections.shuffle(QReady, random__X);
		for (PCB loopI : QReady)
			System.out.printf("%s\n"	,loopI.showPCB()) ;
		
		//	End of Initialization \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\				
	}
}