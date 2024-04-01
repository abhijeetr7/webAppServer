package com.backend.webappserver.service;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.backend.webappserver.shorturl.Easytinyurl;
import com.backend.webappserver.shorturl.ShortdataResponse;

@Service
public class ShortUrlService {

  
  public String getShortUrl(String url)
  {
    RestTemplate restTemplate = new RestTemplate();
    final String baseUrl = "https://api.tinyurl.com/create";
    URI uri;
    try {
      uri = new URI(baseUrl);
   
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "application/json");

    headers.add("Authorization", "Bearer " + "zR2NRPBXG2vNKPeSN4cQ9t7zvQQ8ckq3x752e8pTn8XrmZszdspBhVO7Ra6y");
    Easytinyurl  easytinyurl = new  Easytinyurl();
    easytinyurl.setUrl(url);
    easytinyurl.setDomain("tinyurl.com");
    HttpEntity< Easytinyurl> request = new HttpEntity<>(easytinyurl, headers);
    
    ResponseEntity<ShortdataResponse> result = restTemplate.postForEntity(uri, request, ShortdataResponse.class);
    return result.getBody().getData().getTiny_url();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }
}
