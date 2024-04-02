package cn.pangchun;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 主函数
 *
 * @author zhangqianchun
 * @since 2024/4/2
 */
@SpringBootApplication
@Slf4j
public class APP {
    public static void main(String[] args) {
        SpringApplication.run(APP.class, args);
    }
}
