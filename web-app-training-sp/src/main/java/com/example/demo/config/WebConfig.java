package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ページングの設定
 *
 * @author future
 *
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

//	@Override
//	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
//		PageableHandlerMethodArgumentResolver resolver = new PageableHandlerMethodArgumentResolver();
//
//		// ページ単位で表示する件数
//		resolver.setFallbackPageable(new PageRequest(0, 5));
//		argumentResolvers.add(resolver);
//		super.addArgumentResolvers(argumentResolvers);
//	}
}