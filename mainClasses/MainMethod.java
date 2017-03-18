package mainClasses;

import dataHolder.*;
import java.util.ArrayList;
import factories.*;
import java.util.*;
public class MainMethod{
	AlbumFactory creator = new AlbumFactory();
	private ArrayList <Album> albums;
	
	public MainMethod(){
		albums=new ArrayList<Album>(); 
	}
	

	public void viewTitles(){
		for (Album i: albums){
			System.out.println(i.getTitle() + '\n');
		}
	}
	
	public void viewInInitialOrder (String wanted){
		boolean flag = false;
		for (Album i: albums){
			if (i.getTitle().equals(wanted)){
				i.showContents();
				flag = true;
				break;
			}
		}
		if (flag==false){
			System.out.println("This album does not exist.");
		}
	}
	
	public void viewInChronologicalOrder (String wanted){
		boolean flag = false;
		for (Album i: albums){
			System.out.println("mphke sthn xronoligkh ");
			System.out.println(i.getTitle());
			System.out.println(wanted);
			if (i.getTitle().equals(wanted)){
				i.showChronologically();
				flag = true;
				System.out.println("Mpike kai edw");
				break;
				
			}
		}
		
		if (flag==false){
			System.out.println("This album does not exist.");
		}
	}
	
	public void createNewAlbum(String title, String type){
		//AlbumFactory creator = new AlbumFactory();
		Album temp = creator.createAlbum(title,type);
		if (type.equals("Produced")){
			for (Album i: albums){
				temp=i.fillProducedAlbum(title,temp);
			}
			if (temp.isEmpty()){
				System.out.println("There are no pages with this keyword.");
			}else{
				albums.add(temp);
			}
		}
		albums.add(creator.createAlbum(title,type));
	}
	
	public void createNewPage(String kind,int day,int month,int year,String keyword,String title){
		boolean flag=true;
		for(Album i:albums){
			if(i.getTitle().equals(title)){
				i.addNewPage(kind,day,month,year,keyword);
				flag=false;
				
			}
		}
		if(flag==true){
			System.out.println("This album doesn't exist.");
		}
	}
	
	public void makeTheChange(int inDay,int inMonth,int inYear,String keyword,String albumTitle,String type){
		for (Album i: albums){
			if (i.getTitle().equals(albumTitle)){
				if (i.findPage(inDay,inMonth,inYear,keyword)!= null){
					 Page wanted = i.findPage(inDay,inMonth,inYear,keyword);
					 if(type.equals("BlankPage")){
						 Scanner sc=new Scanner(System.in);
						 System.out.println("Please give day,month,year:");            		
						 int d = sc.nextInt();
						 int m = sc.nextInt();
						 int y = sc.nextInt();
						 while(d>31 && d<1){
							System.out.println("You have given a wrong day.Please retype:");
							d=sc.nextInt();
						 }
						 while(m>12 && m<1){
							 System.out.println("You have given wrong month.Please retype:");
							 m=sc.nextInt();
						 }
						 while(y<1000){
							 System.out.println("you have ginen wrong year.Please retype");
							 y=sc.nextInt();
						 }
						 System.out.println("Please give keywords:");
						 String k=sc.next();
						 BlankPage wanted1 = (BlankPage) wanted;
						 wanted1.changeAll(d,m,y,k);
					}else if(type.equals("TitlePage")){
						Scanner sc1=new Scanner(System.in);
						System.out.println("Please give day,month,year:");            		
						int d1 = sc1.nextInt();
						int m1= sc1.nextInt();
						int y1 = sc1.nextInt();
						while(d1>31 && d1<1){
							System.out.println("You have given a wrong day.Please retype:");
							d1=sc1.nextInt();
						}
						while(m1>12 && m1<1){
							System.out.println("You have given wrong month.Please retype:");
							m1=sc1.nextInt();
						}
						while(y1<1000){
							System.out.println("You have given wrong year.Please retype");
							y1=sc1.nextInt();
						}
						System.out.println("Please give keywords:");
						String k1=sc1.next();
						System.out.println("Please give the new title:");
						String t1 = sc1.next();
						TitlePage wanted1 = (TitlePage) wanted;
						wanted1.changeAll(d1,m1,y1,k1,t1);
					}else if(type.equals("ContentPage")){
						Scanner sc2=new Scanner(System.in);
						System.out.println("Please give day,month,year:");            		
						int d2 = sc2.nextInt();
						int m2 = sc2.nextInt();
						int y2 = sc2.nextInt();
						while(d2>31 && d2<1){
							System.out.println("You have given a wrong day.Please retype:");
							d2=sc2.nextInt();
						}
						while(m2>12 && m2<1){
							System.out.println("You have given wrong month.Please retype:");
							m2=sc2.nextInt();
						}
						while(y2<1000){
							System.out.println("you have ginen wrong year.Please retype");
							y2=sc2.nextInt();
						}
						System.out.println("Please give keywords:");
						String k2=sc2.next();
						System.out.println("Please give the new title:");
						String t2 = sc2.next();
						System.out.println("Please give the new content:");
						String c2 = sc2.next();
						ContentPage wanted1 = (ContentPage) wanted;
						wanted1.changeAll(y2,m2,y2,k2,t2,c2);	
					}else if(type.equals("PicturePage")){
						Scanner sc3=new Scanner(System.in);
						System.out.println("Please give day,month,year:");            		
						int d3 = sc3.nextInt();
						int m3 = sc3.nextInt();
						int y3= sc3.nextInt();
						while(d3>31 && d3<1){
							System.out.println("You have given a wrong day.Please retype:");
							d3=sc3.nextInt();
						}
						while(m3>12 && m3<1){
							System.out.println("You have given wrong month.Please retype:");
							m3=sc3.nextInt();
						}
						while(y3<1000){
							System.out.println("you have ginen wrong year.Please retype");
							y3=sc3.nextInt();
						}
						System.out.println("Please give keywords:");
						String k3=sc3.next();
						System.out.println("Please give the new title:");
						String t3 = sc3.next();
						System.out.println("Please give the new path:");
						String c3 = sc3.next();
						PicturePage wanted1 = (PicturePage) wanted;
						wanted1.changeAll(y3,m3,y3, k3,t3,c3);	
					}
				}
			}	
		
		}
	}
	
	
	
	public boolean checkType(String name){
			
			if(!name.equals("BlankPage") && !name.equals("PicturePage") && !name.equals("TitlePage") && !name.equals("ContentPage")){
				System.out.println("Types:BlankPage,ContentPage,PicturePage,TitlePage");
				System.out.println("Please retype");
				return true;
			}
			return false;
	}
}
