package w10.tm;
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
 *
 * The class ThreadMatrices contains the main method
 */
public class ThreadMatrices {
	/**
	 * The purpose of what is in the main is to do a comparison of time taken between implementing a 
	 * method that multiply two large Matrices in parallel using threads and a method that multiply 
	 * two large Matrices sequentially
	 * @param args - String array which is not used
	 */
	public static void main(String[] args) {
		double[][] firstMatrix = new double[2000][2000];
		double[][]  secondMatrix = new double[2000][2000];
		double[][]  parallelMultiplyResult = new double[2000][2000];
		double[][]  sequentialMultiplyResult = new double[2000][2000];
  		for(int i = 0; i < 2000; i++) {
			for(int j = 0; j < 2000; j++) {
				firstMatrix[i][j]=2.0;
				secondMatrix[i][j]= 3.0;
			}
		}
		
	    Thread t1 = new Thread() {public void run() {Matrix.parallelMultiplyMatrix(firstMatrix, secondMatrix);}};
	    Thread t2 = new Thread() {public void run() {Matrix.parallelMultiplyMatrix(firstMatrix, secondMatrix);}};
	    Thread t3 = new Thread() {public void run() {Matrix.parallelMultiplyMatrix(firstMatrix, secondMatrix);}};
	    Thread t4 = new Thread() {public void run() {Matrix.parallelMultiplyMatrix(firstMatrix, secondMatrix);}};
	    t1.setName("t1");
	    t2.setName("t2");
	    t3.setName("t3");
	    t4.setName("t4");
	    
	    long startTime = System.currentTimeMillis();
	   try{
	    t1.start();
	    t2.start();
	    t3.start();
	    t4.start();
	    t1.join();
	    t2.join();
	    t3.join();
	    t4.join();
	   }catch(InterruptedException e) {
		  e.printStackTrace(); 
	   }
	   parallelMultiplyResult = Matrix.parallelMultiplyMatrix(firstMatrix, secondMatrix);
	   long endTime = System.currentTimeMillis() - startTime;
	   for(int i = 0; i < 2000; i++) {
		   for(int j = 0; j < 2000; j++) {
			   System.out.print(parallelMultiplyResult[i][j] + " ");
		   }
		   System.out.println();
	   }
	   System.out.println("Time taken for Parallel Multiply Matrix: " + endTime + " milli seconds.");
	   
	   long startTime2 = System.currentTimeMillis();
	   sequentialMultiplyResult = Matrix.sequentialMultiplyMatrix(firstMatrix, secondMatrix);
	   long endTime2 = System.currentTimeMillis() - startTime2;
	   for(int i = 0; i < 2000; i++) {
		   for(int j = 0; j < 2000; j++) {
			   System.out.print(sequentialMultiplyResult[i][j] + " ");
		   }
		   System.out.println();
	   }
	   System.out.println("Time taken for Sequential Multiply Matrix: " + endTime2 + " milli seconds.");
	   System.out.print("IN COMPARISON WITH: ");
	   System.out.println("Time taken for Parallel Multiply Matrix: " + endTime + " milli seconds.");
	}
}	
/**
 * 
 * @author Jacky Chun kit Siu
 * This class contain two methods one is public static double[][] parallelMultiplyMatrix(double[][] a, double[][] b); 
 * This Method multiply 2 large Matrices of [2000] x [2000] by dividing them into 4 portions to be run in 4 threads.
 * Each thread will do a portion of the calculation. The private static double[][] resultMatrix of the class Matrix
 * would be used to store each threads calculations for the elements in the Matrix that they are responsible for progressively.
 * After all 4 threads in the main finish running, the completed matrix can be collected from this method.
 * 
 * The other method is public static double[][] sequentialMultiplyMatrix(double[][] c, double[][] d) which is use to
 * multiply 2 large Matrices of [2000] x [2000] in a sequential manner. Its calculation as in progress in multiplying 
 * the two Matrices will be stored in private static double[][] resultMatrix2 = new double[2000][2000]; When the 
 * calculations are done this method will return resultMatrix2 which is the result.
 */
class Matrix {
	
	private static double[][] resultMatrix = new double[2000][2000];
	private static double[][] resultMatrix2 = new double[2000][2000];
	private static int divide1Start = 0;
	private static int divide1End = 500;
	private static int divide2Start = 501;
	private static int divide2End = 1000;
	private static int divide3Start = 1001;
	private static int divide3End = 1500;
	private static int divide4Start = 1501;
	private static int divide4End = 2000;

/**
 * Multiply  large Matrices of [2000] x [2000] by dividing its element into 4 portions to be run in 4 threads.
 * Depending on the thread's name a divided portion from the whole namely rows of the result will be calculated.
 * The private static double[][] resultMatrix of the class Matrix
 * would be used to store each threads calculations for the elements in the Matrix that they are responsible for progressively.
 * After all 4 threads in the main finish running, the completed matrix can be collected from this method. 
 * @param a - a double[][] array of [2000] x [2000]
 * @param b  - a double[][] array of [2000] x [2000]
 * @return resultMatrix - a double[][] array of [2000] x [2000]
 */
	public static double[][] parallelMultiplyMatrix(double[][] a, double[][] b) {
		
		if (Thread.currentThread().getName() == "t1") {
			for (int rowToBeCompleted = divide1Start; rowToBeCompleted <= divide1End; rowToBeCompleted++) {
				for (int j = 0; j < 2000; j++) {
					for (int k = 0; k < 2000; k++) {
						resultMatrix[rowToBeCompleted][j] += (a[rowToBeCompleted][k] * b[k][j]);
					}
				}
			}
		} else if (Thread.currentThread().getName() == "t2") {
			for (int rowToBeCompleted = divide2Start; rowToBeCompleted <= divide2End; rowToBeCompleted++) {
				for (int j = 0; j < 2000; j++) {
					for (int k = 0; k < 2000; k++) {
						resultMatrix[rowToBeCompleted][j] += (a[rowToBeCompleted][k] * b[k][j]);
					}
				}
			}

		} else if (Thread.currentThread().getName() == "t3") {
			for (int rowToBeCompleted = divide3Start; rowToBeCompleted <= divide3End; rowToBeCompleted++) {
				for (int j = 0; j < 2000; j++) {
					for (int k = 0; k < 2000; k++) {
						resultMatrix[rowToBeCompleted][j] += (a[rowToBeCompleted][k] * b[k][j]);
					}
				}
			}

		} else if (Thread.currentThread().getName() == "t4") {
			for (int rowToBeCompleted = divide4Start; rowToBeCompleted < divide4End; rowToBeCompleted++) {
				for (int j = 0; j < 2000; j++) {
					for (int k = 0; k < 2000; k++) {
						resultMatrix[rowToBeCompleted][j] += (a[rowToBeCompleted][k] * b[k][j]);
					}
				}
			}

		}
		return resultMatrix;

	}
/**
 *
 *  This method is use for multiply 2 large Matrices of [2000] x [2000] in a sequential manner. Its calculation as in progress in multiplying 
 * the two Matrices will be stored in private static double[][] resultMatrix2 = new double[2000][2000]; When the 
 * calculations are done this method will return resultMatrix2 which is the result.
 * @param c -a double[][] array of [2000] x [2000]
 * @param d c -a double[][] array of [2000] x [2000]
 * @return resultMatrix2 -a double[][] array of [2000] x [2000]
 */
	public static double[][] sequentialMultiplyMatrix(double[][] c, double[][] d) {
		for (int rowToBeCompleted = 0; rowToBeCompleted < 2000; rowToBeCompleted++) {
			for (int j = 0; j < 2000; j++) {
				for (int k = 0; k < 2000; k++) {
					resultMatrix2[rowToBeCompleted][j] += (c[rowToBeCompleted][k] * d[k][j]);
				}
			}
		}

		return resultMatrix2;
	}

}

