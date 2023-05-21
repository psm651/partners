package com.earnmoneynow.partners;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class PartnersApplication {

    //	public static void main(String[] args) {
//		SpringApplication.run(PartnersApplication.class, args);
//	}
    public static void main(String[] args) throws IOException {
        String loginUrl = "https://partners.newspic.kr/login";
        Connection.Response loginPageResponse = Jsoup.connect(loginUrl)
                .timeout(3000)
                .header("Origin", "https://partners.newspic.kr")
                .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("accept-encoding", "gzip, deflate, br")
                .header("accept-language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7")
                .header("cache-control", "max-age=0")
                .header("upgrade-insecure-requests", "1")
                .header("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36")
                .method(Connection.Method.GET)
                .execute();

        Map<String, String> loginTryCookie = loginPageResponse.cookies();
        for (Map.Entry<String, String> entry : loginTryCookie.entrySet()) {
            System.out.println("key : " + entry.getKey() + " / " + "value : " + entry.getValue());
        }
        String id = "psm651@naver.com";
        String password = "qkrtjdals1!";
        String url = "https://partners.newspic.kr/main/index";
        String userAgent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36";
        // 전송할 폼 데이터
        Map<String, String> data = new HashMap<>();
        data.put("id", id);
        data.put("password", password);
        data.put("useCookie", "on");

        Connection.Response response = Jsoup.connect(loginUrl)
                .userAgent(userAgent)
                .timeout(3000)
                .header("Origin", "https://partners.newspic.kr")
                .header("Referer", loginUrl)
                .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("Accept-Language", "ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4")
                .header("upgrade-insecure-requests", "1")
                .cookies(loginTryCookie)
                .data(data)
                .method(Connection.Method.POST)
                .execute();


        Map<String, String> res = response.cookies();
        for (Map.Entry<String, String> entry : res.entrySet()) {
            System.out.println("key : " + entry.getKey() + " / " + "value2 : " + entry.getValue());
        }
        Document doc = Jsoup.connect(url).cookies(response.cookies()).get();
        System.out.println(doc);
    }


}
