
public class Game {
	
	public static void main(String[] args) {
		GridContent grid=new GridContent(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
		CellsControler controler=new CellsControler(grid,Integer.parseInt(args[2]));
		
		controler.start();
	}

}
