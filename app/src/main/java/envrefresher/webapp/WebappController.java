package envrefresher.webapp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import envrefresher.model.JdbcUrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/refresh")
public class WebappController {

	private static final Logger logger = LoggerFactory.getLogger(WebappController.class);

	private WebappController() {
	}

	@GetMapping(value = "/jdbc", produces = "application/json")
	public JdbcUrl startUserCheck(@RequestParam(required = true, name = "code") String code, HttpServletRequest request) throws JsonProcessingException {
		if (code.equals("MAGIC_CODE")) {
			ObjectMapper objectMapper = new ObjectMapper();
			String jdbcUrl = System.getenv("JDBC_DATABASE_URL");
			logger.info("jdbcUrl={}", jdbcUrl);
			return objectMapper.readValue("{\"jdbc_url\": \"" + jdbcUrl + "\"}", JdbcUrl.class);
		}
		return null;
	}
}

