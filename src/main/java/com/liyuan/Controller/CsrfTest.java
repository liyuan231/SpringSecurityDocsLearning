package com.liyuan.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
public class CsrfTest {
    @GetMapping("/token_")
    public String csrfTest(){
        return "/token.html";
    }
}
