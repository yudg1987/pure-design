/*
 * package com.dgyu.springboot.config;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * springfox.documentation.builders.ApiInfoBuilder; import
 * springfox.documentation.builders.PathSelectors; import
 * springfox.documentation.builders.RequestHandlerSelectors; import
 * springfox.documentation.oas.annotations.EnableOpenApi; import
 * springfox.documentation.service.ApiInfo; import
 * springfox.documentation.service.Contact; import
 * springfox.documentation.spi.DocumentationType; import
 * springfox.documentation.spring.web.plugins.Docket;
 * 
 * @Configuration
 * 
 * @EnableOpenApi public class SwaggerConfig {
 * 
 * 
 *//**
	 * 创建API应用 apiInfo() 增加API相关信息
	 * 通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现，
	 * 本例采用指定扫描的包路径来定义指定要建立API的目录。
	 *
	 * @return
	 */
/*
 * @Bean public Docket restApi() { return new
 * Docket(DocumentationType.SWAGGER_2) .groupName("标准接口")
 * .apiInfo(apiInfo("Spring Boot中使用Swagger2构建RESTful APIs", "1.0"))
 * .useDefaultResponseMessages(true) .forCodeGeneration(false) .select()
 * .apis(RequestHandlerSelectors.basePackage("com.dgyu.springboot.controller"))
 * .paths(PathSelectors.any()) .build(); }
 * 
 *//**
	 * 创建该API的基本信息（这些基本信息会展现在文档页面中） 访问地址：http://ip:port/swagger-ui.html
	 *
	 * @return
	 *//*
		 * private ApiInfo apiInfo(String title, String version) { return new
		 * ApiInfoBuilder() .title(title) .description("更多请关注: 俞登刚主页")
		 * .termsOfServiceUrl("https://blog.csdn.net/dgyu") .contact(new Contact("dgyu",
		 * "https://blog.csdn.net/dgyu", "398305246@qq.com.com")) .version(version)
		 * .build(); }
		 * 
		 * 
		 * }
		 */


package com.dgyu.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dgyu.springboot.common.ResultEnum;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * SwaggerConfig
 * 
 * @author dgyu
 *
 */

@Configuration
@EnableSwagger2WebMvc
public class SwaggerConfig {

	@Bean
	public Docket createRestApi() {
		// 添加全局响应状态码
		List<ResponseMessage> responseMessageList = new ArrayList<>();
		Arrays.stream(ResultEnum.values()).forEach(resultEnum -> {
			responseMessageList.add(new ResponseMessageBuilder().code(Integer.parseInt(resultEnum.getCode()))
					.message(resultEnum.getMsg()).build());
		});

		return new Docket(DocumentationType.SWAGGER_2)
				// 添加全局响应状态码
				.globalResponseMessage(RequestMethod.GET, responseMessageList)
				.globalResponseMessage(RequestMethod.POST, responseMessageList)
				.globalResponseMessage(RequestMethod.PUT, responseMessageList)
				.globalResponseMessage(RequestMethod.DELETE, responseMessageList).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.dgyu.springboot.controller")).paths(PathSelectors.any()).build();

	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("后台管理平台").description("后台管理平台")
				.contact(new Contact("dgyu", "dgyu@iflytek.com", "dgyu@iflytek.com")).version("1.0").build();
	}
}
