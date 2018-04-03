
public class Cell extends Thread {
	private final int abscisse;
	private final int ordonnee;
	private int currentState;
	private int nextState;
	private GridContent grid;
	private CellsControler controler;
	
	
	
	public Cell(int abscisse, int ordonnee, int currentState,GridContent grid, CellsControler controler) {
		super();
		this.abscisse = abscisse;
		this.ordonnee = ordonnee;
		this.currentState = currentState;
		this.grid= grid;
		this.controler=controler;
		//this.nextState=0;
	}
	public int getAbscisse() {
		return abscisse;
	}
	
	public int getOrdonnee() {
		return ordonnee;
	}
	
	public int getCurrentState() {
		return currentState;
	}
	public void setCurrentState(int state) {
		this.currentState = state;
	}
	
	public int getNextState() {
		return nextState;
	}
	public void setNextState(int nextState) {
		this.nextState = nextState;
	}
	
	public void nextStateCalculation() {
		boolean noChange=false;	
		//System.out.println("nb voisins vivants ("+abscisse+","+ordonnee+") "+grid.getNeighboursAlive(abscisse, ordonnee));
		switch (grid.getNeighboursAlive(abscisse, ordonnee)) {
		
		case 2: 
			setNextState(getCurrentState());
			noChange=true;
			break;
		case 3: setNextState(1);
		break;
		default: setNextState(0);
			
		}
		controler.incrNbCellsCalculated(noChange);
		
	}
	
	public void updateState() {
		this.currentState=getNextState();
		controler.incrNbCellsUpdated();
	}
	
	public synchronized void resumeCell() {
		notify();
	}
	
	public synchronized void stopCell() {
		notify(); // To be able to call the interrupt() method
		interrupt();
	}
	
	public void startCell() {
		start();
		
	}
	
	public synchronized void pauseCell() {
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//super.run();
		
		while (!isInterrupted()) { // A VERIFIER
			nextStateCalculation();
			
			pauseCell(); // We wait the signal of the controler before setting the calculated state: the controller synchronize all the calculations in order to prvent cell from calculating on neighbours' state at the next iteration, supposing to make the calculation wrong
			
			updateState();
			
			pauseCell();
			
			
		}
	}
	
	
	
	
	
}
