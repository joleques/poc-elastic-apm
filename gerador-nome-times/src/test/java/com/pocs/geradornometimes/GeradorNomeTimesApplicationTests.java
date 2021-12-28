package com.pocs.geradornometimes;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {"server.port=1212", "generator.name-host=teste", "generator.name-PORT=7878", "generator.cidade-host=teste", "generator.cidade-PORT=7878"})
class GeradorNomeTimesApplicationTests {

	@Test
	void contextLoads() {
	}

}
