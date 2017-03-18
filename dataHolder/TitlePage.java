package dataHolder;
import src.poiExtractor.*;

public class TitlePage extends Page {
	private IPageExtractorToPoi PaEx;
	private String title;
	public TitlePage(int day,int month,int year,String title,String keyword) {
		super(day,month,year,keyword);
		this.title=title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public void changeAll(int d, int m, int y, String k, String t){
		setDay(d);
		setMonth(m);
		setYear(y);
		setKeywords(k);
		setTitle(t);
	}
	
	public IPageExtractorToPoi getPageEx(){
		PaEx =new TitlePageExtractor(this.title);
		return PaEx;
	}

}