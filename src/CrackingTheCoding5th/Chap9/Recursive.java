package CrackingTheCoding5th.Chap9;

public class Recursive {
	//#9.1 A child can jump 1, 2 or 3 steps up stairs.
	// How many possibilities he has to arrive at the top.
	public static int possibilities(int n ){
		int r = 0;
		if(n==1) r=1;
		if(n==2) r=2;
		if(n==3) r=4;
		if(n>3) r+= possibilities(n-3) + possibilities(n-2) + possibilities(n-1);
		
		return r;
		
	}
}
