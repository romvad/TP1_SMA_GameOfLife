
public class CellControler extends Thread {
	
	private static int nbCellsCalculated;
	private static int nbCellsUpdated;
	private GridContent grid;
	
	
	public synchronized void incrNbCellsCalculated() {
		nbCellsCalculated++;
	}
	
	public synchronized void incrNbCellsUpdated() {
		nbCellsUpdated++;
	}
	
	
}
