package CrackingTheCoding5th.Chap11;

public class mainSortingAndSearching {

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
