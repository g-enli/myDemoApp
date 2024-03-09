package com.mycompany.app;

import java.util.Collections;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class App 
{
    
    static HashMap<String, Integer> player_value = new HashMap<>();
    static ArrayList<Integer> sortedValues = new ArrayList<>();
    
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    
    public static boolean search(ArrayList<Integer> array, int e) {
    System.out.println("inside search");
	if (array == null) return false;
	    for (int elt : array) {
		 if (elt == e) return true;
	    }
    return false;
    }
    
    public static boolean addedToHashMap(ArrayList<String> playerNames,ArrayList<Integer> playerCoins,ArrayList<Integer> playerGems,int gemValue) {
    System.out.println("let's start counting!");
    int commonSize=playerNames.size();
	if (playerNames == null || playerCoins == null || playerGems == null) return false;//we don't want arraylists to be null(nullpointer exception)
	if (playerCoins.size()!=commonSize || playerGems.size()!=commonSize) return false;
	if (gemValue<=0) return false;
	//gem ya da coin negatif olabilir mi? (emin değilim)
	    for (int i=0;i<playerNames.size();i++) {
	    	 String name=playerNames.get(i);
	    	 int total=playerCoins.get(i)+playerGems.get(i)*gemValue;
		 player_value.put(name,total);
		 sortedValues.add(total);
	    }
	    Collections.sort(sortedValues);
    return true;
    }
    public static void printOrdered(ArrayList<String> playerNames,ArrayList<Integer> playerCoins,ArrayList<Integer> playerGems,int gemValue){
    	if(!addedToHashMap(playerNames, playerCoins, playerGems, gemValue)) return;
    	for(int i=0;i<sortedValues.size();i++){
    	int point=sortedValues.get(i);
    	System.out.println((i+1)+"."+player_value.get(point)+"  "+point);
    	player_value.remove(player_value.get(point));//aynı totale sahip kişilerde aynı isimi dönüp diye
    	}
    }  
}
