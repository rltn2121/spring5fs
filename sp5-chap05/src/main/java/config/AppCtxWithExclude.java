package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;

import spring.*;

@Configuration
@ComponentScan(basePackages = {"spring"}, 
				excludeFilters = {
						@Filter(type = FilterType.REGEX, pattern = "spring\\..*Dao"),
						@Filter(type = FilterType.REGEX, pattern = "spring2\\..*"),
						@Filter(type = FilterType.ASPECTJ, pattern = "spring.*Dao"),
						@Filter(type = FilterType.ANNOTATION, classes = {NoProduct.class, ManualBean.class}),
						@Filter(type = FilterType.ASSIGNABLE_TYPE, classes = MemberDao.class)
				})


public class AppCtxWithExclude {
	@Bean
	public MemberDao memberDao(){
		return new MemberDao();
	}
	
	@Bean
	@Qualifier("printer")
	public MemberPrinter memberPrinter1(){
		return new MemberPrinter();
	}
}
