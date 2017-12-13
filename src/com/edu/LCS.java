package com.edu;

public class LCS {
	private static int count = 0;
	public static void main(String[] args) {
		count=0;
		char[] s1 = {'G','A','A','T','T','C','A','G','T','T','A'};
		char[] s2 = {'G','G','A','T','C','G','A'};
		double x = findLCS(s1,s2,s1.length,s2.length);
		System.out.println("Count = "+count);
		System.out.println(x);
		count=0;
		String s3 = "GAATTCAGTTA";
		String s4 = "GGATCGA";
		
		double x1 = LCSMemoized(s3,s4);
		System.out.println("Count = "+count);
		System.out.println(x1);
	
	}
	public static double findLCS(char[] s1, char[] s2,int m, int n) {
		count++;
		if (m == 0) {
			return 0;
		}
		else if (n == 0) {
			return 0;
		}
		else if(s1[m-1] == s2[n-1]) {
			return findLCS(s1,s2,m-1,n-1)+1;
		}
		else {
			return Math.max(findLCS(s1, s2, m, n-1), findLCS(s1, s2, m-1, n));

		}

	}
	
	
	public static int LCSMemoized(String s1, String s2,int m,int n,int[][] L) {
		count++;
		if(L[m][n] < 0) {
			if(m==0) {
				
				L[0][n] = 0;
			}
			else if( n == 0) {
				L[m][0] = 0;
			}
			else if(s1.charAt(m-1)== s2.charAt(n-1)) {
				L[m][n] = LCSMemoized(s1,s2,m-1,n-1,L) + 1;
			}
			else {
				L[m][n] = Math.max(LCSMemoized(s1,s2,m,n-1,L), LCSMemoized(s1,s2,m-1,n,L));
			}	
		}
		return L[m][n];
	}
	public static int LCSMemoized(String s1, String s2) {
		int x = s1.length()-1;
		int y = s2.length()-1;
		int[][] L = new int[x+1][y+1];
		for(int i=0;i<=x;i++) {
			for(int j=0;j<=y;j++) {
				L[i][j]= -1;
			}
		}
		return LCSMemoized(s1,s2,x,y,L);
	}

}
