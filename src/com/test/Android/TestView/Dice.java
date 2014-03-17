package com.test.Android.TestView;



import java.util.ArrayList;
import java.util.Arrays;//.<----Not used but left for those who need it when changing the code.//
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;


public class Dice {
	//.Publicly used object references
	private Random r = new Random();
	private Scanner s = new Scanner(System.in);
	
	//.Fields parallel arrays to facilitate shorter coding as well as to check the selected dice against it's sides
	private String[] diceName= {"d4" , "d6" , "d8" , "d10" , "d12" , "d20"};
	private int[] diceSides = {4 , 6 , 8 , 10 , 12 , 20}; 
	private ArrayList<String> selectedDice = new ArrayList<String>();
	private int numberOfDice;
	
	//.Constructors to set the dice from there or have no selected dice by default
	public Dice() {	}
	
	//.SETS FOR ONLY ONE DIE CONSTRUCTOR
	public Dice(String selectedDie) {
		for (int i = 0; i < diceSides.length; i++) 
			if(this.diceName[i].equals(selectedDie.toLowerCase())) {
				this.selectedDice.add(selectedDie.toLowerCase());
				break;
			}
	}
	
	//.Sets the number of dice to use as well as asks the user which dice to use CONSTRUCTOR
	public Dice(int numberOfDice) {
		this.numberOfDice = numberOfDice;
		for(int i = 0 ; i < this.numberOfDice ; i++) {
			String choice = s.next().toLowerCase(); //.------>Change this line of code to match whatever input you are using<------.//
			for(int j = 0 ; j < this.diceName.length ; j++)
				if(this.diceName[j].equals(choice))
					this.selectedDice.add(choice);					
		}
	}
	
	public void setNumberOfDice(int numberOfDice) {
		this.numberOfDice = numberOfDice;
	}
	
	public int getNumberOfDice() {
		return this.numberOfDice;
	}
	
	//.sets the selected Dice to the proper and needed die ONLY ONE DIE
	public void setSelectedDice(String selectedDie) {
		if(this.selectedDice.contains(selectedDie) == true)
			for (int i = 0; i < this.diceSides.length; i++) 
				if(this.diceName[i].equals(selectedDie.toLowerCase())) {
					this.selectedDice.add(selectedDie.toLowerCase());
					break;
				}
	}
	
	//.Use if the user needs to or wants to use more than one die
	public void setMultipleDice() {
		for(int i = 0 ; i < this.numberOfDice ; i++) {
			String choice = s.next().toLowerCase(); //.------>Change this line of code to match whatever input you are using<------.//
			for(int j = 0 ; j < this.diceName.length ; j++)
				if(this.diceName[j].equals(choice))
					this.selectedDice.add(choice);					
		}
	}
	
	public String[] getSelectedDie() {
		Collections.sort(this.selectedDice);
		String[] result = new String[this.selectedDice.size()];
		int i = 0;
		for (String string : this.selectedDice)
			result[i++] = string;
		return result;
	}
	
	//.Rolls the selected die
	public int[] rollDice() {
		Collections.sort(this.selectedDice);
		int[] results = new int[this.selectedDice.size()]; 
		int counterForResults = 0;
		for(String item : selectedDice)
			for (int i = 0; i < this.diceSides.length; i++) 
				if(item.equals(this.diceName[i]))
					results[counterForResults++] = r.nextInt(this.diceSides[i]) + 1;
		return results;	
	}
	
	//.Removes all the dice from the selectedDie Array List field 
	public void resetDice() {
		this.selectedDice.removeAll(this.selectedDice);
	}
	
	//.Gets a percent if needed (acts as a 10 sided die essentially returning "00,10,20,etc."
	public int getPercent() {
		return r.nextInt(11) * 10;
	}
	
	//.Essentially acts as coin, returns 0 for "heads" or 1 for "tails"
	public boolean flipCoin() {
		if(r.nextInt(2) == 0)
			return true;
		else
			return false;
	}
}
