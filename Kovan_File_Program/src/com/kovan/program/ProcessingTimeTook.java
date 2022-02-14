package com.kovan.program;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class ProcessingTimeTook 
{
	public static void main(String[] args) throws IOException
	{
		File file = new File("ExternalFiles/demo.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String st;
		
		List<Integer> al=new ArrayList<Integer>();
		
        while ((st = br.readLine()) != null)
        {
        	String splt[] = st.split(" ");
        	int index=Arrays.asList(splt).indexOf("ProcessingTimeTook:");
        	String str=splt[index+1].replaceAll("[^\\d]", " ").trim();
        	if(!str.isEmpty())
        		al.add(Integer.parseInt(str));
        }
        OptionalDouble avg = al.stream().mapToInt(a -> a).average();
        Optional<Integer> max = al.stream().max((a,b) -> a.compareTo(b));
        System.out.println("Average Processing Time: "+avg.getAsDouble());
        System.out.println("Maximum Processing Time: "+max.get());
	}
}
