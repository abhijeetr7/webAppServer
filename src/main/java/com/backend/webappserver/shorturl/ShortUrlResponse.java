/**
 * 
 */
package com.backend.webappserver.shorturl;

import java.io.Serializable;

/**
 * @author Akshay Patil
 *
 */
public class ShortUrlResponse implements Serializable {

  private String tiny_url;
  
  private String alias;
  
  private String domain;

  /**
   * @return the tiny_url
   */
  public String getTiny_url() {
    return tiny_url;
  }

  /**
   * @param tiny_url the tiny_url to set
   */
  public void setTiny_url(String tiny_url) {
    this.tiny_url = tiny_url;
  }

  /**
   * @return the alias
   */
  public String getAlias() {
    return alias;
  }

  /**
   * @param alias the alias to set
   */
  public void setAlias(String alias) {
    this.alias = alias;
  }

  /**
   * @return the domain
   */
  public String getDomain() {
    return domain;
  }

  /**
   * @param domain the domain to set
   */
  public void setDomain(String domain) {
    this.domain = domain;
  }
  
  
  
}
