package fp;
/**********************************************
Workshop # 10
Course: JAC444 - Semester Winter 2023
Last Name: Siu
First Name: Chun Kit Jacky
ID: 134663186
Section: NAA
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: 2023-04-17
**********************************************/
/**
 * 
 * @author Jacky Chun Kit Siu
 * This class contain the main which contains the program which solves Workshop 10 task2 problem
 * by following the hint in a suggested solution, Solution 2.
 */
public class Philosophers {
	private static String ph5YieldPh1RightChopStick;// contains a message which depending on the occupancy of the one chop stick  between 
											        // philosopher 1 and philosopher 5, this message will either be null when philosopher 5
													// is using his Left ChopStick or it will be 
	                                                //"Philosopher 5 yields Philosopher 1's right chopstick."; when philosopher 5 put down
	                                                // both his left and right chop sticks.
	private static String ph2YieldPh1LeftChopStick;

	private static String ph1YieldPh2RightChopStick;
	private static String ph3YieldPh2LeftChopStick;

	private static String ph2YieldPh3RightChopStick;
	private static String ph4YieldPh3LeftChopStick;

	private static String ph3YieldPh4RightChopStick;
	private static String ph5YieldPh4LeftChopStick;

	private static String ph4YieldPh5RightChopStick;
	private static String ph1YieldPh5LeftChopStick;
	/**
	 * Contain Solution 2
	 * @param args - String[] array which is not used
	 */
	public static void main(String[] args) {
		// philosopher 1
		Object leftChopStickOf5 = new Object(); // object that serves as a lock between Thread p1 (Philosopher 1)
												// and Thread p52 which supposedly if you interpret it in terms of 
		                                        // the problem Thread p52 and Thread p5(Philosopher 5) is a set that represent
		                                        // Philosopher 5 and Philosopher 5 used them to communicate with Threads: p1 (Philosopher 1),
		                                        // p12, p2 (Philosopher 2) and p22.
		Object rightChopStickOf2 = new Object();

		// philosopher 2
		Object leftChopStickOf1 = new Object();
		Object rightChopStickOf3 = new Object();

		// philosopher 3
		Object leftChopStickOf2 = new Object();
		Object rightChopStickOf4 = new Object();
		// philosopher 4
		Object leftChopStickOf3 = new Object();
		Object rightChopStickOf5 = new Object();

		// philosopher 5
		Object leftChopStickOf4 = new Object();
		Object rightChopStickOf1 = new Object();
		
		Thread p1 = new Thread(() -> {

			synchronized (leftChopStickOf5) { // Thread p1 is synchronized with Thread p52 by the lock leftChopStick of 5
				while (ph5YieldPh1RightChopStick == null) { // p5 (Philosopher 5) will set ph5YieldPh1RightChopStick to null
					try {									// When he is occupying he left chop stick which is p1 (Philosopher 1)'s
						leftChopStickOf5.wait();            // right chop stick
						
					} catch (InterruptedException e) {// When p52 notify p1 (Philosopher 1) that (leftChopStrickOf5) is unlocked 
						ph1YieldPh5LeftChopStick = null; //p1 (Philosopher 1) will set ph1YieldPh5LeftChopStick to null
					}
				}
			}

			synchronized (rightChopStickOf2) {
				while (ph2YieldPh1LeftChopStick == null) {
					try {
						rightChopStickOf2.wait();
					} catch (InterruptedException e) {
						ph1YieldPh2RightChopStick = null;
					}
				}
			}
			if (ph5YieldPh1RightChopStick != null && ph2YieldPh1LeftChopStick != null) {// when both messages from p52 and p22 is not null 
				System.out.println(ph5YieldPh1RightChopStick); //p1 (Philosopher 1) will print out both messages
				System.out.println(ph2YieldPh1LeftChopStick);
				System.out.println(Thread.currentThread().getName() + "have both chopSticks and can now eat!");//will print out the current thread name
			}																								   //concatenated with a message					

		});

		p1.setName("Philosopher 1 ");
		Thread p12 = new Thread(() -> {
			synchronized (leftChopStickOf1) {//synchronized with Thread p2(Philosopher 2)
				ph1YieldPh2RightChopStick = "Philosopher 1 yields Philosopher 2's right chopstick."; 
				leftChopStickOf1.notify(); //help p1 (Philosopher 1) tell p2 (Philosopher 2) that he is putting down his left chop stick,
			}                              //which is (Philosopher 2)'s right chop Stick.
			synchronized (rightChopStickOf1) {
				ph1YieldPh5LeftChopStick = "Philosopher 1 yields Philosopher 5's left chopstick.";
				rightChopStickOf1.notify();
			}
		});

		Thread p2 = new Thread(() -> {

			synchronized (leftChopStickOf1) {
				while (ph1YieldPh2RightChopStick == null) {

					try {
						leftChopStickOf1.wait();
					} catch (InterruptedException e) {
						ph2YieldPh1LeftChopStick = null;
					}
				}
			}

			synchronized (rightChopStickOf3) {
				while (ph3YieldPh2LeftChopStick == null) {
					try {
						rightChopStickOf3.wait();
					} catch (InterruptedException e) {
						ph2YieldPh3RightChopStick = null;
					}
				}
			}

			if (ph1YieldPh2RightChopStick != null && ph3YieldPh2LeftChopStick != null) {
				System.out.println(ph1YieldPh2RightChopStick);
				System.out.println(ph3YieldPh2LeftChopStick);
				System.out.println(Thread.currentThread().getName() + "have both chopSticks and can now eat!");

			}

		});

		p2.setName("Philosopher 2 ");

		Thread p22 = new Thread(() -> {
			synchronized (leftChopStickOf2) {
				ph2YieldPh3RightChopStick = "Philosopher 2 yields Philosopher 3's right chopstick.";
				leftChopStickOf2.notify();
			}
			synchronized (rightChopStickOf2) {
				ph2YieldPh1LeftChopStick = "Philosopher 2 yields Philosopher 1's left chopstick.";
				rightChopStickOf2.notify();
			}
		});

		Thread p3 = new Thread(() -> {

			synchronized (leftChopStickOf2) {
				while (ph2YieldPh3RightChopStick == null) {

					try {
						leftChopStickOf2.wait();
					} catch (InterruptedException e) {
						ph3YieldPh2LeftChopStick = null;
					}
				}
			}

			synchronized (rightChopStickOf4) {
				while (ph4YieldPh3LeftChopStick == null) {
					try {
						rightChopStickOf4.wait();
					} catch (InterruptedException e) {
						ph3YieldPh4RightChopStick = null;
					}
				}
			}
			if (ph2YieldPh3RightChopStick != null && ph4YieldPh3LeftChopStick != null) {
				System.out.println(ph2YieldPh3RightChopStick);
				System.out.println(ph4YieldPh3LeftChopStick);
				System.out.println(Thread.currentThread().getName() + "have both chopSticks and can now eat!");
			}

		});

		p3.setName("Philosopher 3 ");
		Thread p32 = new Thread(() -> {
			synchronized (leftChopStickOf3) {
				ph3YieldPh4RightChopStick = "Philosopher 3 yields Philosopher 4's right chopstick.";
				leftChopStickOf3.notify();
			}
			synchronized (rightChopStickOf3) {
				ph3YieldPh2LeftChopStick = "Philosopher 3 yields Philosopher 2's left chopstick.";
				rightChopStickOf3.notify();
			}
		});

		Thread p4 = new Thread(() -> {

			synchronized (leftChopStickOf3) {
				while (ph3YieldPh4RightChopStick == null) {

					try {
						leftChopStickOf3.wait();
					} catch (InterruptedException e) {
						ph4YieldPh3LeftChopStick = null;
					}
				}
			}

			synchronized (rightChopStickOf5) {
				while (ph5YieldPh4LeftChopStick == null) {

					try {
						rightChopStickOf5.wait();
					} catch (InterruptedException e) {
						ph4YieldPh5RightChopStick = null;
					}
				}
			}
			if (ph3YieldPh4RightChopStick != null && ph5YieldPh4LeftChopStick != null) {
				System.out.println(ph3YieldPh4RightChopStick);
				System.out.println(ph5YieldPh4LeftChopStick);
				System.out.println(Thread.currentThread().getName() + "have both chopSticks and can now eat!");
			}

		});

		p4.setName("Philosopher 4 ");
		Thread p42 = new Thread(() -> {
			synchronized (leftChopStickOf4) {
				ph4YieldPh5RightChopStick = "Philosopher 4 yields Philosopher 5's right chopstick.";
				leftChopStickOf4.notify();
			}
			synchronized (rightChopStickOf4) {
				ph4YieldPh3LeftChopStick = "Philosopher 4 yields Philosopher 3's left chopstick.";
				rightChopStickOf4.notify();
			}
		});

		Thread p5 = new Thread(() -> {

			synchronized (leftChopStickOf4) {
				while (ph4YieldPh5RightChopStick == null) {

					try {
						leftChopStickOf4.wait();
					} catch (InterruptedException e) {
						ph5YieldPh4LeftChopStick = null;
					}
				}
			}

			synchronized (rightChopStickOf1) {
				while (ph1YieldPh5LeftChopStick == null) {

					try {
						rightChopStickOf1.wait();
					} catch (InterruptedException e) {
						ph5YieldPh1RightChopStick = null;
					}
				}
			}
			if (ph4YieldPh5RightChopStick != null && ph1YieldPh5LeftChopStick != null) {
				System.out.println(ph4YieldPh5RightChopStick);
				System.out.println(ph1YieldPh5LeftChopStick);
				System.out.println(Thread.currentThread().getName() + "have both chopSticks and can now eat!");
			}

		});

		p5.setName("Philosopher 5 ");
		Thread p52 = new Thread(() -> {
			synchronized (leftChopStickOf5) {
				ph5YieldPh1RightChopStick = "Philosopher 5 yields Philosopher 1's right chopstick.";
				leftChopStickOf5.notify();
			}
			synchronized (rightChopStickOf5) {
				ph5YieldPh4LeftChopStick = "Philosopher 5 yields Philosopher 4's left chopstick.";
				rightChopStickOf5.notify();
			}
		});

		p1.start();
		p12.start();
		p2.start();
		p22.start();
		p3.start();
		p32.start();
		p4.start();
		p42.start();
		p5.start();
		p52.start();

	}
}
