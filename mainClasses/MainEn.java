package mainClasses;
import java.util.Scanner;


public class MainEn{
	private MainMethod a =new MainMethod(); 
	public enum Choices{
		Album_Titles(1),Album_Contents(2),AlbumContentsChronologically(3),Produced_Album(4),Basic_Album(5),New_Page(6),Change_Contents(7),Exit(8);
		
		Choices(int value){
			this.value=value;
		}
		private int value;
		public int getValue(){
				return value;
		}
			
	}
	public void execute(int new_value){
		for (Choices ch:Choices.values()){
			if(ch.getValue()==new_value){
				
				System.out.println("Choice:"+ ch + " ");		
				switch (ch){        	
	     	
		 		case Album_Titles:
		 			System.out.println("Album Titles");
		 			a.viewTitles();
		 			break;
                 
		 		case Album_Contents:
		 			System.out.println("Specific Album Contents");
		 			Scanner ch1= new Scanner(System.in);
		 			System.out.println("Please give album name:");
		 			String b=ch1.next();
		 			a.viewInInitialOrder(b);
		 			break;
                
		 		case AlbumContentsChronologically:
		 			System.out.println("Chronological view of album contents");
		 			Scanner ch21= new Scanner(System.in);
		 			System.out.println("Please give album name:");
		 			String album_name_c=ch21.next();
		 			a.viewInChronologicalOrder(album_name_c);
		 		case Produced_Album:
		 			System.out.println("Set a keyword for making a new produced album");
		 			Scanner ch3=new Scanner(System.in);
		 			String s = ch3.next();
		 			a.createNewAlbum(s,"Produced");
		 			break;
             
		 		case Basic_Album:
		 			System.out.println("Make a new album");
		 			System.out.println("Give an album title.");
		 			Scanner ch4=new Scanner(System.in);
		 			String title=ch4.next();
		 			a.createNewAlbum(title,"Basic");            		
		 			break;
		 			
		 		case New_Page:
		 					System.out.println("Make a new page");
		 					System.out.println("Please give the type of the page :");
		 					Scanner ch5=new Scanner(System.in);		 					
		 					String kind= ch5.next();
		 					while(a.checkType(kind)){
		 						 kind=ch5.next();
							}
		 					System.out.println("Please give day,month,year:");            		
		 					int day1 = ch5.nextInt();
		 					int month1 = ch5.nextInt();
		 					int year1 = ch5.nextInt();
		 					while(day1>31 && day1<1){
		 						System.out.println("You have given a wrong day.Please retype:");
		 						int day2=ch5.nextInt();
		 						day1=day2;
		 					}
		 					while(month1>12 && month1<1){
		 						System.out.println("You have given wrong month.Please retype:");
		 						int month2=ch5.nextInt();
		 						month1=month2;
		 					}
		 					while(year1<1000){
		 						System.out.println("you have given wrong year.Please retype");
		 						int year2=ch5.nextInt();
		 						year1=year2;
		 					}
		 					System.out.println("Please give keywords:");
		 					String keyword1=ch5.next();
		 					System.out.println("Please give album title:");
		 					String title1=ch5.next();
		 					a.createNewPage(kind,day1,month1,year1,keyword1,title1);            		
		 					break;
         	
		 		case Change_Contents:
	            
            		System.out.println("Change contents of a page");
					System.out.println("Please give the type of the page :");
            		Scanner ch6=new Scanner(System.in);
            		String kind1= ch6.next();
            		while(a.checkType(kind1)){
						 kind=ch6.next();
					}
            		System.out.println("Please give day,month,year:");            		
            		int inDay = ch6.nextInt();
            		int inMonth = ch6.nextInt();
            		int inYear = ch6.nextInt();
            		while(inDay>31 && inDay<1){
            			System.out.println("You have given a wrong day.Please retype:");
            			inDay=ch6.nextInt();
            		}
            		while(inMonth>12 && inMonth<1){
            			System.out.println("You have given wrong month.Please retype:");
            			inMonth=ch6.nextInt();
            		}
            		while(inYear<1000){
            			System.out.println("you have ginen wrong year.Please retype");
            			inYear=ch6.nextInt();
            		}
            		System.out.println("Please give one keyword contained in the page you wish:");
            		String keyword=ch6.next();
            		System.out.println("Please give the title of the album that contains that page:");
            		String albumTitle=ch6.next();
					a.makeTheChange(inDay,inMonth,inYear,keyword,albumTitle,kind1);
            		break;
            	
         	
		 		case Exit:
		 			System.out.println("Exit");
		 			break;
         		
		 		}
			}
		}
	}
		
	public static void main(String[] args){
		
		System.out.println("To exit type --> 8. Else type any number you wish");
		Scanner new_scan=new Scanner(System.in);
		int new_value=new_scan.nextInt();
		if(new_value<1 || new_value >8){
			System.out.println("Please retype");				
		}
		MainEn a1 = new MainEn();
		while(!(new_value==8)){
			System.out.println("Hello. What would you like to do?");
			System.out.println("To view the existing albums' titles type --> 1");
			System.out.println("To view the contents of an album type --> 2");
			System.out.println("To view the contents of an album type chronologically -->3");
			System.out.println("To create a new album based on a keyword type --> 4");
			System.out.println("To create a basic album type --> 5");
			System.out.println("To add a new page to an existing album type --> 6");
			System.out.println("To change the contents of an existing page type --> 7");
			System.out.println("To exit type --> 8 ");
			new_value = new_scan.nextInt();
			a1.execute(new_value);
		
		}
		new_scan.close();
	}
}
