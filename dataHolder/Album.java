package dataHolder;
import java.util.ArrayList;
import src.poiExtractor.*;
import factories.*;
public abstract class Album {
	
	private String title;
	private ArrayList<Page> albumPage = new ArrayList<Page>();
	private IAlbumExtractorToPoi alEx; 
	PageFactory pageF=new PageFactory();
	public Album(String title){
			this.title=title;
			alEx = new AlbumExtractor (title);
	}
	
	public void showContents(){
		for (Page i: albumPage){
			alEx.addSlideExtractor(i.getPageEx());			
		}
		alEx.exportPOISlideShow();
	}
	
	public void showChronologically(){
		
		int y = 10000;

		for (Page i: albumPage){
			if (i.getYear()< y ){
				y= i.getYear();
			}
        }
		
		int counter = 0;
		
		while (counter <= albumPage.size()){
			for (Page i: albumPage){
				if (i.getYear() == y){
					for (int m = 1; m<13; m++){
						for (int d = 1; d<32; d++){
							if (i.getMonth()== m && i.getDay()== d){
								alEx.addSlideExtractor(i.getPageEx());
								counter++;
							}
					
						} 
			        }
				}
			}
			y++;
		}
		alEx.exportPOISlideShow();	
	}
	
	
	public void addNewPage(String kind,int day,int month,int year,String keyword)
	{
			//PageFactory pageF=new PageFactory();	
			albumPage.add(pageF.getPage(kind,day,month,year,keyword));
	}
	
	public String getTitle(){
			return title;
	}
	

	
	
	public Page findPage(int day, int month, int year, String keyword){
		for (Page i: albumPage){
			if (i.getDay() == day && i.getMonth()==month && i.getYear()==year && i.getKeyWord(keyword)){
				return i;
			}
		}
		return null;	
 	}
	
	
	
	public Album fillProducedAlbum(String keyword, Album myAlbum){
		for (Page i: albumPage){
			if (i.findKeyword(keyword)!= null){
				myAlbum.albumPage.add(i);
			}
		}
		return myAlbum;	
	}
	
	public boolean isEmpty(){
		if (albumPage.size()==0){
			return true;
		}
		return false;
	}
}
