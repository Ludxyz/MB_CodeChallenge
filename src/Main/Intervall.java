package Main;

public class Intervall {

	private int begin;
	private int end;
	
	public Intervall(int begin, int end) {
		
		this.begin = begin;
		this.end = end;

	}

	public Intervall(String input) {

		String[] intervall = input.split(",");

		try {

			this.begin = Integer.parseInt(intervall[0]);
			this.end = Integer.parseInt(intervall[1]);
			
			if(begin > end) {
				throw new IllegalArgumentException("values of Intervall is in wrong order: [" +begin+ "," + end + "]" );
			}

		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
			throw nfe;
		}

	}
	
	@Override
	public String toString() {

		String result = "[" + begin + "," + end + "]";

		
		return result;
	}

	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

}
