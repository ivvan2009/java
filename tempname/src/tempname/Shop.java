package tempname;

public class Shop {
	
	public Shop(){
		
	}
	
	private String title = null;
	private long ownerID = 0;
	private String site = null;
	private int categoryId = 0;
	private String shortDescription = null;
	private long ID = 0;
	
	public void setTitle(String title){//parser?
		this.title = title;
	}
	public void setSite(String site){//parser
		this.site = site; 
	}
	public void setCategoryID(int categoryID){
		this.categoryId = categoryID;
	}
	public void setShortDescription(String shortDescription){
		this.shortDescription = shortDescription;
	}
	public String getTitle(){
		return this.title;
	}
 	public String getSite(){
 		return this.site;
 	}
 	public long getID(){
 		return this.ID;
 	}
	public long getOwnerID(){
		return this.ownerID;
	}
	public int getCategoryID(){
		return this.categoryId;
	}
	public String getShortDescription(){
		return this.shortDescription;
	}
}
