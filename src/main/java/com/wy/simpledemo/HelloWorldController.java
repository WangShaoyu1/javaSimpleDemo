package com.wy.simpledemo;

import java.util.concurrent.atomic.AtomicLong;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.wy.simpledemo.GreetingDTO;
import io.swagger.annotations.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@Api(tags = {"HelloWorld，你好"})
@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class HelloWorldController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @ApiResponses(value = {@ApiResponse(code = 200, message = "000000:成功，否则失败")})
    @PostMapping(value = "/hello-world", produces = {"application/json"})
    public Object sayHello(@Valid @RequestBody GreetingDTO greetingDTO) {
        String content = greetingDTO.getContent();
        Long id = greetingDTO.getId();

        Map<String, Object> response = new HashMap<>();
        response.put("id", id*id);
        response.put("content", String.format(template, content));
        return response;
    }
}