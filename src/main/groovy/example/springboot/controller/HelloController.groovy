package example.springboot.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class HelloController {

    @RequestMapping(value = '/', method = RequestMethod.GET)
    @ResponseBody
    String index() {
        'hello spring'
    }


}
