package cn.com.mx.list;

public class Squaretest {
	private static int cout(int[][] a, int m, int n) {
		// TODO Auto-generated method stub
		int max=-1;
		for(int i=1;i<m;i++)
		for(int j=1;j<n;j++){
		if(a[i][j]==1){
		int min=a[i-1][j-1];
		if(a[i-1][j]<min)
		min=a[i-1][j];
		if(a[i][j-1]<min)
		min=a[i][j-1];
		a[i][j]+=min;
		if(max<a[i][j])	
		   max=a[i][j];
		}
		}
		return max;
		}
	public static void main(String[] args) {
		int[][] a = {
				{0,1,1,1,1},
				{0,1,1,1,1},
				{1,1,1,1,1},
				{0,0,0,0,0}
		};
		Squaretest.cout(a, 5, 4);
		
		
	}
}
