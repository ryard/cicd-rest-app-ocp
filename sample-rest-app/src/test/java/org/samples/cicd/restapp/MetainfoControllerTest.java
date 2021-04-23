package org.samples.cicd.restapp;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MetainfoControllerTest {
	
	@LocalServerPort
    private int port;
	
    private String url;
    
    @Autowired
    private TestRestTemplate restTemplate;
    
    @BeforeEach
    public void setUp() {
        url = String.format("http://localhost:%d/info", port);
    }
    
    @Test
    public void infoShouldReturnNotNullResponse() {
    	Metainfo info = restTemplate.getForObject(url, Metainfo.class);
    	
    	assertNotNull(info);
    	assertNotNull(info.getVersion());
    	assertNotNull(info.getPodName());
    	assertNotNull(info.getUsername());
    }

}
