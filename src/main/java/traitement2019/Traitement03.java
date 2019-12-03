package traitement2019;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import utils.ClotureListener;
import utils.LigneListener;

public class Traitement03 implements LigneListener, ClotureListener {

	private Integer manhattanDistance = null;
	private int minSumSteps;

	List<List<Point>> liste2Chemins = new ArrayList<>();
	Set<Point> croisements = new HashSet<>();

	public int getManhattanDistance() {
		return manhattanDistance.intValue();
	}

	public int getMinSumSteps() {
		return minSumSteps;
	}

	@Override
	public void ligneLue(String ligne) {
		List<Point> chemin = new ArrayList<>();
		liste2Chemins.add(chemin);
		String[] input = ligne.split(",");
		for (String deplacement : input) {
			int nbDeplacements = Integer.valueOf(deplacement.substring(1));
			if (deplacement.startsWith("U")) {
				for (int i = 1; i <= nbDeplacements; i++) {
					Point lastPosition = new Point(0, 0);
					if (chemin.size() > 0) {
						lastPosition = chemin.get(chemin.size() - 1);
					}
					Point newPoint = new Point(lastPosition.x, lastPosition.y + 1);
					chemin.add(newPoint);
				}
			} else if (deplacement.startsWith("R")) {
				for (int i = 1; i <= nbDeplacements; i++) {
					Point lastPosition = new Point(0, 0);
					if (chemin.size() > 0) {
						lastPosition = chemin.get(chemin.size() - 1);
					}
					Point newPoint = new Point(lastPosition.x + 1, lastPosition.y);
					chemin.add(newPoint);
				}
			} else if (deplacement.startsWith("D")) {
				for (int i = 1; i <= nbDeplacements; i++) {
					Point lastPosition = new Point(0, 0);
					if (chemin.size() > 0) {
						lastPosition = chemin.get(chemin.size() - 1);
					}
					Point newPoint = new Point(lastPosition.x, lastPosition.y - 1);
					chemin.add(newPoint);
				}
			} else if (deplacement.startsWith("L")) {
				for (int i = 1; i <= nbDeplacements; i++) {
					Point lastPosition = new Point(0, 0);
					if (chemin.size() > 0) {
						lastPosition = chemin.get(chemin.size() - 1);
					}
					Point newPoint = new Point(lastPosition.x - 1, lastPosition.y);
					chemin.add(newPoint);
				}
			}
		}
	}

	@Override
	public void fichierFerme() {
		List<Point> chemin1 = liste2Chemins.get(0);
		List<Point> chemin2 = liste2Chemins.get(1);
		for (Point point : chemin1) {
			if (chemin2.contains(point)) {
				croisements.add(point);
			}
		}
		for (Point point : croisements) {
			if (manhattanDistance == null) {
				manhattanDistance = point.getManhattanDistance();
			} else if (point.getManhattanDistance() < manhattanDistance.intValue()) {
				manhattanDistance = point.getManhattanDistance();
			}
			// partie 2
			int sumSteps = chemin1.indexOf(point) + chemin2.indexOf(point) + 2;
			if (minSumSteps == 0) {
				minSumSteps = sumSteps;
			} else if (sumSteps < minSumSteps) {
				minSumSteps = sumSteps;
			}

		}
	}

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getManhattanDistance() {
			return Math.abs(x) + Math.abs(y);
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
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
			Point other = (Point) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

	}

}
