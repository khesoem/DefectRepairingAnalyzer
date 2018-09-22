package ir.sharif.ce.sqrlab.defectrepairinganalyzer.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PatchResultInfo {
	private IntegerSet gen, fail, pass;
	private List<Double> sameResults, differentResults;

	public PatchResultInfo(String resultDir) throws FileNotFoundException, ClassNotFoundException, IOException {
		fail = new IntegerSet(resultDir + File.separator + "fail");
		pass = new IntegerSet(resultDir + File.separator + "pass");
		gen = new IntegerSet(resultDir + File.separator + "gen");
		dis = new TwoDArr(resultDir + File.separator + "dis");

		sameResults = new ArrayList<>();
		differentResults = new ArrayList<>();

		for (int i : fail.getSet()) {
			for (int j : pass.getSet()) {
				differentResults.add(dis.getArr()[i][j]);
			}
		}

		for (int i : fail.getSet()) {
			for (int j : fail.getSet()) {
				sameResults.add(dis.getArr()[i][j]);
			}
		}

		for (int i : pass.getSet()) {
			for (int j : pass.getSet()) {
				sameResults.add(dis.getArr()[i][j]);
			}
		}
	}

	private TwoDArr dis;

	public TwoDArr getDis() {
		return dis;
	}

	public void setDis(TwoDArr dis) {
		this.dis = dis;
	}

	public IntegerSet getPass() {
		return pass;
	}

	public void setPass(IntegerSet pass) {
		this.pass = pass;
	}

	public IntegerSet getFail() {
		return fail;
	}

	public void setFail(IntegerSet fail) {
		this.fail = fail;
	}

	public IntegerSet getGen() {
		return gen;
	}

	public void setGen(IntegerSet gen) {
		this.gen = gen;
	}

	public List<Double> getDifferentResults() {
		return differentResults;
	}

	public void setDifferentResults(List<Double> differentResults) {
		this.differentResults = differentResults;
	}

	public List<Double> getSameResults() {
		return sameResults;
	}

	public void setSameResults(List<Double> sameResults) {
		this.sameResults = sameResults;
	}
}
