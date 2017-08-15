import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;
import java.util.StringTokenizer;

public class KarplusStrong {

	public static void main(String[] args) {
		//declare double variable for the Karplus-Strong Algorithim
		double a , b , c;
		//create 2 queues 
		ListQueue Q1 = new ListQueue();
		ListQueue Q2 = new ListQueue();
		Q2.enqueue(0.0);
		ListQueue Q3 = new ListQueue();
		
		//total number of samples 100
		int m = 4;
		
		//number or random integers between -1.0 and 1.0 to generate  1000
		int nRand = 4;
		for (int i = 0 ; i < nRand; i++){
			Random random = new Random();
			Q1.enqueue(random.nextDouble()*2 -1);
		}
		
		for (int j = 0; j < m; j++){
			a = Q1.dequeue();
			b = Q2.dequeue();
			c = 0.99 * ((a+b)/2);
			Q1.enqueue(c);
			Q2.enqueue(a);
			Q3.enqueue(c);
		}
	}
	
	public static void ks(){

	}
	
	public static void writeDATformat (ListQueue q){

	}

}
