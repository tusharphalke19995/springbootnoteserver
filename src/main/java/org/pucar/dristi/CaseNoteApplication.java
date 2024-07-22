package org.pucar.dristi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Note and Constitute element registry",
				version = "1.0.0",
				description = "This draft API specification defines the Note and Constitute element registries."
		),
		servers = @Server(
				url = "http://localhost:8080",
				description = "Note OPEN API url"
		)

)
public class CaseNoteApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaseNoteApplication.class, args);
	}
}	
