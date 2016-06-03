package org.gamethree.karel;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = GameControllerTests.class)
@WebAppConfiguration
public class GameControllerTests {

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
