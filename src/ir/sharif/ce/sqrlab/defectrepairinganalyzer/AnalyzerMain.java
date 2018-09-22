package ir.sharif.ce.sqrlab.defectrepairinganalyzer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import ir.sharif.ce.sqrlab.defectrepairinganalyzer.models.PatchResultInfo;

public class AnalyzerMain {
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
		calculateFigure4();
	}

	private static void calculateFigure4() throws FileNotFoundException, ClassNotFoundException, IOException {
		Double[] sameCountInInterval = new Double[10], differentCountInInterval = new Double[10];
		int sameCnt = 0, differentCnt = 0;

		for (int i = 0; i < 10; i++) {
			sameCountInInterval[i] = 0.0;
			differentCountInInterval[i] = 0.0;
		}

		File[] patcheDirs = (new File("stored_objects")).listFiles();
		for (File patchDir : patcheDirs) {
			if (patchDir.getPath().endsWith("Patch19"))
				continue;
			PatchResultInfo pri = new PatchResultInfo(patchDir.getPath());
			for (Double dis : pri.getDifferentResults()) {
				differentCnt++;
				int intervalInd = (int) (dis * 10);
				differentCountInInterval[intervalInd == 10 ? 9 : intervalInd]++;
			}
			for (Double dis : pri.getSameResults()) {
				sameCnt++;
				int intervalInd = (int) (dis * 10);
				sameCountInInterval[intervalInd == 10 ? 9 : intervalInd]++;
			}
		}

		for (int i = 0; i < 10; i++) {
			System.out.print(sameCountInInterval[i] * 100 / sameCnt + " ");
		}
		System.out.println();

		for (int i = 0; i < 10; i++) {
			System.out.print(differentCountInInterval[i] * 100 / differentCnt + " ");
		}
		System.out.println();
	}
}
