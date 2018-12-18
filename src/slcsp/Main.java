package slcsp;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {

		/*
		 * change this path to match location of input files(windows/unix) - the current
		 * configuration is for unix filesystem. For windows, it may be like -
		 * "E:\\test\\zips.csv"
		 */
		String path = "/Users/anunayanindya/workspaces/eclipse-workspace/slcsp-java/";
		String slcspCsv = path + "slcsp.csv";
		String zipsCsv = path + "zips.csv";
		String plansCsv = path + "plans.csv";
		String slcspCsvOut = path + "slcsp.csv";

		// main logic
		Map<String, Float> slcspMap = new LinkedHashMap<>();
		Map<String, List<RateArea>> zipsMap = new HashMap<>();
		Map<RateArea, List<Float>> plansMap = new HashMap<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(zipsCsv))) {

			String line = reader.readLine();
			line = reader.readLine();
			String[] fields;
			RateArea rateArea;
			while (line != null) {
				fields = line.split(",");
				rateArea = new RateArea(fields[1], Integer.parseInt(fields[4]));
				String zipCode = fields[0];

				if (zipsMap.containsKey(zipCode)) {
					if (!zipsMap.get(zipCode).contains(rateArea))
						zipsMap.get(zipCode).add(rateArea);

				} else {
					List<RateArea> l = new ArrayList<>();
					l.add(rateArea);
					zipsMap.put(zipCode, l);
				}
				line = reader.readLine();
			}
		}

		try (BufferedReader reader = new BufferedReader(new FileReader(plansCsv))) {

			String line = reader.readLine();
			line = reader.readLine();
			String[] fields;
			RateArea rateArea;
			while (line != null) {
				fields = line.split(",");
				rateArea = new RateArea(fields[1], Integer.parseInt(fields[4]));
				Float rate = Float.parseFloat(fields[3]);

				if (plansMap.containsKey(rateArea)) {
					if (!plansMap.get(rateArea).contains(rate))
						plansMap.get(rateArea).add(rate);

				} else {
					List<Float> l = new ArrayList<>();
					l.add(rate);
					plansMap.put(rateArea, l);
				}
				line = reader.readLine();
			}
		}

		try (BufferedReader reader = new BufferedReader(new FileReader(slcspCsv))) {

			String headerLine = reader.readLine();
			String line = reader.readLine();
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(slcspCsvOut))) {
				writer.write(headerLine);
				writer.newLine();
				System.out.println(headerLine);
				String[] fields;
				String zipCode;
				Float rate;
				while (line != null) {
					rate = 0f;
					fields = line.split(",");
					zipCode = fields[0];

					if (zipsMap.containsKey(zipCode)) {
						if (zipsMap.get(zipCode).size() == 1) {
							RateArea ra = zipsMap.get(zipCode).get(0);
							if (plansMap.containsKey(ra)) {
								List<Float> l = plansMap.get(ra);
								Collections.sort(l);
								rate = l.size() > 1 ? l.get(1) : l.get(0);
								slcspMap.put(zipCode, rate);
								writer.write(zipCode + "," + ((rate == 0f) ? "" : rate.toString()));
								writer.newLine();
								System.out.println(zipCode + "," + ((rate == 0f) ? "" : rate.toString()));
							} else {
								slcspMap.put(zipCode, rate);
								writer.write(zipCode + "," + ((rate == 0f) ? "" : rate.toString()));
								writer.newLine();
								System.out.println(zipCode + "," + ((rate == 0f) ? "" : rate.toString()));
							}
						} else {
							slcspMap.put(zipCode, rate);
							writer.write(zipCode + "," + ((rate == 0f) ? "" : rate.toString()));
							writer.newLine();
							System.out.println(zipCode + "," + ((rate == 0f) ? "" : rate.toString()));
						}

					} else {
						slcspMap.put(zipCode, rate);
						writer.write(zipCode + "," + ((rate == 0f) ? "" : rate.toString()));
						writer.newLine();
						System.out.println(zipCode + "," + ((rate == 0f) ? "" : rate.toString()));
					}
					line = reader.readLine();
				}
			}
		}
	}

	static class RateArea {

		String state;
		Integer rateArea;

		RateArea(String state, Integer rateArea) {
			this.state = state;
			this.rateArea = rateArea;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((rateArea == null) ? 0 : rateArea.hashCode());
			result = prime * result + ((state == null) ? 0 : state.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			RateArea other = (RateArea) obj;
			if (rateArea == null) {
				if (other.rateArea != null)
					return false;
			} else if (!rateArea.equals(other.rateArea))
				return false;
			if (state == null) {
				if (other.state != null)
					return false;
			} else if (!state.equals(other.state))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return state + " " + rateArea;
		}

	}

}
