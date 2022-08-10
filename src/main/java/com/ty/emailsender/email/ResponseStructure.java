package com.ty.emailsender.email;

import lombok.Data;

@Data
public class ResponseStructure<T> {

	private String statusCode;
	private String message;
	private T data;
}
