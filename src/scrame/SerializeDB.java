package scrame;
import java.io.*;
import java.util.*;
// Note : When structure of the Object type (the class file) in the list changed
// the Serialized file may fail.
public class SerializeDB
{
	public static List readSerializedObject(String filename) {
		List pDetails = null;
		FileInputStream fis = null;
		ObjectInputStream in = null;
		try {
			fis = new FileInputStream(filename);
			in = new ObjectInputStream(fis);
			pDetails = (ArrayList<?>) in.readObject();
			in.close();
		} catch (IOException ex) {
		} catch (ClassNotFoundException ex) {
		}
		//print out the size
		//System.out.println(" Details Size: " + pDetails.size());
		//System.out.println();
		return pDetails;
	}

	public static void writeSerializedObject(String filename, List list) {
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream(filename);
			out = new ObjectOutputStream(fos);
			out.writeObject(list);
			out.close();
//			System.out.println("Object Persisted");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}