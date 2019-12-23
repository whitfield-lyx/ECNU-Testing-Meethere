package ecnu.testing.meethere;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "ecnu.testing.meethere.mapper")
public class MeetHereApplication {
    public static void main(String[] args) {
        SpringApplication.run(MeetHereApplication.class, args);
    }

}
