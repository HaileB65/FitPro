package FitPro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"src/main/java/FitPro"})
public class FitProApplication {

	public static void main(String[] args) {
		SpringApplication.run(FitProApplication.class, args);
	}

}
