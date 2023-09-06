package Main;

import java.util.Comparator;

public class IntervallComperator implements Comparator<Intervall> {
	

	@Override
	public int compare(Intervall o1, Intervall o2) {
		if(o1.getBegin() < o2.getBegin()) {
			return -1;
		}else if(o1.getBegin() > o2.getBegin()) {
			return 1;
		}
		return 0;
	}
	

}
