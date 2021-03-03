package com.comunidad.SwingSpringMysql.jdbc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Utils {

	public static int validarDominio(String usuario) {
		int bandera = 0;
		try {
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return bandera;
	}
	
	public static Date convertStringToDate(String fecha) {
		SimpleDateFormat formatoOrigen = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = null;
		try {
			date = formatoOrigen.parse(fecha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

	
	public static String convertJsonToString(String valor) {
		String date = "";
		String payload = "{\r\n" + 
				"   \"TCRMService\":{\r\n" + 
				"      \"@schemaLocation\":\"http:\\/\\/www.ibm.com\\/mdm\\/schema MDMCommon.xsd\",\r\n" + 
				"      \"RequestControl\":{\r\n" + 
				"         \"requestID\":604157,\r\n" + 
				"         \"DWLControl\":{\r\n" + 
				"            \"requesterName\":\"rdmadmin\",\r\n" + 
				"            \"requesterLocale\":\"es\"\r\n" + 
				"         }\r\n" + 
				"      },\r\n" + 
				"      \"TCRMInquiry\":{\r\n" + 
				"         \"InquiryType\":\"getRDValueSetByName\",\r\n" + 
				"         \"InquiryParam\":{\r\n" + 
				"            \"tcrmParam\":[\r\n" + 
				"               {\r\n" + 
				"                  \"@name\":\"rdValueSetName\",\r\n" + 
				"                  \"$\":\""+valor+"\"\r\n" + 
				"               },\r\n" + 
				"               {\r\n" + 
				"                  \"@name\":\"inquiryLevel\",\r\n" + 
				"                  \"$\":\"1\"\r\n" + 
				"               },\r\n" + 
				"               {\r\n" + 
				"                  \"@name\":\"filter\",\r\n" + 
				"                  \"$\":\"ACTIVE\"\r\n" + 
				"               }\r\n" + 
				"            ]\r\n" + 
				"         }\r\n" + 
				"      }\r\n" + 
				"   }\r\n" + 
				"}";
		
		try {
			String url = "http://10.13.0.40:9080/com.ibm.mdm.server.ws.restful/resources/MDMWSRESTful";
			
	        String plainCredentials="rdmadmin:passw0rd";
	        String base64Credentials = Base64.getEncoder().encodeToString(plainCredentials.getBytes());
	        
		    RestTemplate rest = new RestTemplate();

		    HttpHeaders headers = new HttpHeaders();
		    headers.add("Accept", "application/json");
		    headers.add("Content-Type", "application/json");
		    headers.add("Accept", "*/*");
		    headers.add("Connection", "keep-alive");
		    headers.add("Authorization", "Basic " + base64Credentials);
		    HttpEntity<String> requestEntity = new HttpEntity<String>(payload, headers);
		    ResponseEntity<String> responseEntity = rest.exchange(url, HttpMethod.PUT, requestEntity, String.class);

		    date = responseEntity.getBody().toString();
		     
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}
}
