package ir.sharif.ce.sqrlab.defectrepairinganalyzer.models;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TwoDArr {
	private double[][] arr;
	
	public TwoDArr(String storedObjectPath) throws FileNotFoundException, ClassNotFoundException, IOException{
		init(storedObjectPath);
	}
	
	public void init(String storedObjectPath) throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(storedObjectPath));
		arr = (double[][]) ois.readObject();
	}

	public double[][] getArr() {
		return arr;
	}

	public void setArr(double[][] arr) {
		this.arr = arr;
	}
}
