package fgo.xiaox.archar;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("fgo.xiaox.archar.mapper")
public class ArcharApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArcharApplication.class, args);
    }

}
