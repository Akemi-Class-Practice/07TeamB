package com.example.common.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class OpenBrowser implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(OpenBrowser.class);

    @Value("${open.browser.url}")
    private String url;

//    @Override
//    public void run(String... args) throws Exception {
//        logger.info("项目启动成功……");
//        try {
//            // 可以指定自己的路径
//            Runtime.getRuntime().exec("cmd   /c   start   " + url);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
    
    // 如果是mac或win的系统就用这个自动打开界面
    @Override
    public void run(String... args) throws Exception {
        logger.info("项目启动成功……");
        try {
            // 指定要打开的URL
            String url = "http://localhost:8888/end/page/login.html";

            // 使用命令行来打开默认的Web浏览器
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("mac")) {
                // Mac系统下打开默认浏览器
                Runtime.getRuntime().exec("open " + url);
            } else if (os.contains("windows")) {
                // Windows系统下打开默认浏览器
                Runtime.getRuntime().exec("cmd   /c   start   " + url);
//            } else if (os.contains("linux")) {
//                // Linux系统下打开默认浏览器（可以根据具体的Linux发行版调整命令）
//                Runtime.getRuntime().exec("xdg-open " + url);
            } else {
                logger.error("不支持的操作系统。");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    

}