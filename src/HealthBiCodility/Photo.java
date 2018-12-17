package HealthBiCodility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Photo {

	public static void main(String[] args) {
		solution(getInputPhoto2());

	}

	static String solution(String S) {
		String[] photos = S.split("\n");
		Map<String, List<Name>> map = new HashMap<>();
		for (int i = 0; i < photos.length; i++) {
			String[] photoDetail = photos[i].split(", ");
			List<Name> list = new ArrayList<>();
			long time = 0;
			try {
				time = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(photoDetail[2]).getTime();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			String ext = photoDetail[0].split("\\.")[1];
			Name name = new Name(ext, photoDetail[1], time);
			if (map.get(photoDetail[1]) == null) {
				list.add(name);
			} else {
				list = map.get(photoDetail[1]);
				list.add(name);
			}
			map.put(photoDetail[1], list);
		}
		for (String s : map.keySet()) {
			List<Name> l = map.get(s);
			Set<Name> set = new TreeSet<>();
			l.forEach(name -> set.add(name));
			Iterator<Name> itr = set.iterator();
			int i = 0;
			while (itr.hasNext()) {
				i++;
				Name name = itr.next();
				String zeroes = zeroes(l.size(), i) + i;
				name.index = zeroes;

			}
			l.forEach(name -> System.out.print(name + "-->"));
			System.out.println();
		}
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < photos.length; i++) {
			String[] photoDetail = photos[i].split(", ");
			List<Name> l = map.get(photoDetail[1]);
			if (i == photos.length - 1)
				result.append(l.get(0).toString());
			else
				result.append(l.get(0).toString() + "\n");
			l.remove(0);
		}
		System.out.println(result.toString());
		return null;
	}

	static String zeroes(int num1, int num2) {
		StringBuilder sb = new StringBuilder();
		while (num1 > 0) {
			sb.append("0");
			num1 = num1 / 10;
		}
		while (num2 > 0) {
			sb.deleteCharAt(sb.length() - 1);
			num2 = num2 / 10;
		}
		return sb.toString();
	}

	static class Name implements Comparable<Name> {
		String ext;
		String city;
		long time;
		String index;

		Name(String ext, String city, long time) {
			this.ext = ext;
			this.city = city;
			this.time = time;
		}

		@Override
		public int compareTo(Name o) {
			if (this.time < o.time)
				return -1;
			if (this.time > o.time)
				return 1;
			return 0;
		}

		@Override
		public String toString() {
			return city + index + "." + ext;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((city == null) ? 0 : city.hashCode());
			result = prime * result + ((ext == null) ? 0 : ext.hashCode());
			result = prime * result + (int) (time ^ (time >>> 32));
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
			Name other = (Name) obj;
			if (city == null) {
				if (other.city != null)
					return false;
			} else if (!city.equals(other.city))
				return false;
			if (ext == null) {
				if (other.ext != null)
					return false;
			} else if (!ext.equals(other.ext))
				return false;
			if (time != other.time)
				return false;
			return true;
		}
	}

	static String getInputPhoto1() {
		StringBuilder meetingSchedule = new StringBuilder();
		meetingSchedule.append("photo.jpg, Warsaw, 2013-09-05 14:08:15" + "\n");
		meetingSchedule.append("john.png, London, 2015-06-20 15:13:22" + "\n");
		meetingSchedule.append("myFriends.png, Warsaw, 2013-09-05 14:07:13" + "\n");
		meetingSchedule.append("Eiffel.jpg, Paris, 2015-07-23 08:03:02" + "\n");
		meetingSchedule.append("pisatower.jpg, Paris, 2015-07-22 23:59:59" + "\n");
		meetingSchedule.append("BOB.jpg, London, 2015-08-05 00:02:03" + "\n");
		meetingSchedule.append("notrsns.png, Paris, 2015-09-01 12:00:00" + "\n");
		meetingSchedule.append("me.jpg, Warsaw, 2013-09-06 15:40:22" + "\n");
		meetingSchedule.append("a.png, Warsaw, 2016-02-13 13:33:50" + "\n");
		meetingSchedule.append("b.jpg, Warsaw, 2016-01-02 15:12:22" + "\n");
		meetingSchedule.append("c.jpg, Warsaw, 2016-01-02 14:34:30" + "\n");
		meetingSchedule.append("d.jpg, Warsaw, 2016-01-02 15:15:01" + "\n");
		meetingSchedule.append("e.png, Warsaw, 2016-01-02 09:49:09" + "\n");
		meetingSchedule.append("f.png, Warsaw, 2016-01-02 10:55:32" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:13:11");
		return meetingSchedule.toString();
	}

	static String getInputPhoto2() {
		StringBuilder meetingSchedule = new StringBuilder();
		meetingSchedule.append("photo.jpg, Warsaw, 2013-09-05 14:08:15" + "\n");
		meetingSchedule.append("john.png, London, 2015-06-20 15:13:22" + "\n");
		meetingSchedule.append("myFriends.png, Warsaw, 2013-09-05 14:07:13" + "\n");
		meetingSchedule.append("Eiffel.jpg, Paris, 2015-07-23 08:03:02" + "\n");
		meetingSchedule.append("pisatower.jpg, Paris, 2015-07-22 23:59:59" + "\n");
		meetingSchedule.append("BOB.jpg, London, 2015-08-05 00:02:03" + "\n");
		meetingSchedule.append("notrsns.png, Paris, 2015-09-01 12:00:00" + "\n");
		meetingSchedule.append("me.jpg, Warsaw, 2013-09-06 15:40:22" + "\n");
		meetingSchedule.append("a.png, Warsaw, 2016-02-13 13:33:50" + "\n");
		meetingSchedule.append("b.jpg, Warsaw, 2016-01-02 15:12:22" + "\n");
		meetingSchedule.append("c.jpg, Warsaw, 2016-01-02 14:34:30" + "\n");
		meetingSchedule.append("d.jpg, Warsaw, 2016-01-02 15:15:01" + "\n");
		meetingSchedule.append("e.png, Warsaw, 2016-01-02 09:49:09" + "\n");
		meetingSchedule.append("f.png, Warsaw, 2016-01-02 10:55:32" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:13:11" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:13:12" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:13:13" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:13:14" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:13:15" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:13:16" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:13:17" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:13:18" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:13:19" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:13:20" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:13:21" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:13:22" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:13:23" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:13:24" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:13:25" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:13:26" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:13:27" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:13:28" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:13:29" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:13:30" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:13:31" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:13:32" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:13:33" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:13:34" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:13:35" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:13:36" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:13:37" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:13:38" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:13:39" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:13:40" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:13:41" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:13:42" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:13:43" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:13:44" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:13:45" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:13:46" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:13:47" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:13:48" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:13:49" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:13:50" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:13:51" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:13:52" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:13:53" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:13:54" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:13:55" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:13:56" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:13:57" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:13:58" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:13:59" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:00" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:01" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:02" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:03" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:04" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:05" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:06" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:07" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:08" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:09" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:10" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:11" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:12" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:13" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:14" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:15" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:16" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:17" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:18" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:19" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:20" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:21" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:22" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:23" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:24" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:25" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:26" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:27" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:28" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:29" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:30" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:31" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:32" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:33" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:34" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:35" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:36" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:37" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:38" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:39" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:40" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:41" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:42" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:43" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:44" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:45" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:46" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:47" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:48" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:49" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:50" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:51" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:52" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:53" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:54" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:55" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:56" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:57" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:58" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:14:59" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:15:00" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:15:01" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:15:02" + "\n");
		meetingSchedule.append("g.jpg, Warsaw, 2016-02-29 22:15:03");
		return meetingSchedule.toString();
	}

}
