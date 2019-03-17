package com.example.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.web.service.TodoService;

@Controller
public class TodoController {

	@Autowired
    TodoService todoSerive;

    @RequestMapping(value="/list-todos", method = RequestMethod.GET)
    public ModelAndView showTodos(ModelMap model){
        String name = (String) model.get("name");
        System.out.println(name);
        ModelAndView m = new ModelAndView();
        m.setViewName("todo");
        m.addObject("todos", todoSerive.retrieveTodos(name));
        return m;
    }
}
