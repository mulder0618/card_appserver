package com.zhx.test.controller;

import com.zhx.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by mulder on 2015/6/16.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    /**
     * ≤‚ ‘“≥√Ê
     * @param modelAndView
     * @return
     */
    @RequestMapping("/showtest")
         public ModelAndView showtest(ModelAndView modelAndView){
        modelAndView.setViewName("test/testindex");
        return modelAndView;
    }

    /**
     * ≤‚ ‘mysql¡¥Ω”
     * @param modelAndView
     * @return
     */
    @RequestMapping("/testmysqlcontract")
    public ModelAndView testmysqlcontract(ModelAndView modelAndView){
        int count = testService.testCount();
        modelAndView.addObject("count",count);
        modelAndView.setViewName("test/testmysqlcontract");
        return modelAndView;
    }

    /**
     * ≤Â»Î≤‚ ‘
     * @param modelAndView
     * @return
     */
    @Transactional
    @RequestMapping("/testinsert")
    public ModelAndView testinsert(ModelAndView modelAndView){
        testService.testInsert("≤‚ ‘");
        testService.testInsert("≤‚1231222222sdfdsfsdfdsfffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffsdfs ‘");
        modelAndView.setViewName("test/testindex");
        return modelAndView;
    }

}
