package ex;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "ex")   //해당패키지의 Component를 모두 bean으로 생성
public class ProductConfig {

}

//스프링 설정 파일로서 스프링 컨테이너를 생성하게 만드는 어노테이션
//이 어노테이션이 붙은 Class는 Config 파일이 되어 xml 파일과 같은 기능을 한다
