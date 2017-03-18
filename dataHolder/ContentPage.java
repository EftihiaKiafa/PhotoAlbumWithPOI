package dataHolder;

import src.poiExtractor.*;
public class ContentPage extends Page{
	private IPageExtractorToPoi PaEx;
	private String text;
	private String title;
	public ContentPage(int day,int month,int year,String title,String keyword,String text) {
		super(day,month,year,keyword);
		this.title=title;
		this.text=text;
	}

	public void setTitle (String title){
		this.title=title;
	}
	
	public void setText (String text){
		this.text=text;
	}
	
	public void changeAll(int y, int m, int d, String k, String t,String c){
		setDay(d);
		setMonth(m);
		setYear(y);
		setKeywords(k);
		setTitle(t);
		setText(c);
	}
	
	public IPageExtractorToPoi getPageEx(){
		PaEx=new ContentPageExtractor(this.title,this.text);
		return PaEx;
		
			
	}

}
