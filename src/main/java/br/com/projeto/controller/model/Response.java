package br.com.projeto.controller.model;

// TODO: Auto-generated Javadoc
/**
 * The Class Response.
 */
public class Response {
	
	/** The status. */
	private String status;
	
	/** The msg. */
	private String msg;
	
	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the msg.
	 *
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * Sets the msg.
	 *
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public Response() {
		
	}

	public Response(String status, String msg) {
		super();
		this.status = status;
		this.msg = msg;
	}
	
	
}
