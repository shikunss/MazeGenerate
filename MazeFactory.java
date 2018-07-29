import java.util.ArrayList;

public class MazeFactory {
	private static final int INPUT_ERROR = -999999;
	private static final String REG_SPE = ";";
	private static final String REG_BLANK = " ";
	private static final String REG_COMMA = ",";
	// public static String command_m = "";

	public static Maze Create(String command) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println(command);
		// command_m = command;
		String[] a = command.split("\n");
		String[] b = a[0].trim().split(" ");
		int n = isStr2Numvalid(b[0]);
		int m = isStr2Numvalid(b[1]);
		String aq[][] = new String[2 + n + (n - 1)][2 + m + (m - 1)];
		for (int i = 0; i < 2 + n + (n - 1); i++)
			for (int j = 0; j < 2 + m + (m - 1); j++) {
				aq[i][j] = "[R]";
				if ((i % 2 == 0) || (j % 2 == 0)) {
					aq[i][j] = "[W]";
				}
			}

		String[] strs = a[1].trim().split(REG_SPE);
		if (!isValidroad(a[1].trim()) || !isValidrange(a[1].trim(), a[0].trim())) {
			System.err.println("Incorrect command format.");
		}

		ArrayList lllla = new ArrayList<Integer[]>();
		for (String ra : strs) {
			// System.out.println(ra);
			String[] cellpair = ra.split(REG_BLANK);
			if (cellpair.length != 2) {
			}
			// 报错

			String[] cells = cellpair[0].split(REG_COMMA);
			if (cells.length != 2) {
			}
			// 报错

			int x = Integer.parseInt(cells[0]);
			int y = Integer.parseInt(cells[1]);
			Cell sls = new Cell(x, y);

			String[] cells1 = cellpair[1].split(REG_COMMA);
			if (cells1.length != 2) {
			}
			// 报错

			int x1 = isStr2Numvalid(cells1[0]);
			int y1 = isStr2Numvalid(cells1[1]);
			Cell els = new Cell(x1, y1);

			Road ra1 = new Road(sls, els);

			// System.out.println(ra1);
			if (ra1.islt(sls, els)) {
				Integer[] a1 = ra1.cal(sls, els);
				lllla.add(a1);
			} else {
				System.err.println("Maze format error.");
			}
		}
		int size = lllla.size();

		for (int iqqq = 0; iqqq < size; iqqq++) {

			Object o = lllla.get(iqqq);
			Integer[] a1 = (Integer[]) o;
			// System.out.println(a1[0] + "----------" + a1[1]);

			for (int i = 0; i < 2 + n + (n - 1); i++)
				for (int j = 0; j < 2 + m + (m - 1); j++) {
					// aq[i][j] = "[W]";
					// if ((i % 2 != 0) && (j % 2 != 0)) {
					// aq[i][j] = "[R]";
					// }
					if (i == a1[0] && j == a1[1]) {
						aq[i][j] = "[R]";
					}
				}
		}
		return new Maze(n, m, aq);
	}

	private static boolean isValidrange(String trim, String trim2) throws Throwable {
		boolean res = false;
		ArrayList alisx = new ArrayList<>();
		ArrayList alisy = new ArrayList<>();
		String[] strs = trim.split(REG_SPE);
		for (String ra : strs) {
			// System.out.println(ra);
			String[] cellpair = ra.split(REG_BLANK);
			if (cellpair.length != 2)
				return false;
			for (String cellpairs : cellpair) {
				// System.out.println(cellpairs);
				String[] cells = cellpairs.split(REG_COMMA);
				if (cells.length != 2)
					return false;

				alisx.add(cells[0]);
				alisy.add(cells[1]);

			}
		}
		String[] b = trim2.split(" ");
		int n = isStr2Numvalid(b[0]);
		int m = isStr2Numvalid(b[1]);

		for (int iqqq = 0; iqqq < alisx.size(); iqqq++) {

			Object o = alisx.get(iqqq);
			String a1 = (String) o;
			if (Integer.parseInt(a1) >= n)
				res = false;
		}
		for (int iqqq = 0; iqqq < alisy.size(); iqqq++) {

			Object o = alisy.get(iqqq);
			String a1 = (String) o;
			if (Integer.parseInt(a1) >= m)
				res = false;
		}
		res = true;
		return res;
	}

	private static boolean isValidroad(String road) throws Exception {
		// 分割字符串；
		boolean res = false;
		String[] strs = road.split(REG_SPE);
		for (String ra : strs) {
			// System.out.println(ra);
			String[] cellpair = ra.split(REG_BLANK);
			if (cellpair.length != 2)
				return false;
			for (String cellpairs : cellpair) {
				// System.out.println(cellpairs);
				String[] cells = cellpairs.split(REG_COMMA);
				if (cells.length != 2)
					return false;
				for (String xy : cells) {
					// System.out.println("xy: " + xy);
					if ((isStr2Numvalid(xy) == INPUT_ERROR)) {
						return false;
					}
				}
			}
		}
		res = true;
		return res;
	}

	private static int isStr2Numvalid(String n) throws NumException {
		// 判断有效性,正整数，没有其他非数字字符；
		try {
			int re = Integer.parseInt(n);
			if (re < 0) {
				System.err.println("Number out of range.");
				throw new NumException("Number out of range.");
			}
			return re;
		} catch (NumberFormatException e) {
			System.err.println("Invalid number format.");
			e.printStackTrace();
		}
		return INPUT_ERROR;
	}
}

class NumException extends Exception {
	public NumException(String msg) {
		super(msg);
	}
}
