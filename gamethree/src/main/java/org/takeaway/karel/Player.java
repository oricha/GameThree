package org.takeaway.karel;

public class Player {

    private long id;
    private int number;
    private int sum = 0;
    
    public Player(){
    	
    }
    public Player(int _id, int _number){
    	this.id = _id;
    	this.number = _number;
    	
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}
	public String toString(){
		return "Player id: "+id +" number:"+ number;
	}

}
