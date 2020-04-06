package com.example.demobddmaven;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Ignore
public class SpringCucumberIntegrationTests {

	private final String SERVER_URL = "http://localhost";
	private final String THINGS_ENDPOINT = "/things";

	private RestTemplate restTemplate;

	@LocalServerPort
	protected int port;

	public SpringCucumberIntegrationTests() {

		this.restTemplate = new RestTemplate();
	}

	private String thingsEndpoint() {
		return SERVER_URL + ":" + port + THINGS_ENDPOINT;
	}

	int put(String something) {
		return restTemplate.postForEntity(thingsEndpoint(), something, Void.class).getStatusCodeValue();
	}

	Bag getContents() {
		return restTemplate.getForEntity(thingsEndpoint(), Bag.class).getBody();
	}

	void clean() {
		restTemplate.delete(thingsEndpoint());
	}

}
