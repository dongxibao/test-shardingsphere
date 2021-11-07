package top.dongxibao.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("top.dongxibao.demo.mapper")
@SpringBootApplication
public class TestShardingsphereApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestShardingsphereApplication.class, args);
    }

}
