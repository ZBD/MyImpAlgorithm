package MyDataStructure;

import java.util.*;

/**
 * Write the code using an optimization algriothm to calcuate the 
 * intersection and union of two sets.
 */
//you should add type to the class
public class MySet<T> {

public Set<T> intersection(Set<T> set1, Set<T> set2) {
	if (set1 == null || set2 == null) {
		//what to return? An empty set, null, or throw an exception
		return new HashSet<T>();
	}

	//now set1 != null && set2 != null
	//in order to keep the input set unaffect, i'll create a new set
	Set<T> inter = new HashSet<T>(set1);
	inter.retainAll(set2);
	return inter;
}

public Set<T> union(Set<T> set1, Set<T> set2) {
	//what about set1 and set2 are both null? I would return null or empty or throw an exception
	if (set1 == null && set2 == null) {
		return null;
	}

	//I want the input set unaffected, so create a new set. So that the caller make changes to the union will not affect set1 or set2
	if (set1 == null) {
		return new HashSet<T>(set2);
	}
	
	if (set2 == null) {
		return new HashSet<T>(set1);
	}

	Set<T> union = new HashSet<T>(set1);
	union.addAll(set2);
	return union;
}

}
