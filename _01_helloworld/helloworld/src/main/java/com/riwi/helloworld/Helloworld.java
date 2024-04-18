package com.riwi.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// @Controller Indica que la clase sera un Controller
@Controller
// @RequestMapping crea la ruta base del Controller
@RequestMapping("/controller")

public class Helloworld {

    // @GetMapping crea una ruta especifica para el Method
    @GetMapping("/helloworld")
    // @ResponseBody nos permite imprimir en el navegador
    @ResponseBody
    public String showMessage() {
        return "Hello world!";
    }

}
