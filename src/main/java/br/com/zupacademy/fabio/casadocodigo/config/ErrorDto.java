package br.com.zupacademy.fabio.casadocodigo.config;

public class ErrorDto {
	
	private final String field;
	private final String errorMessage;
	
	public ErrorDto(String field, String errorMessage) {
		super();
		this.field = field;
		this.errorMessage = errorMessage;
	}
	
	public String getField() {
		return field;
	}
	public String getErrorMessage() {
		return errorMessage;
	}		
}
