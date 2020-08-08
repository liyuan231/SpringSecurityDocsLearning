package com.liyuan.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@RestController
@Controller
public class CsrfTest {
    @GetMapping("/token_")
    public String csrfTest() {
        return "/token.html";
    }

    @PostMapping("/transfer")
    @ResponseBody
    public String transfer(@RequestParam(value = "_csrf", required = false) String csrf,
                           @RequestParam("amount") String amount,
                           @RequestParam("routingNumber") Integer routingNumber,
                           @RequestParam("account") String account) {
        System.out.println(1);
        return "-1";
    }

    @GetMapping("/transfer")
    public String transfer_(@RequestParam(value = "_csrf", required = false) String csrf,
                            @RequestParam("amount") String amount,
                            @RequestParam("routingNumber") Integer routingNumber,
                            @RequestParam("account") String account) {
        System.out.println(1);
        return "-1";
    }

    @RequestMapping(value = "/process", method = {RequestMethod.POST})
    @ResponseBody
    public String test1() {
        return "you have invoke the http request: '/process' without a csrf token, " +
                "which means that the csrf ignore the trace request";
    }
    @RequestMapping(value = "/process", method = {RequestMethod.GET})
    @ResponseBody
    public String test2() {
        return "you have invoke the http request: '/process' without a csrf token, " +
                "which means that the csrf ignore the trace request";
    }
    @RequestMapping(value = "/process", method = {RequestMethod.HEAD})
    @ResponseBody
    public String test3() {
        return "you have invoke the http request: '/process' without a csrf token, " +
                "which means that the csrf ignore the trace request";
    }
    @RequestMapping(value = "/process", method = {RequestMethod.OPTIONS})
    @ResponseBody
    public String test4() {
        return "you have invoke the http request: '/process' without a csrf token, " +
                "which means that the csrf ignore the trace request";
    }
    @RequestMapping(value = "/process", method = {RequestMethod.PUT})
    @ResponseBody
    public String test5() {
        return "you have invoke the http request: '/process' without a csrf token, " +
                "which means that the csrf ignore the trace request";
    }
    @RequestMapping(value = "/process", method = {RequestMethod.DELETE})
    @ResponseBody
    public String test6() {
        return "you have invoke the http request: '/process' without a csrf token, " +
                "which means that the csrf ignore the trace request";
    }
    @RequestMapping(value = "/process", method = {RequestMethod.TRACE})
    @ResponseBody
    public String test() {
        return "you have invoke the http request: '/process' without a csrf token, " +
                "which means that the csrf ignore the trace request";
    }
}
