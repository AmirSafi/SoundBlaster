import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.StringTokenizer;

public class KS {

	public static void main(String[] args) {
		
		//declare double variable for the Karplus-Strong Algorithim
		double a , b , c;
		//create 2 queues 
		ListQueue Q1 = new ListQueue();
		ListQueue Q2 = new ListQueue();
		Q2.enqueue(0.0);
		ListQueue Q3 = new ListQueue();
		
		//total number of samples 100
		int m = 100;
		
		//number or random integers between -1.0 and 1.0 to generate  1000
		int nRand = 100;
		for (int i = 0 ; i < nRand; i++){
			Random random = new Random();
			Q1.enqueue(random.nextDouble()*2 -1);
		}
		
		for (int j = 0; j < m; j++){
			a = Q1.dequeue();
			System.out.println(a);
			b = Q2.dequeue();
			c = 0.99 * ((a+b)/2);
			Q1.enqueue(c);
			Q2.enqueue(a);
			Q3.enqueue(c);
		}

 
       //the rest of the code below was copied and modified from the provided Reverse.java 
	   //which was provided to the class 
		//The code below takes ListQueue Q3 and outputs it to a .dat file 
	
        try {
            // Set up the input file to read, and the output 
            // the file to write to.
            PrintWriter fileOut =
                new PrintWriter(new
            BufferedWriter(new FileWriter(args[0])));

            int sampleRate = 44100;
            
            fileOut.println("; Sample Rate " + sampleRate);
            int numSteps = 0;

        	for (int j = 0; j < m; j++){
                fileOut.print((double) numSteps / sampleRate + "\t");
                //fileOut.println((double)Q3.dequeue());
                numSteps++;
    		}
     
            fileOut.close();

        } catch(IOException ioe) {
            System.err.println(
                "Error opening/reading/writing input or output file.");
            System.exit(1);
        } catch(NumberFormatException nfe) {
            System.err.println(nfe.toString());
            System.err.println("Error in file format");
            System.exit(1);
        }

	}

}
