package com.example.demo.imageTest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/give-me")
public class ImageController {

    @GetMapping("/image-path")
    public String returnImagePath () {
        log.info("returnImagePath()");

        return "image.jpg";
    }
}
