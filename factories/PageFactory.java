package factories;
import dataHolder.*;
import java.util.Scanner;
public class PageFactory{
	public Page getPage(String choice,int day,int month,int year,String keyword){	
		if(choice.equals("BlankPage")){
			return new BlankPage(day,month,year,keyword);
		}else if(choice.equals("ContentPage")){			
			Scanner s=new Scanner(System.in);
			System.out.println("Please give a text:");
			String text=s.next();
			System.out.println("Please give a title:");
			String title=s.next();
			return new ContentPage(day,month,year,title,keyword,text);
		}else if(choice.equals("PicturePage")){
			Scanner s=new Scanner(System.in);
			System.out.println("Please give a path:");
			String path=s.next();
			System.out.println("Please give a title:");
			String title=s.next();
			return new PicturePage(day,month,year,title,keyword,path);
		}else if(choice.equals("TitlePage")){
			System.out.println("Please give a title:");
			Scanner s=new Scanner(System.in);
			String title=s.next();
			return new TitlePage(day,month,year,title,keyword);
		}
		return null;
	}
}
