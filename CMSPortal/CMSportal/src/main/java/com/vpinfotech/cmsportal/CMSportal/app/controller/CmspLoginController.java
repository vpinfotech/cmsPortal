package com.vpinfotech.cmsportal.CMSportal.app.controller;


import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.vpinfotech.cmsportal.CMSportal.app.model.User;


@RestController
@RequestMapping(value="/user")
public class CmspLoginController {
	
	@RequestMapping(value="/login", method= RequestMethod.GET)
	public ResponseEntity<ObjectNode> isAuthenticate(@RequestBody User user){
		
		JsonNodeFactory nodeFactory= new JsonNodeFactory(true);
		ObjectNode response= nodeFactory.objectNode();
		ResponseEntity<ObjectNode> responseEntity= null;
		try{
			if(("ujjawal04sept@gmail.com").equals(user.getUserId()) && ("Password@1234").equals(user.getPassword())){
			JSONObject userObject= new JSONObject("{\"user_name\":\"Ujjawal Srivastava\",\"Role\":\"Admin\",\"mobile_number\":\"7415701260\"}");
			byte[] byteUser= userObject.toString().getBytes("UTF-8");
			ObjectMapper mapper= new ObjectMapper();
			JsonNode userEntity = mapper.readTree(byteUser);
			response.set("user", userEntity );
			responseEntity= new ResponseEntity<ObjectNode>(response, HttpStatus.OK);
			}else{
				responseEntity= new ResponseEntity<ObjectNode>(response, HttpStatus.BAD_GATEWAY);
			}
		}catch(Exception ex){
			responseEntity= new ResponseEntity<ObjectNode>(response, HttpStatus.BAD_GATEWAY);
		}
		return responseEntity;
	}

}
