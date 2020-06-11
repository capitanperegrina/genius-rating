package com.capitanperegrina.geniusrating.web.config;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.Ordered;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.accept.PathExtensionContentNegotiationStrategy;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import com.capitanperegrina.geniusrating.web.controller.resolver.BrowserAndCookieLocaleResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.capitanperegrina")
@PropertySource(value = {"classpath:genius-rating-application.properties"})
public class GeniusRatingSpringConfiguration implements WebMvcConfigurer {

    private static final Logger LOGGER = LoggerFactory.getLogger(GeniusRatingSpringConfiguration.class);

    @Value("${init-db:false}")
    private String initDatabase;

    @Autowired
    private Environment env;

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
        LOGGER.debug("Initializing placeHolderConfigurer...");
        PropertySourcesPlaceholderConfigurer placeHolderConfigurer = new PropertySourcesPlaceholderConfigurer();
        LOGGER.debug("Initialized placeHolderConfigurer.");
        return placeHolderConfigurer;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        LOGGER.debug("Initializing jdbcTemplate...");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        LOGGER.debug("Initialized jdbcTemplate.");
        return jdbcTemplate;
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        LOGGER.debug("Initializing transactionManager...");
        PlatformTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
        LOGGER.debug("Initialized transactionManager.");
        return transactionManager;
    }

    @Bean
    public DataSource dataSource() {
        LOGGER.debug("Initializing dataSource...");
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(this.env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(this.env.getProperty("spring.datasource.url"));
        dataSource.setUsername(this.env.getProperty("spring.datasource.username"));
        dataSource.setPassword(this.env.getProperty("spring.datasource.password"));
        dataSource.setInitialSize(Integer.parseInt(this.env.getProperty("spring.datasource.initialSize")));
        dataSource.setMaxActive(Integer.parseInt(this.env.getProperty("spring.datasource.maxActive")));
        dataSource.setValidationQuery(this.env.getProperty("spring.datasource.validationQuery"));
        dataSource.setTestWhileIdle(Boolean.parseBoolean(this.env.getProperty("spring.datasource.testWhileIdle")));
        dataSource.setTimeBetweenEvictionRunsMillis(Integer.parseInt(this.env.getProperty("spring.datasource.timeBetweenEvictionRunsMillis")));
        LOGGER.debug("Initialized dataSource.");
        return dataSource;
    }

    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        LOGGER.debug("Initializing messageSource...");
        ReloadableResourceBundleMessageSource messageBundle = new ReloadableResourceBundleMessageSource();
        messageBundle.setBasenames("classpath:genius-rating-messages", "classpath:simple-user-messages");
        messageBundle.setDefaultEncoding("UTF-8");
        LOGGER.debug("Initialized messageSource.");
        return messageBundle;
    }
  
//	@Bean
//	public InternalResourceViewResolver viewResolver() {
//		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//		viewResolver.setViewClass(JstlView.class);
//		viewResolver.setPrefix("/WEB-INF/jsp/");
//		viewResolver.setSuffix(".jsp");
//		viewResolver.setOrder(1);
//		return viewResolver;
//	}
    
//    @Bean
//    public UrlBasedViewResolver tilesViewResolver() {
//        LOGGER.debug("Initializing tilesViewResolver...");
//        UrlBasedViewResolver urlBasedViewResolver = new UrlBasedViewResolver();
//        urlBasedViewResolver.setViewClass(TilesView.class);
//        LOGGER.debug("Initialized tilesViewResolver.");
//        return urlBasedViewResolver;
//    }

    @Bean
    public TilesConfigurer tilesConfigurer() {
        LOGGER.debug("Initializing tilesConfigurer...");
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions("/WEB-INF/xml/tiles.xml");
        tilesConfigurer.setCheckRefresh(true);
        LOGGER.debug("Initialized tilesConfigurer.");
        return tilesConfigurer;
    }
    
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        TilesViewResolver viewResolver = new TilesViewResolver();
        registry.viewResolver(viewResolver);
    }
     
    /**
     * Configure ResourceHandlers to serve static resources like CSS/ Javascript etc...
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
    
    @Bean
    public BrowserAndCookieLocaleResolver localeResolver() {
        LOGGER.debug("Initializing localeResolver...");
        BrowserAndCookieLocaleResolver browserAndCookieLocaleResolver = new BrowserAndCookieLocaleResolver();
        browserAndCookieLocaleResolver.setDefaultLocale(new Locale("en"));
        browserAndCookieLocaleResolver.setCookieName("localeCookie");
        browserAndCookieLocaleResolver.setCookieMaxAge(3600);
        LOGGER.debug("Initialized localeResolver.");
        return browserAndCookieLocaleResolver;
    }
    
    @Bean
    public CommonsMultipartResolver multipartResolver() {
    	LOGGER.debug("Initializing multipartResolver...");
    	CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
    	commonsMultipartResolver.setDefaultEncoding("utf8");
    	LOGGER.debug("Initialized multipartResolver.");
    	return commonsMultipartResolver;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
    	LOGGER.debug("Initializing localeChangeInterceptor...");
    	LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
    	localeChangeInterceptor.setParamName("lang");
    	LOGGER.debug("Initialized localeChangeInterceptor.");
    	return localeChangeInterceptor;
    }
    
    @Bean
    public PathExtensionContentNegotiationStrategy pathExtensionContentNegotiationStrategy() {
    	LOGGER.debug("Initializing pathExtensionContentNegotiationStrategy...");
    	Map<String,MediaType> mediaTypes = new HashMap<>();
    	mediaTypes.put("html",MediaType.TEXT_HTML);
    	mediaTypes.put("pdf",MediaType.APPLICATION_PDF);
    	mediaTypes.put("json",MediaType.APPLICATION_JSON);
    	PathExtensionContentNegotiationStrategy pathExtensionContentNegotiationStrategy = new PathExtensionContentNegotiationStrategy(mediaTypes);
    	LOGGER.debug("Initialized pathExtensionContentNegotiationStrategy.");
    	return pathExtensionContentNegotiationStrategy;
    }
    
    @Bean
    public ContentNegotiationManager contentNegotiationManager() {
    	LOGGER.debug("Initializing contentNegotiationManager...");
    	ContentNegotiationManager contentNegotiationManager = new ContentNegotiationManager(pathExtensionContentNegotiationStrategy());
    	LOGGER.debug("Initialized contentNegotiationManager.");
    	return contentNegotiationManager;
    }
    
    @Bean
    public ContentNegotiatingViewResolver contentNegotiatingResolver() {
    	LOGGER.debug("Initializing contentNegotiatingResolver...");
    	ContentNegotiatingViewResolver contentNegotiatingResolver = new ContentNegotiatingViewResolver();
    	contentNegotiatingResolver.setOrder(Ordered.HIGHEST_PRECEDENCE);
    	contentNegotiatingResolver.setContentNegotiationManager(contentNegotiationManager());
    	LOGGER.debug("Initialized contentNegotiatingResolver.");
    	return contentNegotiatingResolver;
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	LOGGER.debug("Adding interceptors...");
        registry.addInterceptor(localeChangeInterceptor());
        LOGGER.debug("Added interceptors.");
    }  
    
//    @Bean
//    public DispatcherServletPath dispatcherServletPath() {
//    	LOGGER.debug("Initializing DispatcherServletPath...");
//    	DispatcherServletPath obj = new DispatcherServletPath() {
//			@Override
//			public String getPath() {
//				return "/";
//			}
//		};
//		LOGGER.debug("Initialized DispatcherServletPath...");
//    	return obj;
//    }
//    
//    @Bean	
//    public ServletRegistrationBean<HttpServlet> dispatcherServlet() {
//    	LOGGER.debug("Initializing Application Servlet...");
//    	ServletRegistrationBean<HttpServlet> servRegBean = new ServletRegistrationBean<>();
//    	servRegBean.setName("genius-rating-servlet");
// 	   	servRegBean.setServlet(new DispatcherServlet(getContext()));
// 	   	Map<String,String> params = new HashMap<String,String>();
// 	   	params.put("contextConfigLocation",GeniusRatingSpringConfiguration.class.getName());
// 	   	servRegBean.setInitParameters(params);
// 	   	servRegBean.addUrlMappings("*.do");
// 	   	servRegBean.setLoadOnStartup(1);
// 	   LOGGER.debug("Initialized Application Servlet...");
// 	   	return servRegBean;
//    }
//
//	private static AnnotationConfigWebApplicationContext getContext() {
//        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
//        context.register(GeniusRatingSpringConfiguration.class);
//        return context;
//	}

}