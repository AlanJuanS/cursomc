package com.alanjuan.cursomc.resources.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
	private static final long serialVersionUID = 1L;
	
	
	private List<FieldMessage> errros = new ArrayList<>();

	public ValidationError(Integer status, String msg, Long timeStamp) {
		super(status, msg, timeStamp);
		
	}

	public List<FieldMessage> getErrors() {
		return errros;
	}

	public void addError(String fielName, String messagem) {
		errros.add(new FieldMessage(fielName, messagem));
	}

	
	

}
