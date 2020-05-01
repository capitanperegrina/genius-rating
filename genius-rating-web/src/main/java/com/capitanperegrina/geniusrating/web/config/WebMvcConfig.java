//package com.capitanperegrina.geniusrating.web.config;
//
//import java.util.Locale;
//import java.util.concurrent.TimeUnit;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.support.ReloadableResourceBundleMessageSource;
//import org.springframework.http.CacheControl;
//import org.springframework.web.servlet.LocaleResolver;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.i18n.CookieLocaleResolver;
//import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
//import org.springframework.web.servlet.view.tiles3.TilesViewResolver;
//
//@Configuration
//@EnableWebMvc
//public class WebMvcConfig implements WebMvcConfigurer {
//
//    @Bean
//    public TilesConfigurer tilesConfigurer() {
//        TilesConfigurer tilesConfigurer = new TilesConfigurer();
//        tilesConfigurer.setDefinitions( new String[] { "/WEB-INF/xml/tiles.xml" } );
//        tilesConfigurer.setCheckRefresh(true);
//        return tilesConfigurer;
//    }   
//    
//    @Bean(name = "viewResolver")
//    public InternalResourceViewResolver getViewResolver() {
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//        viewResolver.setPrefix("/WEB-INF/jsp/");
//        viewResolver.setSuffix(".jsp");
//        return viewResolver;
//    }
//
//    @Bean(name = "localeChangeInterceptor")
//    public LocaleChangeInterceptor getLocaleChangeInterceptor() {
//    	LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
//    	localeChangeInterceptor.setParamName("lang");
//    	return localeChangeInterceptor;
//    }
//    
//    @Bean(name = "localeResolver")
//    public LocaleResolver localeResolver() {
//       CookieLocaleResolver localeResolver = new CookieLocaleResolver();
//   		localeResolver.setDefaultLocale(new Locale("en"));
//       return localeResolver;
//    }
//    
//    @Bean(name = "messageSource")
//    public ReloadableResourceBundleMessageSource simpleUserMessageSource() {
//    	ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//    	messageSource.setBasename("classpath*:genius-rating-messages.properties,classpath:simple-user-messages.properties");
//    	messageSource.setDefaultEncoding("UTF-8");
//        messageSource.setUseCodeAsDefaultMessage(true);
//    	return messageSource;
//    }
//    
//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        TilesViewResolver viewResolver = new TilesViewResolver();
//        registry.viewResolver(viewResolver);
//    }
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/statics/**")
//				.setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
//    }
//    
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//      registry.addViewController("/").setViewName("main");
//    }
//    
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
//        localeChangeInterceptor.setParamName("lang");
//        registry.addInterceptor(localeChangeInterceptor);    	
//    }
//}