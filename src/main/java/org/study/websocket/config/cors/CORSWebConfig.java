package org.study.websocket.config.cors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSWebConfig implements WebMvcConfigurer {

    /**
     * CORS 매핑 설정
     *
     * 모든 요청에 대하여 CORS 설정을 적용하며, 모든 도메인에 CORS 설정을 적용하고, 클라이언트는 GET, POST, PUT, DELETE HTTP 메서드 사용을 허용하고
     * 클라이언트가 Authorization 에 대하여 사용할 수 있도록 하용하며, 클라이언트가 응답에서 접근할 수 있는 Custom-Header 헤더를 지정한다.
     * 추가적으로 CORS 응답을 1시간 동안 캐시에 저장한다.
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("Authorization", "Content-Type")
                .exposedHeaders("Custom-Header")
                .maxAge(3600);
    }
}
