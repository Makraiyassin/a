package be.digitalcity.exojwt.utils;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter
@ConfigurationProperties("application.jwt")

public class JwtProperties implements InitializingBean {
    private String secret;
    private long expiresAt;
    private String headerPrefix;
    private String headerKey;

    @Override
    public String toString() {
        return "JwtProperties{" +
                "secret='" + secret + '\'' +
                ", expiresAt='" + expiresAt + '\'' +
                ", headerPrefix='" + headerPrefix + '\'' +
                ", headerKey='" + headerKey + '\'' +
                '}';
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(this);
    }
}
