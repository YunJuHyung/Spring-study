package org.iclass.di2.setter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import lombok.extern.slf4j.Slf4j;
@Slf4j
//자동 주입을 확인하기 위한 main
public class BuyApp2 {
	
	public static void main(String[] args) {
		
		// spring-context : bean에 접근하기위해 사용. bean 은 스프링 컨테이너에 저장.
		ApplicationContext context
			= new AnnotationConfigApplicationContext(BuyConfig.class);
		//AnnotationConfigApplicationContext : ApplicationContext를 구성하는 설정파일은 어노테이션으로 한다.
		log.info("::: 스프링 컨테이너에 저자된 bean의 이름확인 :::");
		String[] beans = context.getBeanDefinitionNames(); // bean의 이름들 가져오기
		for (String bean : beans) {
			System.out.println(bean);
		}
		
		//빈 컨테이너에서 buy2Controller 빈을 가져오기 : 타입으로 가져오기 또는 이름으로 가져오기
		log.debug("Buy2Controller 빈 가져와서 buy 메소드 실행하기 - -----------------");
		Buy2Controller buy2Controller = context.getBean(Buy2Controller.class);
		log.info("buy2Controller : {}",buy2Controller);
		buy2Controller.buy();
		log.debug("----------------------------------------------------------");
		((AbstractApplicationContext)context).close();
		//AnnotationConfigApplicationContext의 부모클래스 AbstractApplicationContext로 캐스팅
	}
}
