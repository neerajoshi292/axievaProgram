package com.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class CountWordFromFile {
	
	public void countWords1()
	{
		FileReader fr= null;
		
		try {
			fr= new FileReader("F:\\axieva.txt");
			BufferedReader br= new BufferedReader(fr);
			
			String word= null;
			String sb1= new String();
			
			while((word= br.readLine())!=null)
			{
				sb1 += word + " ";
			}

			String splt[]= sb1.split(" ");
			int count;
			int visit=-1;
			int freq[] = new int[splt.length];
			
			for(int i=0;i<splt.length;i++)
			{
				count=1;
				for(int j=i+1;j<splt.length;j++)
				{
					if(splt[i].equals(splt[j]))
					{
						count++;
						freq[j]= visit;
					}
				}
				if(freq[i]!=visit)
				{
					freq[i]=count;
				}
			}
			
			System.out.println("count the freq. of the word int the file: ");
			
			
			for(int i=0;i<freq.length;i++)
			{
				if(freq[i]!=visit)
				{
					System.out.println(splt[i]+"  "+freq[i]);
				}
			}		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void countWords2()
	{
			HashMap<String, Integer> hm= null;	
			FileReader reader= null;
			
		try {	
			reader= new FileReader("F:\\axieva.txt");
			BufferedReader br= new BufferedReader(reader);
			
			String line=null;
			StringBuilder sb= new StringBuilder();
			
			while((line=br.readLine())!=null)
			{
				sb.append(line).append(" ");
			}
			
			String[] splt = sb.toString().split(" ");
			
			hm= new HashMap<>();
			
			for(int i=0;i<splt.length;i++)
			{
				if(hm.containsKey(splt[i]))
				{
					int count= hm.get(splt[i]); 
					hm.put(splt[i], count+1);
				}
				else {
					hm.put(splt[i], 1);
				}
			}
			
			System.out.println("count the freq. of the word int the file: ");
			
			hm.forEach((word, num)-> System.out.println(word+" "+num));
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void fileWriteing()
	{
		FileWriter file1= null;
		try {
			file1= new FileWriter("F:\\axieva.txt");
			file1.write("The literary device in which a phrase or word is repeated at the beginning of consecutive lines or clauses is known as anaphora. Apart from adding emphasis to the selected words it contributes to the rhythm of a poem");
		
			file1.close();
		}catch(IOException e)
		{
			System.out.println("Exxception thrown: "+e.getMessage());
		}
		System.out.println("file created and write");
	}
	
		
	public void display()
	{
		countWords1();
//		fileWriteing();
//		countWords2();

	}
	
	
	
	public static void main(String[] args) {
		
		CountWordFromFile cwff= new CountWordFromFile();
		cwff.display();
		
	}
}
