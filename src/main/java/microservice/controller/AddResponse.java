package microservice.controller;

public class AddResponse {

	private String message;
	private int id;
	public AddResponse(String message, int id) {
		super();
		this.message = message;
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public AddResponse() {
		super();
		
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
