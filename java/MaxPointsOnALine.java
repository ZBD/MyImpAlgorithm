import java.util.*;



class Point {
	int x;
	int y;
	Point() { x = 0; y = 0; }
	Point(int a, int b) { x = a; y = b; }
}

public class MaxPointsOnALine {


	public int maxPoints(Point[] points) {
		Arrays.sort(points, new PointsComparator());
		ArrayList<MyPoint> al = new ArrayList<MyPoint>();
		Point prev = null;
		int num = 1;
		for (int i=0; i<points.length; i++) {
			if (prev != null && points[i].x == prev.x && points[i].y == prev.y) {
				al.get(al.size()-1).num++;
				continue;
			}
			prev = points[i];
			al.add(new MyPoint(points[i]));
		}

		if (al.size() < 1) {
			return 0;
		}
		else if (al.size() == 1) {
			return al.get(0).num;
		}
		else if (al.size() == 2) {
			return al.get(0).num + al.get(1).num;
		}

		int max = 0;
		for (int i=0; i<(al.size()-2); i++) {
			for (int j=i+1; j<al.size()-1; j++) {
				num = al.get(i).num + al.get(j).num;
				int dx = (al.get(j).x - al.get(i).x);
				int dy = (al.get(j).y - al.get(i).y);
				for (int k=j+1; k<al.size(); k++) {
					int dx2 = (al.get(k).x - al.get(j).x);
					int dy2 = al.get(k).y - al.get(j).y;
					if (dx == 0) {
						num += dx2 == 0 ? al.get(k).num : 0;
					}
					else if (dy == 0) {
						num += dy2 == 0 ? al.get(k).num : 0;
					}
					else if (dx*dy2 == dx2*dy) {
						num += al.get(k).num;
					}
				}
				if (max < num) {
					max = num;
				}
			}

		}
		return max;
	}

	class MyPoint extends Point{
		int num;
		MyPoint() {x = 0; y = 0; num = 1;} 
		MyPoint(int a, int b) {x = a; y = b; num = 1;}
		MyPoint(int a, int b, int c) {x = a; y = b; num = c;}
		MyPoint(Point p) {x = p.x; y = p.y; num = 1;}
		MyPoint(Point p, int c) {x = p.x; y = p.y; num = c;}
	}

	class PointsComparator implements Comparator<Point> {

		public int compare(Point p1, Point p2) {
			if (p1.x < p2.x) {
				return -1;
			}
			else if (p1.x > p2.x) {
				return 1;
			}
			else if (p1.y < p2.y) {
				return -1;
			}
			else if (p1.y > p2.y) {
				return 1;
			}
			return 0;
		}
	}
}

