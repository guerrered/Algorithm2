
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
	//pairing with first suitor sets wrong index
	public static int[][] algorithm(int[][] mList, int[][] wList, int n){
		int[][] match = new int[n][2];//pairs of 2
		Person[] currentMatchesM = new Person[n];
		int i = 0;
		while(i < n){//cM index is women values at index is her match
			currentMatchesM[i] = new Person();
			i++;
		}
		Person[] currentMatchesW = new Person[n];
		i = 0;
		while(i < n){//cM index is women values at index is her match
			currentMatchesW[i] = new Person();
			i++;
		}
		int male = 1;
		int fullList = 0;
		while(fullList < n){//first round
			if(currentMatchesM[male-1].isSingle()){
				int woman = mList[male -1][currentMatchesM[male -1].getMyIndex()];//mans next choice
				if(currentMatchesW[woman-1].isSingle()){//no pair, woman accepts first suitor
					currentMatchesW[woman-1].setIndex(male);//index of her partner
					currentMatchesM[male-1].setMatch();//index of partner
					
					fullList++;
					male++;//go to next guy
				}
				else{//woman already matched see how new suitor is liked
					i =0;
					while(i < n){//find the index of the new man from woman POV
						if(wList[woman-1][i] == male){//found suitor before current partner, replace partner
							int oldPartner = currentMatchesW[woman -1].getMyIndex();//get old partner
							currentMatchesW[woman -1].setIndex(male);//replace from woman perspective
							currentMatchesM[male - 1].setMatch();//add woman
							currentMatchesM[oldPartner -1].setSingle();//set old partner to single & point to next woman
							male++;// go to next man
							break;
						}
						else if(wList[woman-1][i] == currentMatchesW[woman -1].getMyIndex()){//current partner found ahead of suitor
							currentMatchesM[male -1].incrementIndex();//point suitor to next prospect
							break;
						}
						i++;
					}
				}	
			}
			else{
				male++;
			}
			if(male > n){
				i = 0;
				while( i < n){
					if(currentMatchesM[i].isSingle()){
						male =  i+1;
						break;
					}
					i++;
				}
				if( i  >=n){break;}//no singles
			}
		}
		
		i =0;//array to return 
		while(i < n){
			match[i][0] = i + 1;
			match[i][1] = mList[i][currentMatchesM[i].getMyIndex()];
			
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
