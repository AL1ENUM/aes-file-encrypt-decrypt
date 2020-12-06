package alienum;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {

	static String path = "aliens.txt";

	public static void main(String[] args) throws IOException, ClassNotFoundException {

	

		String alien1 = "minotaur:m1nom1no..";
		String alien2 = "scylla:scyscy..";
		String alien3 = "echidna:ech1ech1..";
		String alien4 = "cyclops:cyccyc..";
		String alien5 = "anunnaki:nak1nak1..";
		String alien6 = "anunnaki:nak1nak2..";
		String alien7 = "anunnaki:nakinaki..";
		
		List<String> aliens = new ArrayList<>();
		aliens.add(alien1);
		aliens.add(alien2);
		aliens.add(alien3);
		aliens.add(alien4);
		aliens.add(alien5);
		aliens.add(alien6);
		aliens.add(alien7);
		
		 FileOutputStream fos = null;
		    try {
		        fos = new FileOutputStream(path);
		        for (String s : aliens) {
		        	s.split("\\s+");
		            ObjectOutputStream oos = new ObjectOutputStream(fos);
		            oos.writeObject(s);
		        }
		    } finally {
		        if (fos != null)
		            fos.close();
		    }


		List<Object> results = new ArrayList<Object>();

		// Read objects
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(path);
			while (true) {
				ObjectInputStream ois = new ObjectInputStream(fis);
				results.add(ois.readObject());
			}
		} catch (EOFException ignored) {
			// as expected
		} finally {
			if (fis != null)
				fis.close();
		}
		System.out.println("results = " + results);
		
		 String key = "w4rz0nerex0gener";
	        File inputFile = new File(path);
	        File encryptedFile = new File("aliens.encrypted");
	        File decryptedFile = new File("aliens.decrypted");
	         
	        try {
	            Cryptor.encrypt(key, inputFile, encryptedFile);
	            Cryptor.decrypt(key, encryptedFile, decryptedFile);
	        } catch (CryptoException ex) {
	            System.out.println(ex.getMessage());
	            ex.printStackTrace();
	        }

	}

}
