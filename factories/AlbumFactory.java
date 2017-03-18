package factories;
import dataHolder.*;


public class AlbumFactory {
	public Album createAlbum(String title, String type){
		if (type.equals("Basic")){
			return new BasicAlbum(title);
		}
		else if (type.equals("Produced")){
			return new ProducedAlbum(title);
		}

		System.out.println("If the code got up to here, you passed a wrong argument to AlbumFactory");
		return null;
	}
}

