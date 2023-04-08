package com.anyaudit;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(basePackages = {"com.anyaudit"} )
@EnableWebMvc
public class WebAppConfig implements AsyncConfigurer, WebMvcConfigurer {

    /*@Autowired
    private AuthenticationInterceptor authenticationInterceptor;

    @Autowired
    private DomainFilterInterceptor domainFilterInterceptor;

    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor).addPathPatterns("/api/v1/**");
        registry.addInterceptor(domainFilterInterceptor).addPathPatterns("/api/v1/**");
    }
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/client/**")
                .addResourceLocations("/client/");
        registry
                .addResourceHandler("/partials/**")
                .addResourceLocations("/partials/");
    }
    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html");
        registry.addViewController("/referAFriend.html");
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {

    }

    @Bean
    public ViewResolver viewResolver() {
        final InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setViewClass(JstlView.class);
        bean.setPrefix("/WEB-INF/views/");
        bean.setSuffix(".jsp");
        return bean;
    }

    @Override
    public void addArgumentResolvers(final List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(pageableArgumentResolver());
    }
    @Bean
    public PageableHandlerMethodArgumentResolver pageableArgumentResolver() {
        return getPageableHandlerMethodArgumentResolver();
    }
    public static PageableHandlerMethodArgumentResolver getPageableHandlerMethodArgumentResolver() {
        PageableHandlerMethodArgumentResolver resolver = new PageableHandlerMethodArgumentResolver();
        resolver.setMaxPageSize(Integer.MAX_VALUE);
        resolver.setFallbackPageable(new PageRequest(0, Integer.MAX_VALUE, null));
        //resolver.setPrefix("page.");
        resolver.setOneIndexedParameters(true);
        return resolver;
    }

    @Bean
    public ConfigurableServletWebServerFactory webServerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.addConnectorCustomizers(new TomcatConnectorCustomizer() {
            @Override
            public void customize(Connector connector) {
                connector.setProperty("relaxedQueryChars", "|{}[]");
            }
        });
        return factory;
    }*/
}
