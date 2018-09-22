package ir.sharif.ce.sqrlab.defectrepairinganalyzer.models;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Set;

public class IntegerSet {
	private Set<Integer> set;
	
	public IntegerSet(String storedObjectPath) throws FileNotFoundException, ClassNotFoundException, IOException{
		load(storedObjectPath);
	}

	public void load(String storedObjectPath) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(storedObjectPath));
		set = (Set<Integer>) ois.readObject();
	}

	public Set<Integer> getSet() {
		return set;
	}

	public void setSet(Set<Integer> set) {
		this.set = set;
	}

}
