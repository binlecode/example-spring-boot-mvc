package example.springboot.controller.rest

import example.springboot.model.User
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

import javax.servlet.http.HttpServletResponse

@RestController
@RequestMapping(value = '/user')
class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class)

    @RequestMapping(value = '', method = RequestMethod.GET)
    List<User> listUser() {
        log.debug 'listUser action called'
        return []
    }

    @RequestMapping(value = '/{id}', method = RequestMethod.GET)
    User showUser(@PathVariable long id) {
        //todo: call service for user
        return new User(id: id, firstName: 'Bin', lastName: 'Le', email: 'bin.le@construction.com')
    }


    //fixme: what's wrong with REST endpoint: status code, error control
    @RequestMapping(value = '', method = RequestMethod.POST)
    User saveUser(@RequestBody User user) {
        //todo: call service for user add
        if (!user.id) {
            user.id = 12345L
        }
        user
    }

    @RequestMapping(value = '/{id}', method = RequestMethod.DELETE)
    void deleteUser(@PathVariable long id, HttpServletResponse response) {
        if (id) {
            //todo: call service for deletion
        }
        response.status = HttpStatus.NO_CONTENT.value()
    }


}
