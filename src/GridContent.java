
public class GridContent {
	private Cell[][] grid;
	int height;
	int width;
	
	public GridContent(int height, int width) {
		
		this.grid = new Cell[width][height];
		this.height = height;
		this.width = width;
		//initGrid();
	}
	
	
	public Cell[][] getGrid() {
		return grid;
	}
	
	public void initGrid(CellsControler controler) {
		for(int i=0;i<width;i++) {
			for(int j=0;j<height;j++) {
				grid[i][j]=new Cell(i,j,setRandomInitialStateCell(),this,controler);
			}
		}
		System.out.println("init fini");
	}
	
	public int setRandomInitialStateCell() {
		double rand=Math.random();
		//System.out.println("rand "+rand);
		return rand<0.5? 0:1;
	}


	public void setGrid(Cell[][] grid) {
		this.grid = grid;
	}
	
	public int getNumberOfCells() {
		return height*width;
	}


	public Cell getCellWithCoordinates(int i, int j) {
		if(i<0 || i>=width || j<0 || j>=height) {
			return null;
		}
		return grid[i][j];
	}
	
	public void updateCell(int i, int j) {
		
	}
	public int getNeighboursAlive(int i,int j) {
		/*if(i==0) {
			if(j==0) {
				return grid[1][0].getState()+grid[1][1].getState()+grid[0][1].getState();
			}else if(j==height-1) {
				return grid[1][j].getState()+grid[1][j-1].getState()+grid[0][j-1].getState();
			}else {
				return grid[i+1][j].getState()+grid[i+1][j+1].getState()+grid[i+1][j-1].getState()+ grid[i][j+1].getState()+grid[i][j-1].getState();
			}
			
		}else if (i==width-1) {
			if(j==0) {
				return grid[i-1][0].getState()+grid[i-1][1].getState()+grid[i][1].getState();
			}else if(j==height-1) {
				return grid[i-1][j].getState()+grid[i-1][j-1].getState()+grid[i][j-1].getState();
			}else {
				return grid[i-1][j].getState()+grid[i-1][j+1].getState()+grid[i-1][j-1].getState()+ grid[i][j+1].getState()+grid[i][j-1].getState();
			}
		} else {
			if(j==0) {
				return grid[i+1][j].getState()+grid[i-1][j].getState()+grid[i+1][j+1].getState()+ grid[i-1][j+1].getState()+grid[i][j+1].getState();
			}else if(j==height-1) {
				return grid[i+1][j].getState()+grid[i-1][j].getState()+grid[i+1][j-1].getState()+ grid[i-1][j-1].getState()+grid[i][j-1].getState();
			} else {
		}*/
		int result=0;
		
		for(int k=i-1;k<=i+1;k++) {
			for(int l=j-1;l<=j+1;l++) {
				
				if(getCellWithCoordinates(k, l)!=null) {
					if(!(k==i && l==j)) {
					result+=getCellWithCoordinates(k, l).getCurrentState();
				
					}
				}
			}
		}
		return result;
				
	}
	
	public boolean areAlltheCellsDead() {
		
		for(int i=0;i<width;i++) {
			for(int j=0;j<height;j++) {
				if(grid[i][j].getCurrentState()==1) {
					return false;
				}
			}
		}
		return true;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	
	

}
