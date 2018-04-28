package springboot.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest
@ComponentScan(basePackages = "com.ibm.sdi.**.service.*")
public class SpringBootModelApplicationTests {

	@Test
	public void contextLoads() {
	}

}
