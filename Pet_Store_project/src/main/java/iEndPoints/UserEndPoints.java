package iEndPoints;

public interface UserEndPoints {
	String CREATE_USER ="/user"; 
	String GET_USER ="/user/{username}"; 
	String UPDATE_USER ="/user/{username}"; 
	String DELETE_USER ="/user/{username}"; 
	String LOGIN_USER = "/user/login";
	String LOGOUT_USER = "/user/logout";

}
