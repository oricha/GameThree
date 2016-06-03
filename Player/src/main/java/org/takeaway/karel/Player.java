package org.takeaway.karel;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class Player {

    private long id;
    private int number;
    @Min(-1)
    @Max(1)
    private int sum = 0;
    private boolean automatic = false;

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
	public boolean isAutomatic() {
		return automatic;
	}
	public void setAutomatic(boolean automatic) {
		this.automatic = automatic;
	}


}
