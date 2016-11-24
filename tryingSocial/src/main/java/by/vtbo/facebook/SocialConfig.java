package by.vtbo.facebook;

import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;



@EnableWebMvc
@Configuration
@EnableSocial
@PropertySource("classpath:/application.properties")
public class SocialConfig extends SocialConfigurerAdapter {
    @Override
    public StaticUserIdSource getUserIdSource() {
        return new StaticUserIdSource();
    }
    @Configuration
    public static class FacebookConfiguration extends SocialConfigurerAdapter {
        @Override
        public void addConnectionFactories(
                ConnectionFactoryConfigurer connectionFactoryConfigurer,
                Environment env) {
            connectionFactoryConfigurer.addConnectionFactory(
                    new FacebookConnectionFactory(
                            env.getRequiredProperty("facebook.clientId"),
                            env.getRequiredProperty("facebook.clientSecret")));
        }


    }

    @Bean
    @Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
    public Facebook facebookTemplate(ConnectionRepository connectionRepository) {
        Connection<Facebook> connection = connectionRepository.findPrimaryConnection(Facebook.class);
        return connection != null ? connection.getApi() : null;
    }

    @Bean
    public ConnectController connectController(
            ConnectionFactoryLocator connectionFactoryLocator,
            ConnectionRepository connectionRepository) {
        return new ConnectController(connectionFactoryLocator, connectionRepository);
    }

}


