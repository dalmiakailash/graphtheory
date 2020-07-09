
/**
	With given tree a node will be called visible only when it is greater than root node.
	
	e.g. : We have a tree as follows:
	
				 5
				/ \
			   /   \
			  3    10
			 / \    /
			/   \  1
		   20   21
		   
	As shown in above tree we have root node 5 which will always be visible.
	
	|NODE|		VISIBLE|		REASON|
	|   5|			  T|		  ROOT|
	|  10|			  T|		  10>5|
	|   1|			  F|		  1<10|
	|   3|			  F|		   3<5|
	|  20|			  T|		  20>3|
	|  21|			  T|		  21>3|
	
	As illustrated above only 4 nodes will be visible. Hence answer is 4.
			
**/
public class VisibleNodes {

	private static class Tree {
		public int x;
		public Tree l;
		public Tree r;

		public Tree(final int x, final Tree l, final Tree r) {
			this.x = x;
			this.l = l;
			this.r = r;
		}
	}

	public int solution(Tree root) {
		int max = root.x;
		int[] counter = new int[]{0};
		visibility(root, max, counter);
		return counter[0];
	}

	public void visibility(Tree T, int max, final int[] counter) {
		if(T != null){
			if(T.x >= max){
				counter[0]++;
			}
			visibility(T.l, max, counter);
			visibility(T.r, max, counter);
		}
	}

	public static void main(String[] args) {
		System.out.println(new TreeSolution().solution(new Tree(5,
				new Tree(3, new Tree(20, null, null), new Tree(21, null, null)),
				new Tree(10, new Tree(1, null, null), null))));

		System.out.println(new TreeSolution().solution(new Tree(8,
				new Tree(2, new Tree(8, null, null), new Tree(7, null, null)),
				new Tree(6, null, null))));

		System.out.println(new TreeSolution().solution(new Tree(11,
				new Tree(2, new Tree(8, null, null), new Tree(7, null, null)),
				new Tree(6, null, null))));
	}
}
