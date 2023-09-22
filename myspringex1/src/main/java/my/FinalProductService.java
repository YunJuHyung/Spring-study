package my;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FinalProductService {
	
	private FinalProductDao dao;			
	
	//3) setter 주입을 위해서 기본생성자 정의
	public FinalProductService() {
		System.out.println("::::: ProductService 생성자 ::::");
	}

	@Autowired
	public void setDao(FinalProductDao dao) {
		System.out.println("---- ProductService setter 메소드 ----");
		this.dao = dao;
	}
	
	//2)생성자 주입
	//@Autowired  //3)setter 주입할 때 주석처리
	public FinalProductService(FinalProductDao dao) {
		System.out.println("::::: ProductService 생성자 - ProductDao bean 주입 :::");
		this.dao=dao;
	}
	
	public void product() {
		System.out.println("---- ProductService product() 메소드 ----");
		dao.product();
	}
}
