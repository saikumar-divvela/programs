/*
	Comparable & Comparator example
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class DVDInfo implements Comparable<DVDInfo>
{
	protected String title;
	protected String language;
	
	DVDInfo(String title,String language){
		this.title = title;
		this.language = language;
	}
	
	public int compareTo(DVDInfo d1){
		return (this.title.compareTo(d1.title));
	}

	public String toString(){
		return (title+","+language+"\n");
	}
	
	private static void populateList(List<DVDInfo> dvdList){
		dvdList.add(new DVDInfo("Ghost in Water","English"));
		dvdList.add(new DVDInfo("A man without brain","No Dialogues"));
	}

	public static void main(String args[]){
		ArrayList<DVDInfo> dvdList = new ArrayList<DVDInfo>();
		populateList(dvdList);
		System.out.println(dvdList);
		Collections.sort(dvdList);
		System.out.println("sorted list based on title: \n"+dvdList);
		LanguageSort langSort = new LanguageSort();
		Collections.sort(dvdList,langSort);
		System.out.println("sorted list based on language: \n"+dvdList);
	}
	/* Static Inner class example */
	/*
	static class LanguageSort implements Comparator<DVDInfo> 
	{
		public int compare(DVDInfo d1,DVDInfo d2){
			return (d1.language.compareTo(d2.language));
		}
	}
	*/
}

class LanguageSort implements Comparator<DVDInfo> 
{
	public int compare(DVDInfo d1,DVDInfo d2){
		return (d1.language.compareTo(d2.language));
	}
}

