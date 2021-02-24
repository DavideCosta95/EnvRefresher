package envrefresher.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JdbcUrl {
	@JsonProperty("jdbc_url")
	private String url;
}
