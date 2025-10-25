package POJO.util;

   
public class UpdateUserPojo {
	
   public UpdateUserPojo(int id, String username, String firstName, String lastName, String email, String password,
			String phone, int userStatus) {
		super();
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.userStatus = userStatus;
	}
   
   public UpdateUserPojo() {}
   
   int id;
   String username;
   String firstName;
   String lastName;
   String email;
   String password;
   String phone;
   int userStatus;


    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getFirstName() {
        return firstName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLastName() {
        return lastName;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPhone() {
        return phone;
    }
    
    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }
    public int getUserStatus() {
        return userStatus;
    }
    
}