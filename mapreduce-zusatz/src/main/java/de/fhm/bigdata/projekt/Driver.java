package de.fhm.bigdata.projekt;

import org.apache.hadoop.util.ProgramDriver;

import de.fhm.bigdata.projekt.anagramm.Anagramm;

public class Driver {

  public static void main(String argv[]) {
 		int exitCode = -1;
 		ProgramDriver pgd = new ProgramDriver();
 		try {
 			pgd.addClass("anagram", Anagramm.class,
 					"MapReduce program for Anagramms.");
      //pgd.addClass("tfidf", TFIDFJobController.class,
   					//"MapReduce program to compute TF-IDF of input text files.");
 			pgd.driver(argv);
 			// Success
 			exitCode = 0;
 		} catch (Throwable e) {
 			e.printStackTrace();
 		}
 		System.exit(exitCode);
 	}
}