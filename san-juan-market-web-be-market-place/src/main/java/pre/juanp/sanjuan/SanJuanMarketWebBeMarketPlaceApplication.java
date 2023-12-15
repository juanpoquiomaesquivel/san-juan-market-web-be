package pre.juanp.sanjuan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "pre.juanp.sanjuan")
public class SanJuanMarketWebBeMarketPlaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SanJuanMarketWebBeMarketPlaceApplication.class, args);
	}
}
