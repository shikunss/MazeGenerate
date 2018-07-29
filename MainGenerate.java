
/*
 * 1、n*m 生成 (2+n+(n-1)) * (2+m+(m-1)) 的矩阵初始化 都是W; 2、在 (2+n+(n-1)) * (2+m+(m-1))
 * 的矩阵 中 填上 n*m 个R;这里会有两种坐标系一个是cell 的 n*m 一个是 全图的(2+n+(n-1)) * (2+m+(m-1)) 3、读取
 * Road ,如果cell x坐标相同，在大坐标系中x就取cell x大坐标， y取start和end 的和/2;
 * 
 * 
 */

public class MainGenerate {

	public static void main(String[] args) throws Throwable {

		// TODO Auto-generated constructor stub
		/*
		 * Scanner input = new Scanner(System.in); String n = input.next(); int ni =
		 * isStr2Numvalid(n); System.out.println(ni); String m = input.next(); int mi =
		 * isStr2Numvalid(m); System.out.println(mi); input.nextLine(); String road =
		 * input.nextLine();
		 * System.out.println(!isValidroad(road)?"Incorrect command format.":road);
		 * input.close();
		 */

		String command = "3 4" + "\n" + "0,1 0,2;0,0 1,0;0,1 1,1;0,2 1,2;1,0 1,1;1,1 1,2;1,1 2,1;1,2 2,2;2,0 2,1"
				+ "\n";
		Maze maze = MazeFactory.Create(command);

		/*
		 * for (int i = 0; i < 2 + n + (n - 1); i++) { System.out.print("no:" + (i + 1)
		 * + "   "); for (int j = 0; j < 2 + m + (m - 1); j++) System.out.print(aq[i][j]
		 * + " "); System.out.println(""); }
		 */

		// 推理 0,1 0,2 --> 1,4 0,0 1,0 --> 2,1 0,1 1,1 --> 2,3 0,2 1,2 --> 2,5 1,0 1,1
		// --> 3,2
		// 0,1 -> 1,3 0,2 -> 1,5 1+1/2,3+5/2 (但是必须是相差为1的2-1才是road)
		System.out.println();
		String mazeText = maze.Render();
		System.out.println(mazeText);
	}
	/*
	 * 连通性错误，即是1、 x1,y1 x2,y2; X1==X2与Y1==Y2 必须满足一个;
	 * 2、还要考虑边界条件，地图的边界是否允许最上和最下，最左和最右的相连，看题的意思是不想连的；
	 * 3、与第二个有所重复，意思是不同的坐标相减必须为一；y2-y1 或者 x2-x1 的绝对值是为1 的，看题的意思road长度为1； if
	 * ((x1==x2) or (y1==y2)){ 赋值给 cell } return false;
	 * 
	 */

}
