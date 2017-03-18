package dataHolder;

import src.poiExtractor.*;

public class BlankPage extends Page{
	private IPageExtractorToPoi PaEx;
	public BlankPage(int day,int month,int year,String keyword) {
		super(day,month,year,keyword);
	}
	
	public void changeAll(int d, int m, int y, String k){
		setDay(d);
		setMonth(m);
		setYear(y);
		setKeywords(k);
	}

	public IPageExtractorToPoi getPageEx(){
		PaEx =new BlankPageExtractor();
		return PaEx;
	}
}	
