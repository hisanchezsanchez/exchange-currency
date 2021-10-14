package hider.sanchez.challengebcp;

import org.hibernate.annotations.SQLInsert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
class ChallengeBcpApplicationTests {

	@Test
	@Sql( scripts = "data-h2.sql")
	void contextLoads() {
	}

}
