package CrackingTheCoding5th.Chap11;

public class SortingAndSearching {

	public static void mergeWithOrder(int[] a, int[] b){
		int bigA = a.length-1;
		int bigB = b.length-1;
		int lastPosA = a.length-1;
		
		
		while(a[bigA] == 0){
			bigA--;
		}
		
		for(int i = lastPosA; i> -1; i--){
			if(bigB != -1 && b[bigB] >= a[bigA]){
				a[lastPosA--] = b[bigB];
				
				bigB--;
			}else{
				a[lastPosA--] = a[bigA];
				bigA--;
			}
		}
		
		
	}
}
