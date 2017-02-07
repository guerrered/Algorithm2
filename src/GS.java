
public class GS {
	public static void main(String [] args){
		int[][] mPref = generatePreference(10);
		int[][] wPref = generatePreference(10);
		System.out.println("\nMen's: \n");
		Printer(mPref, 10);
		System.out.println("\nWomen's: \n");
		Printer(wPref, 10);
	/*
		int[][] Matching = algorithm(mPref, wPref, 10);
		System.out.println("The stable matching is : \n");
		matchPrinter(Matching, 10);
	*/
	}
	
	public static int[][] algorithm(int[][] mList, int[][] wList, int n){
		int[][] match = new int[n][2];//pairs of 2
		int i = 0;
		while(i < n){
			int j = 0; 
			while( j < 2){
				match[i][j] =0;
				j++;
			}
			i++;
		}
		int Full = 0;//int tied to matchlist
		while( Full < n){
			int m = 1;//starting with man 1
			i = 0;//find the first single man
			if(m == match[i][0]){
				m++;
				i++;
			}
		}
		
	
		return match;
	}
	public static void matchPrinter(int[][] x,int n){
		int  i = 0;
		while(i < n){
			int j =0; 
			while( j < 2){
				System.out.print(x[i][j] + ", ");
				j++;
			}
			System.out.println("\n");
			i++;
		}
	}
	public static int[][] generatePreference(int n){
		int[][] PList = new int[n][n];
		boolean[] used = new boolean[n];
		int i= 0, j = 0;
		while(i < n){
			used[i] = false;
			i++;
		}
		i = 0;
		while( i < n ){
			while(j < n ){
				boolean found = false;
				int f = (int)(Math.random() * n + 1);
				while(!found){
					if(used[f -1] == true){
						f = (int)(Math.random() * n + 1);
					}
					else {
						used[f-1] = true;
						found = true;
					}
				}
				PList[i][j] = f;
				j++;
			}
			j = 0;
			while(j < n ){
				used[j] = false;j++;
			}
			j = 0;
			i++;
		}
		return PList;
	}
	public static void Printer(int[][] x, int n){
		int i= 0, j =0;
		while(i < n){
			while(j < n){
				System.out.print(x[i][j] + ", ");
				j++;
			}
			System.out.println("\n");
			j = 0;
			i++;
		}
		
	}
}
