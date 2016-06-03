package org.gamethree.karel;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(MockitoJUnitRunner.class)
@SpringApplicationConfiguration(classes = GameControllerTests.class)
@WebAppConfiguration
public class GameControllerTests {

	private static final Logger log = LoggerFactory.getLogger(GameControllerTests.class);

	@Before
	public void setUp() {

	}

	@Test
	public void testMove() throws Exception {

	}

	@Test
	public void testGetPlayer() throws Exception {
		
	}

	@Test
	public void testStart() throws Exception {

	}

}
