/**
 * 
 */
package com.backend.webappserver.payload;

/**
 * @author ashutosh
 *
 */
public class Message {

  public String message;
  public String error_message;
  public String error_code;
  public String status;

  /**
   * @return the message
   */
  public String getMessage() {
    return message;
  }

  /**
   * @param message the message to set
   */
  public void setMessage(String message) {
    this.message = message;
  }

  /**
   * @return the error_message
   */
  public String getError_message() {
    return error_message;
  }

  /**
   * @param error_message the error_message to set
   */
  public void setError_message(String error_message) {
    this.error_message = error_message;
  }

  /**
   * @return the error_code
   */
  public String getError_code() {
    return error_code;
  }

  /**
   * @param error_code the error_code to set
   */
  public void setError_code(String error_code) {
    this.error_code = error_code;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }



}
