package CrackingTheCoding5th.Chap11;

public class MainSortingAndSearching {

	//#11.1 You are given 2 sorted arrays, A and B, where A has a
	// large enough buffer at the end to hold B. Merge them keeping sorted.
	public static void main(String[] args){
		int a[] = new int[6];
		int b[] = new int[]{4,5,9};
		
		a[0] = 1;
		a[1] = 3;
		a[2] = 6;
		
		SortingAndSearching.mergeWithOrder(a, b);
		for(int a2: a){
			System.out.println(a2);
		}
	}
}
