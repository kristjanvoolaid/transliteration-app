package ee.transliteration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@Configuration
public class TransliterationApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransliterationApplication.class, args);
    }

    @Bean
    @Profile("transliteration-web")
    public OpenAPI customOpenApi(@Value("1.0") String appVersion) {
        return new OpenAPI().info(new Info().title("Transliteration service").version(appVersion));
    }
}
