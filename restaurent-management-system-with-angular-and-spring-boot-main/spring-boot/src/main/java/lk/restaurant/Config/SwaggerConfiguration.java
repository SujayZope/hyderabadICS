package lk.restaurant.Config;

import io.swagger.annotations.SwaggerDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@Configuration
//@ConfigurationProperties(prefix = "helios.admin")
@SwaggerDefinition
public class SwaggerConfiguration {

    @Bean
    public Docket productApi() {

        Docket docket =
                new Docket(DocumentationType.SWAGGER_2).select()
                        .apis(RequestHandlerSelectors.basePackage("lk")).build()
                .apiInfo(metaData());
//        docket.host(swaggerHost);
        return docket;
    }

    private ApiInfo metaData() {

        String title = "POS";
        String description = "API Documentation";
        String version = "0.0.1";
        String termsOfServiceUrl = "";
        Contact contactPerson = new Contact("", "", "" + "");
        String license = "";
        String licenseUrl = "";

        return new ApiInfo(title, description, version, termsOfServiceUrl, contactPerson, license, licenseUrl);
    }


}
