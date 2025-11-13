package com.ssafy.webmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@ComponentScan(basePackages = {"com.ssafy.webmvc", "com.ssafy.book"})
@SpringBootApplication
public class SpringHomework1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringHomework1Application.class, args);
	}

	
	
	// !!! [시작] 이 코드로 완전히 교체해 주세요. !!!
		@Bean
		public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
			return args -> {
				System.out.println("==================================================");
				System.out.println(">>> Spring이 인식한 모든 URL Mappings <<<");
				System.out.println("==================================================");

				RequestMappingHandlerMapping mapping = ctx.getBean(RequestMappingHandlerMapping.class);
				
				mapping.getHandlerMethods().forEach((info, method) -> {
					
					// [수정된 부분] URL 패턴이 없는 매핑(null)은 건너뜁니다.
					if (info.getPatternsCondition() != null) { 
						
						System.out.println("URL: " + info.getPatternsCondition().getPatterns() + ",   \t\t"
								+ "메서드: " + method.getMethod().getName());
					}
				});
				System.out.println("==================================================");
			};
		}
		// !!! [끝] 여기까지 교체 !!!
}
