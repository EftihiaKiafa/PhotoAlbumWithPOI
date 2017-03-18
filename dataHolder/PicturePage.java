package dataHolder;

import src.poiExtractor.*;
public class PicturePage extends Page {
	private IPageExtractorToPoi PaEx;
	private String title;
	private String path;
	public PicturePage(int day,int month,int year,String title,String keyword,String path) {
		super(day,month,year,keyword);
		this.title=title;
		this.path=path;
	}

	public void setTitle (String title){
		this.title=title;
	}
	
	public void setPath (String path){
		this.path=path;
	}
	
	public void changeAll(int y, int m, int d, String k, String t,String p){
		setDay(d);
		setMonth(m);
		setYear(y);
		setKeywords(k);
		setTitle(t);
		setPath(p);
	}
	
	public IPageExtractorToPoi getPageEx(){
		PaEx=new PicturePageWResizablePicExtractor(this.title,this.path);
		return PaEx;
		
	}
}
