package com.pocs.testecarga;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {"server.port=1212", "generator.gerador-host=teste", "generator.gerador-PORT=7878"})
class TesteCargaApplicationTests {

	@Test
	void contextLoads() {
	}

}
