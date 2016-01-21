import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PlayGround {

	public int ConfigSize;

	private int count;

	PlayGround(int size) {

		this.ConfigSize = size;

	}

	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if (!(other instanceof PlayGround || other == null)) {
			return false;
		}
		PlayGround pg = (PlayGround) other;
		return pg.ConfigSize == this.ConfigSize
				&& pg.toString() == this.toString();
	}

	public int hashCode() {
		return ConfigSize;
	}

	List<Integer> site = new ArrayList<Integer>();

	Queue<Integer> queue = new LinkedList<Integer>();

	void add(int ticketNumber, boolean wait) {

		if (site.size() < ConfigSize && queue.size() == 0) {

			site.add(ticketNumber);

			System.out.println("ADDED to site " + this.toString()
					+ " with CAPACITY " + this.ConfigSize + " TICKET: "
					+ ticketNumber);

			count++;
		}

		else {

			if (wait) {
				queue.add(ticketNumber);
				System.out.println("NOT ADDED to site " + this.toString()
						+ " with CAPACITY " + this.ConfigSize
						+ " ; ADDED to QUEUE with LENGTH: " + queue.size()
						+ " TICKET: " + ticketNumber);
			}

			else
				System.out.println("NOT ADDED to site; " + this.toString()
						+ " with CAPACITY " + this.ConfigSize
						+ " ; NOT ADDED to QUEUE, REASON: REFUSE, TICKET: "
						+ ticketNumber);

		}

	}

	void remove(int ticketNumber) {

		for (int i = 0; i < site.size(); i++) {
			if (site.get(i) == ticketNumber) {

				site.remove(i);

				System.out.println("REMOVED from SITE " + this.toString()
						+ " with CAPACITY " + this.ConfigSize + " position "
						+ i + " SITE SIZE " + site.size() + " TICKET: "
						+ ticketNumber);
				count--;

			} else if (site.get(i) != ticketNumber) {

				System.out.println("SITE " + this.toString()
						+ " with CAPACITY " + this.ConfigSize
						+ " does NOT CONTAIN TICKET " + ticketNumber);
			}

		}

		if (queue.size() > 0 && site.size() < ConfigSize) {

			int pendingTicketNumber = queue.remove();

			site.add(pendingTicketNumber);

			System.out.println("ADDED to SITE " + this.toString()
					+ " with CAPACITY " + this.ConfigSize
					+ " ; REMOVED from QUEUE; QUEUE SIZE " + queue.size()
					+ " SITE SIZE " + site.size() + " TICKET: "
					+ pendingTicketNumber);

			count++;
		}

		if (site.size() == 0 && queue.size() == 0)
			System.out.println("SITE EMPTY");

	}

	void dequeue() {

		if (queue.size() > 0) {

			int dropTicketNumber = queue.remove();

			System.out.println("NOT ADDED to SITE " + this.toString()
					+ " with size " + this.ConfigSize
					+ " ; REMOVED from QUEUE; QUEUE SIZE " + queue.size()
					+ " SITE SIZE " + site.size() + " TICKET: "
					+ dropTicketNumber
					+ " , REASON: VOLUNTARY DROPPED OUT FROM QUEUE");
		}

		System.out.println("There is NO QUEUE on SITE " + this.toString()
				+ " with size " + this.ConfigSize);

	}

	float SiteUtil() {

		float siteSize = (float) site.size();

		float UtilPerc = (siteSize / ConfigSize) * 100;

		return UtilPerc;

	}

	int specialCount() {

		return count;

	}

	public String toString() {

		return this.getClass().getName();

	}

}
