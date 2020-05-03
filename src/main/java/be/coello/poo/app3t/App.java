package be.coello.poo.app3t;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import be.coello.poo.app3t.ui.IUi;

@SpringBootApplication
public class App implements CommandLineRunner {
	
	private static IUi ui; 
	

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		
		ui = (UIi) ctx.getBean("uiConsole");
		
		
		// TODO Auto-generated method stub
		System.out.println("go");

	}

	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
