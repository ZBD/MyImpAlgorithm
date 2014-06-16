package MyDataStructure;

import java.util.*;

public class MagicSet<T> {
	private List<T> list;
	private Map<T, Integer> map;

	public MagicSet() { 
		//****************generic class's constructor don't need <T>!!!!!!!!!!!!!!!!! *******/
		list = new ArrayList<T>();
		map = new HashMap<T, Integer>();
	}

	public MagicSet(int initialCapacity) {
		//****************generic class's constructor don't need <T>!!!!!!!!!!!!!!!!! *******/
		list = new ArrayList<T>(initialCapacity);
		map = new HashMap<T, Integer>(initialCapacity);
	}

	public void insert(T t) {
		//to do
			list.add(t);
			map.put(t, list.size()-1);
	}

	public boolean delete(T t) {
		//return true when deleted, false when it is not exists in the set
		if (map.get(t) == null) return false;
		int index = map.get(t);
		T last = list.get(list.size()-1);
		map.put(last, index);
		list.set(index, last);
		list.remove(list.size()-1);
		return true;
	}

	public T getRandom() {
		int index = (int)(Math.random()*list.size()); /*** need to ( ) the whole expression after (int)!!!!!!!!!!!!!!!!!!!!!!1**/
		return list.get(index);
	}

	public boolean contains(T t) {
		return map.get(t) != null;
	}
	
	public static void main(String[] args) {
		MagicSet<Integer> ms = new MagicSet<Integer>();
		ms.insert(100);
		ms.insert(50);
		ms.insert(30);
		System.out.println(ms.contains(99));
		System.out.println(ms.contains(50));
		System.out.println(ms.getRandom());
		System.out.println(ms.delete(50));
	}
} 