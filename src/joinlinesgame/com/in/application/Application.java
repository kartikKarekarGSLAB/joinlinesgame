package joinlinesgame.com.in.application;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Application {

	
	public static void main(String[] args) {
		
		Map<String, List<String>> dataset;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Enter Dimentions ::");
			System.out.println("Enter Number of rows ::");			
			Integer rows = Integer.parseInt(br.readLine());
			
			System.out.println("Enter Number of columns ::");
			Integer columns = Integer.parseInt(br.readLine());
			
			dataset = new HashMap<>();
			long cellNumber = 1;
			
			for(int i=0; i<rows-1; i++) {
				for(int j=0; j<columns-1; j++) {					
					int X = i, Y = j;
					String side1 = X + "" + Y + "" + X + "" + (Y +1);
					String side2 = X + "" + Y + "" + (X+1) + "" + Y;
					String side3 = X + "" + (Y+1) + "" + (X+1) + "" + (Y +1);
					String side4 = (X+1) + "" + Y + "" + (X+1) + "" + (Y +1);
					dataset.put(cellNumber+"BLOCK", Arrays.asList(side1,side2,side3,side4));
					
					cellNumber++;
				}
			}
			
			dataset.entrySet().forEach(entry->{
			    System.out.println(entry.getKey() + " " + entry.getValue());  
			 });
			
		} catch (Exception e) {
			
		}

	}

}
