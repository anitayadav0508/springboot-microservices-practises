package Design.MakeMyTrip.Which.Act.As.RestClient.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
/*How to inform IOC to call this method? Ans:-  by using annotation @Bean
* only then you can do @Autowired otherwise you can't do it directly*/
    public RestTemplate createRestTemplate(){

        RestTemplate rt = new RestTemplate();
                return rt;
    }
}
