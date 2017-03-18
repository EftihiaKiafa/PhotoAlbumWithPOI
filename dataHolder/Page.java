package dataHolder;
import java.util.ArrayList;
import src.poiExtractor.*;

public abstract class Page {
	
	private int day;
	private int month;
	private int year;
	private ArrayList<String>keyWords=new ArrayList<String>();
	//private IPageExtractorToPoi PaEx;
	
	public Page(int day,int month,int year,String keyword) {
		this.day=day;
		this.month=month;
		this.year=year;
		keyWords.add(keyword);
	}
	public Page findKeyword(String keyword){
		for (String i : keyWords){
			if(keyword.equals(i)){
				return this;
			}
		}
		return null;
	}
	abstract IPageExtractorToPoi getPageEx();
	
	public int getDay() {
		return day;
	}
	public int getMonth() {
		return month;
	}
	public int getYear() {
		return year;
	}
	public boolean getKeyWord(String keyword) {		
		for (String i : keyWords){
			if(keyword.equals(i)){
				return true;
			}
			
		}
		return false;
	}
	
	public void setDay(int day) {
		this.day = day;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public void setKeywords(String keyword){
		String k = keyword;
		String[] parts = k.split(",");
		keyWords.clear();
		for (int i=0; i < parts.length; i++){
			this.keyWords.add (parts[i]);
		}	
	}
	

}
