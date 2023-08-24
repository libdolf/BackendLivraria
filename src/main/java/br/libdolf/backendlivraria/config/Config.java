package br.libdolf.backendlivraria.config;

import br.com.caelum.stella.validation.CPFValidator;
import lombok.Builder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class Config {
//    @Bean
//    public LocalValidatorFactoryBean validator() {
//        LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
//        factoryBean.getValidationPropertyMap().put("javax.persistence.validation.mode", "none");
//        return factoryBean;
//    }
}
