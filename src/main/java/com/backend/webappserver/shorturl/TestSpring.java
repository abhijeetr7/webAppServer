/**
 * 
 */
package com.backend.webappserver.shorturl;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @author Akshay Patil
 *
 */
public class TestSpring {

  /**
   * @param args
   * @throws URISyntaxException 
   */
  public static void main(String[] args) throws URISyntaxException {
    // TODO Auto-generated method stub
    RestTemplate restTemplate = new RestTemplate();
    final String baseUrl = "https://api.tinyurl.com/create";
    URI uri = new URI(baseUrl);
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "application/json");

    headers.add("Authorization", "Bearer " + "zR2NRPBXG2vNKPeSN4cQ9t7zvQQ8ckq3x752e8pTn8XrmZszdspBhVO7Ra6y");
    Easytinyurl  easytinyurl = new  Easytinyurl();
    easytinyurl.setUrl("https://howtodoidfghnjava.com/spring-boot2/resttemplate/spdiopkddring-restful-client-resttemplate-example/");
    easytinyurl.setDomain("tinyurl.com");
    HttpEntity< Easytinyurl> request = new HttpEntity<>(easytinyurl, headers);
    
    ResponseEntity<ShortdataResponse> result = restTemplate.postForEntity(uri, request, ShortdataResponse.class);
    
    System.out.println("result:  "+result.getBody().getData().getTiny_url() );
  }

}
