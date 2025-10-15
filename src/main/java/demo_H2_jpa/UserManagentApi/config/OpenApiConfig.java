package demo_H2_jpa.UserManagentApi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI()
                .info(new Info()
                        .title("User Management")
                        .version("1.0")
                        .description("by prasid")
                        .contact(new Contact()
                                .name("Prasid Gowda")
                                .email("prasid@gmail.com")
                        )
                );

    }
}
