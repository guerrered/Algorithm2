
public class GS {
	public static void main(String [] args){
		int[][] mPref = generatePreference(10);
		int[][] wPref = generatePreference(10);
		System.out.println("\nMen's: \n");
		Printer(mPref, 10);
		System.out.println("\nWomen's: \n");
		Printer(wPref, 10);
	
		int[][] Matching = algorithm(mPref, wPref, 10);
		System.out.println("The stable matching is : \n");
		matchPrinter(Matching, 10);
	
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
		int[] currentMatchesM = new int[n];
		i = 0;
		while(i < n){//cM index is women values at index is her match
			currentMatchesM[i] = 0;
			i++;
		}
		int[] currentMatchesW = new int[n];
		i = 0;
		while(i < n){//cM index is women values at index is her match
			currentMatchesW[i] = 0;
			i++;
		}
		
		
		int male = 1;
		while(male < n){
			int nextChoice = currentMatchesM[male-1];
			int woman = mList[male-1][nextChoice];//return 1-10
			if(currentMatchesW[woman-1] == 0){//no pair woman accepts first suitor
				i =0;
				while(i < n){//find the index of the man from woman POV
					if(wList[woman-1][i] == male){
						currentMatchesW[woman-1] = i;
						currentMatchesM[male-1] = nextChoice;
						male++;//go to next guy
						break;
					}
					i++;
				}
			}
			else{//woman already matched
				i =0;
				while(i < n){//find the index of the new man from woman POV
					if(wList[woman-1][i] == male){
						break;
					}
					i++;
				}
				if(i < currentMatchesW[woman-1]){//if she likes new guy better match with him
					currentMatchesM[currentMatchesW[woman-1]]++;//that man will look to next person;
					currentMatchesW[woman-1] = i;
					male++;//go to next guy
				}
				else{//not liked
					currentMatchesM[male-1]++;//look to next woman in list
				}
			}
			if(male == n){//check if done no repeats
				
			}
		}
		i =0;
		while(i < n){
			match[i][0] = i + 1;
			match[i][1] = mList[i][currentMatchesM[i]];
			
			i++;
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
				int f = (int)(Math.random() * n + 1 );
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
