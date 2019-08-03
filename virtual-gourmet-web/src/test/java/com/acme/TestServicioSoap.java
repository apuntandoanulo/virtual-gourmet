package com.acme;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testing /ingredientes")
public class TestServicioSoap {
	
	@Test
	@DisplayName("Probando GET")
	public void testGET() {
		given().
			baseUri("http://localhost/virtual-gourmet-web-1.0.0/virtual-gourmet-rest").
			port(80).
		when().
			get("/ingredientes").
		then().
			log().all().
			assertThat().statusCode(200).
			and().
			body("[0].nombre", equalTo("Mesero02"));
	}
	
	@Test
	@DisplayName("Probando GET 2")
	public void testGET2() {
		given().
			baseUri("http://localhost/virtual-gourmet-web-1.0.0/virtual-gourmet-rest").
			port(80).
		when().
			get("/ingredientes").
		then().
			log().all().
			assertThat().statusCode(200).
			and().
			body("[2].nombre", equalTo("Mesero05"));
	}
}
