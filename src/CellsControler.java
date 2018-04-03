
public class CellsControler extends Thread {
	
	private static int nbCellsCalculated=0;
	private static int nbCellsUpdated=0;
	private GridContent gridContent;
	private int nbMaxIterations;
	private int nbOfCellsUnchanged=0;
	
	
	
	
	public CellsControler(GridContent gridContent, int nbMaxIterations) {
		super();
		this.gridContent = gridContent;
		this.nbMaxIterations = nbMaxIterations;
	}

	public synchronized void incrNbCellsCalculated(boolean cellStateNotChanged) {
		nbCellsCalculated++;
		if(cellStateNotChanged) nbOfCellsUnchanged++;
		
		if(nbCellsCalculated==gridContent.getNumberOfCells()) {
			nbCellsCalculated=0;
			
			notify();
		}
	}
	
	public synchronized void incrNbCellsUpdated() {
		nbCellsUpdated++;
		
		if(nbCellsUpdated==gridContent.getNumberOfCells()) {
			nbCellsUpdated=0;
			
			notify();
		}
	}
	
	public void printGrid() {
		
		for(int j=gridContent.getHeight()-1;j>=0;j--) {
			String line="";
			for (int i=0;i<gridContent.getWidth();i++) {
				//line+=gridContent.getGrid()[i][j];
				line+=gridContent.getCellWithCoordinates(i, j).getCurrentState();
			}
			System.out.println(line);
		}
	}
	
	public void printMessageCellsAllDead() {
		System.out.println("Arrêt du jeu: Toutes les cellules sont mortes");
	}
	
	
	
	public void controlOnCells(String option) {
		Cell [][] cellsArray=gridContent.getGrid();
		for (int i=0;i<gridContent.width;i++) {
			for(int j=0;j<gridContent.height;j++) {
				
				switch(option) {
					case "resume":cellsArray[i][j].resumeCell();
					break;
					case "stop":cellsArray[i][j].stopCell();
					break;
					case "start":cellsArray[i][j].startCell();
					break;
					default:;
				}
				
			}
		}
	}
	
	private synchronized void pauseController() {
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	@Override
	public void run() {
		//super.run();
		//Launch of the initialization of the grid
		gridContent.initGrid(this);
		System.out.println("Etat initial de la grille:");
		printGrid();
		//Start all the cell threads
		controlOnCells("start");
		
		for(int i=1;i<=nbMaxIterations;i++) {
			pauseController();
			controlOnCells("resume");
			pauseController();
			
			System.out.println("Etat de la grille à l'itération "+i+"/"+nbMaxIterations);
			printGrid();
			
			if(gridContent.areAlltheCellsDead()) {
				System.out.println("Les itérations sont arrêtées: toutes les cellules sont mortes");
				controlOnCells("stop");
				break;
			}else if(nbOfCellsUnchanged==gridContent.getNumberOfCells()) {
				System.out.println("Les itérations sont arrêtées: l'état de la grille ne varira plus");
				controlOnCells("stop");
				break;
			}else if(i==nbMaxIterations) {
				System.out.println("Les itérations sont arrêtées: le nombre d'itérations demandé est atteint");
				controlOnCells("stop");
				break;
			}else {
				nbOfCellsUnchanged=0;
				controlOnCells("resume"); 
			}
				
			}
			
			
			
			
		}
	}
	

