package ir.sharif.ce.sqrlab.defectrepairinganalyzer.util;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;

public class RunCommandGenerator {

	/*
	 * this class generates run commands (python3 run.py project bug patch) to
	 * get results for distinct bugs.
	 */
	public static void main(String[] args) throws JSONException, IOException {
		File patchesDir = new File(
				"C:\\Users\\khesoem\\Desktop\\DefectRepairing-master\\DefectRepairing-master\\tool\\patches\\INFO");

		Set<String> coveredBugs = new HashSet<>();
		String[] calculatedBefore = { "1", "13", "2", "4", "6", "79", "8", "80", "84", "9", "15" };
		for (String patch : calculatedBefore) {
			JSONObject jo = new JSONObject(readFile(patchesDir.getPath() + File.separator + "Patch" + patch + ".json"));
			coveredBugs.add(jo.getString("bug_id") + ":" + jo.getString("project"));
		}

		File[] patchFiles = patchesDir.listFiles();
		for (File patch : patchFiles) {
			JSONObject jo = new JSONObject(readFile(patch.getPath()));
			String bugId = jo.getString("bug_id"), projectName = jo.getString("project");
			if (coveredBugs.contains(bugId + ":" + projectName) || projectName.equals("Closure"))
				continue;
			System.out.println("python3 run.py " + projectName + " " + bugId + " " + jo.getString("ID"));
			coveredBugs.add(bugId);
		}
	}

	static String readFile(String path) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, "UTF-8");
	}
}
