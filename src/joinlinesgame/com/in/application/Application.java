package joinlinesgame.com.in.application;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Application {

	public static void printGrid(final Integer rows, final Integer columns, final String edge) {
		long cellNumber = 1;
		for(int i=0; i<rows; i++) {
			int barIndex = 0;
			for(int j=0; j<columns; j++) {
				System.out.print("---");
				System.out.print(cellNumber++);
				System.out.print("---");
				System.out.print("|");				
			}
			System.out.println("");
		}
	}
	
	public static void main(String[] args) {
		
		Map<String, List<String>> dataset;
		try {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Enter Dimentions ::");
			System.out.println("Please enter number of points in row ::");			
			Integer rows = Integer.parseInt(br.readLine());
			
			System.out.println("Please enter number of points column ::");
			Integer columns = Integer.parseInt(br.readLine());
			
			dataset = new LinkedHashMap<>();
			long cellNumber = 1;
			
			for(int i=0; i<rows-1; i++) {
				for(int j=0; j<columns-1; j++) {					
					int X = i, Y = j;					
					String side1 = X + "" + Y + X + "" + (Y +1),
						   side2 = X + "" + Y + (X+1) + "" + Y,
						   side3 = X + "" + (Y+1) + (X+1) + "" + (Y +1),
						   side4 = (X+1) + "" + Y + (X+1) + "" + (Y +1);
					List<String> sides = new LinkedList<>();
					sides.add(side1);sides.add(side2);sides.add(side3);sides.add(side4);					
					dataset.put(cellNumber+"", sides);					
					cellNumber++;
				}
			}
			
			for(Entry<String, List<String>> value :  dataset.entrySet()) {
				System.out.println("Key["+value.getKey() + "]="+value.getValue());
			}
			
			printGrid(rows,columns,"");
			
			String player = "A";
			int aCells =0, bCells =0, cellcounter =0;
			boolean oneMoreChance = false;
			
			while(true) {
						
				System.out.println("\n\nIt's palyer "+ player +"'s Turn:");
				System.out.println("Please enter start of point of edge:");			
				String start = br.readLine();
				System.out.println("Please enter start of point of edge:");			
				String end = br.readLine();
				
				String edge = start + end;
				String reverse = end + start; // In any user specify the side in other order.

				for(Entry<String, List<String>> value :  dataset.entrySet()) {
					List<String> currentEdges = value.getValue();
					if(currentEdges.size() == 0) cellcounter++;
					if(currentEdges.contains(edge) || currentEdges.contains(reverse) ) {
						currentEdges.remove(edge);
						currentEdges.remove(reverse);
						if(currentEdges.size() == 0) {
							// win condition for player continue with that player.
							oneMoreChance = true;
							if(player.equalsIgnoreCase("A")) {
								aCells++;
							} else {
								bCells++;
							}
							
						}						
					}
				}
				
				for(Entry<String, List<String>> value :  dataset.entrySet()) {
					System.out.println("Key["+value.getKey() + "]="+value.getValue());
				}
				if(dataset.size() == cellcounter) {
					break;
				} else {
					if(!oneMoreChance && player.equalsIgnoreCase("A")) {
						player = "B";						
					} else if (!oneMoreChance && player.equalsIgnoreCase("B")) {
						player = "A";
					}
				}
				
				oneMoreChance= false;
				cellcounter=0;				
			}
			
			System.out.println("A ="+aCells + ", B="+bCells);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e);
		}

	}

}
