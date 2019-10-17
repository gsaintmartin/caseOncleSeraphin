package caseoncleseraphin;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class App {
	
	public App() {
		
		System.out.println("Application started");
			
	}
}
