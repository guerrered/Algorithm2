
public class Person {
	int myIndex = 0;
	boolean single = true;
	Person match;
	
	public Person(){
	}
	public void setIndex(int index){
		single = false;
		myIndex = index;
	}
	public int getMyIndex(){
		return myIndex;
	}
	public boolean isSingle(){
		return single;
	}
	
	public void setSingle(){
		myIndex++;
		single = true;
	}
	public void incrementIndex(){
		myIndex++;
	}
	public Person getMatch(){
		return match;
	}
}
