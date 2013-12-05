package webservice;

public class AppWebException extends Exception {
	private static final long serialVersionUID = 1L;

	public AppWebException(String msg){
		super(msg);
	}
}