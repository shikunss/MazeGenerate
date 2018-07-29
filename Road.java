
public class Road {
	private Cell startcell;
	private Cell endcell;

	public Road(Cell startcell, Cell endcell) {
		super();
		this.startcell = startcell;
		this.endcell = endcell;
	}

	public boolean islt(Cell startcell, Cell endcell) {
		int sx = startcell.getX();
		int sy = startcell.getY();
		int ex = endcell.getX();
		int ey = endcell.getY();
		return (Math.abs(sy - ey) == 0 || Math.abs(sx - ex) == 0 && (Math.abs(sx - ex) + Math.abs(sy - ey)) == 1);
	}

	public Integer[] cal(Cell startcell, Cell endcell) {
		Integer[] aa = new Integer[2];
		int sx = startcell.getX();
		int sy = startcell.getY();
		int ex = endcell.getX();
		int ey = endcell.getY();
		aa[0] = (sx * 2 + 1 + ex * 2 + 1) / 2;
		aa[1] = (sy * 2 + 1 + ey * 2 + 1) / 2;
		return aa;

	}

	@Override
	public String toString() {
		return "Road [startcell=" + startcell + ", endcell=" + endcell + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endcell == null) ? 0 : endcell.hashCode());
		result = prime * result + ((startcell == null) ? 0 : startcell.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Road other = (Road) obj;
		if (endcell == null) {
			if (other.endcell != null)
				return false;
		} else if (!endcell.equals(other.endcell))
			return false;
		if (startcell == null) {
			if (other.startcell != null)
				return false;
		} else if (!startcell.equals(other.startcell))
			return false;
		return true;
	}

	public Cell getStartcell() {
		return startcell;
	}

	public void setStartcell(Cell startcell) {
		this.startcell = startcell;
	}

	public Cell getEndcell() {
		return endcell;
	}

	public void setEndcell(Cell endcell) {
		this.endcell = endcell;
	}

}
