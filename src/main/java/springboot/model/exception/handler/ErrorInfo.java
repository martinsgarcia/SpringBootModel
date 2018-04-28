package springboot.model.exception.handler;

public class ErrorInfo {

	public final String url;
	public final String ex;
	public final String message;

	public ErrorInfo(String url, Exception ex) {
		this.url = url;
		this.ex = ex.getClass().getSimpleName();
		this.message = ex.getLocalizedMessage();
	}

	public String getUrl() {
		return url;
	}

	public String getMessage() {
		return message;
	}

	public String getEx() {
		return ex;
	}

}
