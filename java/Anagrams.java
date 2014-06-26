import java.util.*;


public class Anagrams {
	public List<String> anagrams(String[] strs) {
		//only one anagrams possible?
		List<String> list = new ArrayList<String>();
		if (strs == null || strs.length == 0) {
			return list;
		}
		Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

		for (String s : strs) {
			//remember string to arrays arrays to string
			char[] chars = s.toCharArray();
			Arrays.sort(chars);
			String tmp = new String(chars);
			//remember map.put, map.get
			if (map.get(tmp) == null) {
				ArrayList<String> newAnagrams = new ArrayList<String>();
				newAnagrams.add(s);
				map.put(tmp, newAnagrams);
			}
			else {
				map.get(tmp).add(s);
			}
		}


		for (String key : map.keySet()) {
			ArrayList<String> anagram = map.get(key);
			if (anagram.size() > 1) {
				list.addAll(anagram);
			}
		}
		return list;
	}

}