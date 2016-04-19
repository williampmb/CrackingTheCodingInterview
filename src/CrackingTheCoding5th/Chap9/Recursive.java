package CrackingTheCoding5th.Chap9;

public class Recursive {
	//#9.1 A child can jump 1, 2 or 3 steps up stairs.
	// How many possibilities he has to arrive at the top.
	public static int possibilities(int n ){
		int r = 0;
		if(n==1) r+=1;
		if(n==2) r+=2;
		if(n>=3) r+= 2*(4* possibilities(n-3))  -1;
		
		return r;
		
	}
}
