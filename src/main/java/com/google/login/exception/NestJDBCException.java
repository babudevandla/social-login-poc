package com.google.login.exception;

public class NestJDBCException extends RuntimeException{

	
	public NestJDBCException(Throwable th){
		this(th,null);
	}
	public NestJDBCException(Throwable th,String message){
		super(message,th);
	}
}
