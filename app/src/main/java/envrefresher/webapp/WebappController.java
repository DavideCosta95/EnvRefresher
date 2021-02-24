package envrefresher.webapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WebappController {

	private static final Logger logger = LoggerFactory.getLogger(WebappController.class);

	private WebappController() {
	}

	@GetMapping("/")
	public RedirectView startUserCheck(HttpServletRequest request) {
		return null;
	}
}

