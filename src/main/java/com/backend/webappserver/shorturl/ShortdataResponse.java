/**
 * 
 */
package com.backend.webappserver.shorturl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Akshay Patil
 *
 */
public class ShortdataResponse implements Serializable {

  ShortUrlResponse data = new ShortUrlResponse();

  /**
   * @return the data
   */
  public ShortUrlResponse getData() {
    return data;
  }

  /**
   * @param data the data to set
   */
  public void setData(ShortUrlResponse data) {
    this.data = data;
  }

  
  
}
