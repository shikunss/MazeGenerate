public class Maze {

	private int n;
	private int m;
	private String zb[][];

	public String[][] getZb() {
		return zb;
	}

	public void setZb(String[][] zb) {
		this.zb = zb;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public Maze(int n, int m) {
		super();
		this.n = n;
		this.m = m;
	}

	public Maze(int n, int m, String[][] zb) {
		super();
		this.n = n;
		this.m = m;
		this.zb = zb;
	}

	@Override
	public String toString() {
		return "Maze [n=" + n + ", m=" + m + "]";
	}

	public String Render() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 2 + n + (n - 1); i++) {

			// System.out.print("no:" + (i + 1) + " ");
			for (int j = 0; j < 2 + m + (m - 1); j++)
				sb.append(zb[i][j] + " ");
			sb.append("\n");
		}
		return sb.toString();
	}

}
