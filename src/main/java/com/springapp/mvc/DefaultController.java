package com.springapp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Simon on 2015/9/24.
 */
@Controller
@RequestMapping("/")
public class DefaultController {
    @RequestMapping(method = RequestMethod.GET)
    public void index(HttpServletRequest request, HttpServletResponse response){
        try {
            request.getRequestDispatcher("/hello").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
