package by.htp.ex.service;

public class ServiceException extends Exception{

	public ServiceException(String e) {
		super(e);
	}
	
	public ServiceException(Exception e) {
		super(e);
	}

	public ServiceException(String msg, Exception e) {
		super(msg,e);
	}
}
