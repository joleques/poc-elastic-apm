package com.pocs.nometimeservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {"server.port=1212"})
class NomeTimeServiceApplicationTests {

	@Test
	void contextLoads() {
	}

}
