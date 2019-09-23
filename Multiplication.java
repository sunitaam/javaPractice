package sleepexample;

public class Multiplication {

	private static Integer val = 2;
	static Multiplication m = new Multiplication();
	
	public static void main(String[] args) {
		ThreadA ta = new ThreadA();
		ThreadB tb = new ThreadB();	
		ta.start();
		tb.start();
	}
	
	static class ThreadA extends Thread {
		public void run() {
			
			synchronized(m) {
				while(val <= 10) {
					int j = 1;
					while(j<=10) {
						if(val%2 == 0) {
								System.out.println("A "+val*j );
								m.notify();
								j++;
						} else {
							try {
								m.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
					} val++; System.out.println("\n");
			}
		}
	}
	
	}
	static class ThreadB extends Thread {
		
		
		public void run() {
			
			/*try {
				Thread.sleep();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			synchronized(m) {
				while(val < 10) {
					int j = 1;
					while(j<=10) {
						if(val%2 != 0) {
								System.out.println("B "+val*j);
								m.notify();
								 j++;
						} else {
							try {
								m.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
					} val++; System.out.println("\n");
			}
		}
		}
	}
	

	
}
