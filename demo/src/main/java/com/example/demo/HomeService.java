package com.example.demo;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class HomeService {
	
	@Autowired
    HomeRepository homeRepository;
	public List<String> getGame(){
		List<GameFormat> gameFormat = new ArrayList<>();
		List<String> response = new ArrayList<>();
		gameFormat =(List<GameFormat>) homeRepository.findAllSortedByOrderGame();
		System.out.println(gameFormat.get(0).getNoOfTimes());
		response = getGame(gameFormat);
		return response;
	}
	
	private List<String> getGame(List<GameFormat> gameFormat){
		List<String> response = new ArrayList<>();
		for (GameFormat gf : gameFormat) {
			if(gf.getGamingLevel() == 1) {
				getLevelOne(gf , response);
			}else if(gf.getGamingLevel() == 2) {
				getLevelTwo(gf , response);
			}else if(gf.getGamingLevel() == 3) {
				getLevelThree(gf , response);
			}
		}
		return response;
	}
	
	private void getLevelOne(GameFormat gf , List<String> response) {
		String microServiceURL="http://localhost:7771/";
		for (int count = 0 ; count < gf.getNoOfTimes() ; count++ ) {
			String nextResponse =  getGameLevel(microServiceURL);
			response.add(nextResponse);
		}
	}
	
	private void getLevelTwo(GameFormat gf , List<String> response) {
		String microServiceURL="http://localhost:7772/";
		for (int count = 0 ; count < gf.getNoOfTimes() ; count++ ) {
			String nextResponse =  getGameLevel(microServiceURL);
			response.add(nextResponse);
		}
	}
	
	private void getLevelThree(GameFormat gf , List<String> response) {
		String microServiceURL="http://localhost:7773/";
		for (int count = 0 ; count < gf.getNoOfTimes() ; count++ ) {
			String nextResponse =  getGameLevel(microServiceURL);
			response.add(nextResponse);
		}
	}
	private String getGameLevel(String microServiceURL) {
	     String urlStr = new StringBuilder().append(microServiceURL).append("home").toString();
	     RestTemplate restTemplate = new RestTemplate();
          URL url;
			try {
				url = new URL(urlStr);
				ResponseEntity<String> responseEntity = restTemplate.getForEntity(url.toURI(), String.class);
		        return responseEntity.getBody();
			} catch (MalformedURLException e) {
				
			} catch (RestClientException e) {
				
			} catch (URISyntaxException e) {
				
			}
			
			return null;
	        
	}
}
