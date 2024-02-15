package src;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		List<List<Integer>> lists = new ArrayList<>();

		lists.add(new ArrayList<>());
		lists.add(new ArrayList<>());

		lists.get(0).add(0);
		lists.get(0).add(1);
		lists.get(0).add(2);
		lists.get(0).add(3);

		System.out.println(lists.get(0));
	}

}
