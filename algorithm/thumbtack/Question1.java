package algorithm.thumbtack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question1 {
	public List<String> bestPros(int k){
		List<String> l=new ArrayList<>();
		
		Collections.sort(l);
		return l.subList(0, k);
	}
}
