import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		List<PlayGround> playground = new ArrayList<PlayGround>();

		int totCount = 0;

		Scanner input = new Scanner(System.in);

		try {

			do {

				System.out
						.println("What actions are to be performed on site management system? Choose:");
				System.out
						.println("1 - if overall snapshot report of sites needed");
				System.out
						.println("2 - if changes are to be made in particular sites");
				int choice = input.nextInt();

				if (choice == 1) {

					if (playground.isEmpty()) {
						System.out.println("Playground does not contain sites");
					}

					else {

						for (PlayGround plgr : playground) {

							if (plgr.site.size() > 0) {

								System.out
										.println("Site "
												+ plgr.toString()
												+ " with capacity "
												+ plgr.ConfigSize
												+ " contains amount of clients "
												+ plgr.specialCount()
												+ " ticket numbers: "
												+ plgr.site.toString()
												+ " with capacity utilization "
												+ plgr.SiteUtil()
												+ " % and QUEUE with length: "
												+ plgr.queue.size()
												+ " containing PENDING clients with TICKETS: "
												+ plgr.queue.toString());

							}

						}

					}

					System.out.println("Total visitor count on all sites from very beginning: "
							+ totCount);

				}

				else if (choice == 2) {

					System.out.println("Please enter unique ticket number: ");

					int ticketNr = input.nextInt();

					System.out
							.println("Please enter to which play ground site would you like to add this client. Choose:");
					System.out
							.println("1-BallPit, 2-Carousel, 3-Double Swings, 4-Slide");

					int PlayGrNr = input.nextInt();

					System.out
							.println("Please choose what action would you like to perform on your selected playground:");
					System.out
							.println("10 - add without posibility to wait in queue");
					System.out
							.println("11 -add with possibility to wait in queue");
					System.out.println("2-remove");
					System.out.println("3-dequeue");

					int action = input.nextInt();

					if (PlayGrNr == 1) {

						System.out
								.println("Please enter size of playground in case of Ball Pit: ");

						int sizePg = input.nextInt();

						if (!(playground.contains(new BallPit(sizePg)))) {

							/*
							 * System.out.println(
							 * "subclass not contained, adding subclass to the list"
							 * );
							 */

							playground.add(new BallPit(sizePg));
						}

						int index = playground.indexOf(new BallPit(sizePg));

						/*
						 * System.out.println(
						 * "Subclass position in superclass list " + index);
						 */

						if (action == 11) {
							playground.get(index).add(ticketNr, true);
							totCount++;
						} else if (action == 10) {
							playground.get(index).add(ticketNr, false);
							totCount++;
						} else if (action == 2)
							playground.get(index).remove(ticketNr);
						else if (action == 3)
							playground.get(index).dequeue();

					} else if (PlayGrNr == 2) {

						System.out
								.println("Please enter size of playground in case of Carousel: ");

						int sizePg = input.nextInt();

						if (!(playground.contains(new Carousel(sizePg)))) {
							playground.add(new Carousel(sizePg));
						}

						int index = playground.indexOf(new Carousel(sizePg));

						if (action == 11) {
							playground.get(index).add(ticketNr, true);
							totCount++;
						} else if (action == 10) {
							playground.get(index).add(ticketNr, false);
							totCount++;
						} else if (action == 2)
							playground.get(index).remove(ticketNr);
						else if (action == 3)
							playground.get(index).dequeue();

					} else if (PlayGrNr == 3) {

						if (!playground.contains(new DoubleSwings())) {
							playground.add(new DoubleSwings());
						}

						int index = playground.indexOf(new DoubleSwings());

						if (action == 11) {
							playground.get(index).add(ticketNr, true);
							totCount++;
						} else if (action == 10) {
							playground.get(index).add(ticketNr, false);
							totCount++;
						} else if (action == 2)
							playground.get(index).remove(ticketNr);
						else if (action == 3)
							playground.get(index).dequeue();

					} else if (PlayGrNr == 4) {

						if (!playground.contains(new Slide())) {
							playground.add(new Slide());
						}

						int index = playground.indexOf(new Slide());

						if (action == 11) {
							playground.get(index).add(ticketNr, true);
							totCount++;
						} else if (action == 10) {
							playground.get(index).add(ticketNr, false);
							totCount++;
						} else if (action == 2)
							playground.get(index).remove(ticketNr);
						else if (action == 3)
							playground.get(index).dequeue();

					} else {
						System.out.println("Incorrect data input");
						for (PlayGround plgr : playground) {
							for (int i = 0; i < plgr.site.size(); i++) {
								System.out.println("Site " + plgr.toString()
										+ " contains tickets: "
										+ plgr.site.get(i));
							}
						}

						System.out.println("Playground list size "
								+ playground.size());

					}

				}

			} while (input.nextLine() != "x");

		} finally {
			input.close();
		}

	}

}
