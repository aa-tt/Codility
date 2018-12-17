package codility4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution {

	public static void main(String[] args) {
		System.out.println("Max sleep duration-" + solution(getMeetingSchedule1()));
		System.out.println("Max sleep duration-" + solution(getMeetingSchedule2()));
		System.out.println("Max sleep duration-" + solution(getMeetingSchedule3()));
		System.out.println("Max sleep duration-" + solution(getMeetingSchedule4()));
	}

	private static int solution(String S) {
		String[] dailySchedule = S.split("\n");
		TreeMap<Integer, TreeSet<TTofDay>> ttOfWeek = (TreeMap<Integer, TreeSet<TTofDay>>) getTTofWeek();
		for (int i = 0; i < dailySchedule.length; i++) {
			Integer day = DayNumber.valueOf(dailySchedule[i].split(" ")[0]).ordinal();
			String schedule = dailySchedule[i].split(" ")[1];
			int startSchedule = countMinutes(day, schedule.split("-")[0]);
			int endSchedule = countMinutes(day, schedule.split("-")[1]);

			TreeSet<TTofDay> ttDayTemp = null;
			if (ttOfWeek.get(day) != null) {
				ttDayTemp = ttOfWeek.get(day);
			} else {
				ttDayTemp = new TreeSet<>();
			}
			ttDayTemp.add(new TTofDay(startSchedule, endSchedule));
			ttOfWeek.put(day, ttDayTemp);
		}
		List<Integer> busySch = new ArrayList<>();
		busySch.add(0);
		ttOfWeek.forEach((k, v) -> {
			System.out.print(k);
			if (v != null)
				v.forEach(e -> {
					System.out.print(e);
					busySch.add(e.startMinutes);
					busySch.add(e.endMinutes);
				});
			System.out.println();
		});
		busySch.add(10080);
		int sleepStart, sleepEnd;
		int sleepDuration = 0;
		for (int i = 0; i < busySch.size();) {
			sleepStart = sleepEnd = 0;
			if (i % 2 == 0) {
				sleepStart = busySch.get(i);
				i = i + 1;
			}
			if (i % 2 == 1) {
				sleepEnd = busySch.get(i);
				i = i + 1;
			}
			if (sleepDuration < (sleepEnd - sleepStart))
				sleepDuration = sleepEnd - sleepStart;
		}
		busySch.forEach(a -> System.out.print(a + " "));
		return sleepDuration;

	}

	private static Map<Integer, ? extends Object> getTTofWeek() {
		Map<Integer, Object> m = new TreeMap<>();
		m.put(DayNumber.Mon.ordinal(), null);
		m.put(DayNumber.Tue.ordinal(), null);
		m.put(DayNumber.Wed.ordinal(), null);
		m.put(DayNumber.Thu.ordinal(), null);
		m.put(DayNumber.Fri.ordinal(), null);
		m.put(DayNumber.Sat.ordinal(), null);
		m.put(DayNumber.Sun.ordinal(), null);
		return m;
	}

	private static int countMinutes(int day, String momentOfDay) {
		int hours = Integer.parseInt(momentOfDay.split(":")[0]);
		int minutes = Integer.parseInt(momentOfDay.split(":")[1]);
		return (day * 24 * 60) + ((hours * 60) + minutes);
	}

	static class TTofDay implements Comparable<TTofDay> {
		int startMinutes;
		int endMinutes;

		TTofDay(int sm, int em) {
			this.startMinutes = sm;
			this.endMinutes = em;
		}

		@Override
		public int compareTo(TTofDay obj) {
			if (this.startMinutes < obj.startMinutes)
				return -1;
			if (this.startMinutes > obj.startMinutes)
				return 1;
			return 0;
		}

		@Override
		public String toString() {
			return "[" + startMinutes + "-" + endMinutes + "]";
		}

	}

	static enum DayNumber {
		Mon, Tue, Wed, Thu, Fri, Sat, Sun;
	}

	static String getMeetingSchedule1() {
		// this should return 505
		StringBuilder meetingSchedule = new StringBuilder();
		meetingSchedule.append("Sun 10:00-20:00" + "\n");
		meetingSchedule.append("Fri 05:00-10:00" + "\n");
		meetingSchedule.append("Fri 16:30-23:50" + "\n");
		meetingSchedule.append("Sat 10:00-24:00" + "\n");
		meetingSchedule.append("Sun 01:00-04:00" + "\n");
		meetingSchedule.append("Sat 02:00-06:00" + "\n");
		meetingSchedule.append("Tue 03:30-18:15" + "\n");
		meetingSchedule.append("Tue 19:00-20:00" + "\n");
		meetingSchedule.append("Wed 04:25-15:14" + "\n");
		meetingSchedule.append("Wed 15:14-22:40" + "\n");
		meetingSchedule.append("Thu 00:00-23:59" + "\n");
		meetingSchedule.append("Mon 05:00-13:00" + "\n");
		meetingSchedule.append("Mon 15:00-21:00");
		return meetingSchedule.toString();
	}

	static String getMeetingSchedule2() {
		// this should return 180
		StringBuilder meetingSchedule = new StringBuilder();
		meetingSchedule.append("Mon 01:00-23:00" + "\n");
		meetingSchedule.append("Tue 01:00-23:00" + "\n");
		meetingSchedule.append("Wed 01:00-23:00" + "\n");
		meetingSchedule.append("Thu 01:00-23:00" + "\n");
		meetingSchedule.append("Fri 01:00-23:00" + "\n");
		meetingSchedule.append("Sat 01:00-23:00" + "\n");
		meetingSchedule.append("Sun 01:00-21:00");
		return meetingSchedule.toString();
	}

	static String getMeetingSchedule3() {
		// this should return 1560
		StringBuilder meetingSchedule = new StringBuilder();
		meetingSchedule.append("Mon 01:00-23:00" + "\n");
		meetingSchedule.append("Tue 01:00-23:00" + "\n");
		meetingSchedule.append("Wed 01:00-23:00" + "\n");
		meetingSchedule.append("Thu 01:00-23:00" + "\n");
		meetingSchedule.append("Sat 01:00-23:00" + "\n");
		meetingSchedule.append("Sun 01:00-21:00");
		return meetingSchedule.toString();
	}

	static String getMeetingSchedule4() {
		// this should return 505
		StringBuilder meetingSchedule = new StringBuilder();
		meetingSchedule.append("Mon 00:00-23:59" + "\n");
		meetingSchedule.append("Tue 00:00-23:59" + "\n");
		meetingSchedule.append("Wed 00:00-23:59" + "\n");
		meetingSchedule.append("Thu 00:00-23:59" + "\n");
		meetingSchedule.append("Fri 00:00-23:59" + "\n");
		meetingSchedule.append("Sat 00:00-23:59" + "\n");
		meetingSchedule.append("Sun 00:00-23:59");
		return meetingSchedule.toString();
	}
}
