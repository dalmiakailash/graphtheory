import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
	Problem: Given a arrays A and B of size N where A[K] and B[K] represents a path between 2 cities.
	
	0<=K<N
	
	We need to find out if all pairs of city ends up in same city(called Rome City).
	
	e.g:
	
	A={0, 1, 2, 4, 5}, B = {2, 3, 3, 3, 2}
	so we have
	0 ---> 2
	1 ---> 3
	2 ---> 3
	4 ---> 3
	5 ---> 2
	
	Output : 3
	Explanation : 3 can be reached directly from city 1, 2, and 4
				  3 can be reached indirectly from 0 and 5 via 2
				  All cities have connectivity to "3" either direct or via, 
				  hence Rome city is "3"
**/
class RomeCity {
	public int solution(int[] A, int[] B) {
		if (A.length < B.length) {
			return -1;
		}
		final Map<Integer, Integer> ab = new HashMap<>();
		final Map<Integer, Integer> ba = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			final int a = A[i];
			final int b = B[i];
			if (ab.isEmpty()) {
				ab.put(a, b);
				ba.put(b, a);
			} else {
				ab.put(a, ab.getOrDefault(b, b));
				ba.put(b, a);
				if (ba.containsKey(a)) {
					ab.put(ba.get(a), b);
				}
			}
		}
		if (new HashSet<>(ab.values()).size() > 1) {
			return -1;
		}
		return ab.values().iterator().next();
	}

	public int solution2(int[] A, int[] B) {
		if (A.length < B.length) {
			return -1;
		}
		final int[] C = new int[A.length];

		final Map<Integer, Integer> ab = new HashMap<>();
		final Map<Integer, Integer> ba = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			final int a = A[i];
			final int b = B[i];
			if (ab.isEmpty()) {
				ab.put(a, b);
				ba.put(b, a);
			} else {
				ab.put(a, ab.getOrDefault(b, b));
				ba.put(b, a);
				if (ba.containsKey(a)) {
					ab.put(ba.get(a), b);
				}
			}
		}
		if (new HashSet<>(ab.values()).size() > 1) {
			return -1;
		}
		return ab.values().iterator().next();
	}

	public static void main(String[] args) {
		System.out.println(new Solution().solution(new int[] {0, 1, 2, 4, 5}, new int[] {2, 3, 3, 3, 2}));
		System.out.println(new Solution().solution(new int[] {1,2,3}, new int[] {0,0,0}));
		System.out.println(new Solution().solution(new int[] {2,3,3,4}, new int[] {1,1,0,0}));
		System.out.println(new Solution().solution(new int[] {0, 1, 2, 4, 5, 6}, new int[] {2, 3, 3, 3, 2, 2}));
		System.out.println(new Solution().solution(new int[] {0, 1, 2, 4, 5, 6}, new int[] {2, 3, 3, 3, 2, 0}));
		System.out.println(new Solution().solution(new int[] {0, 1, 2, 4, 5, 5}, new int[] {2, 3, 3, 3, 2, 6}));
		System.out.println(new Solution().solution(new int[] {0, 1, 2, 4, 5, 6}, new int[] {2, 3, 3, 3, 2, 5}));
		System.out.println(new Solution().solution(new int[] {0, 1, 3, 4, 5, 6}, new int[] {3, 2, 2, 2, 3, 5}));
		System.out.println(new Solution().solution(new int[] {0, 1, 3, 4, 5, 7}, new int[] {3, 2, 2, 2, 3, 4}));

		System.out.println(new Solution().solution(new int[] {0, 1, 3, 4, 5, 7, 8, 10, 13, 15, 17, 20}, new int[] {3, 2,
				2, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
		//System.out.println(new Solution().solution(new int[] {0, 1, 3, 4, 5, 7}, new int[] {3, 2, 2, 2, 3, 4}));
		//System.out.println(new Solution().solution(new int[] {0, 1, 3, 4, 5, 7}, new int[] {3, 2, 2, 2, 3, 4}));
	}
}
