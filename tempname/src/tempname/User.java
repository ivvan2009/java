package tempname;

public class User {
	
	public User(){
		
	}
	
	private String name = null;
	private long id = 0;
	private String password = null;
	
	public void setName(String name){//parser
		this.name = name;
	}
	public void setPassword(String password){//parser
		this.password = password;
	}
	public long getId(){
		return this.id;
	}
	public String getName(){
		return this.name;
	}
	public String getPassword(){
		return this.password;
	}
}
