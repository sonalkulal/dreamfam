package com.restassured;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;

public class Gorest {
	public void getUser() {
		given()
		.when()
		.get("https://gorest.co.in/public/v2/users/628145")
		.then()
		.log().all();
	}
	
	public void postUser() {
		given()
		.contentType(ContentType.JSON)
		.header("Authorization"," Bearer af276ae8e13b3762ea36727d7b66628fe42c0e76c6918a8410c32dc389314b8d")
		.body("{{\r\n"
				+ "    \"id\": 628190,\r\n"
				+ "    \"name\": \"Aaratrika Dubashi\",\r\n"
				+ "    \"email\": \"dubashi_aaratrika@greenholt.biz\",\r\n"
				+ "    \"gender\": \"female\",\r\n"
				+ "    \"status\": \"active\"\r\n"
				+ "}}")
		.when()
		.post("https://gorest.co.in/public/v2/users")
		.then().log().all();
	}

	public static void main(String[] args) {
		Gorest rest=new Gorest();
		rest.getUser();
	}
}





