package app.controllers;

import app.dao.HiberDAO;
import app.models.Footwear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @Autowired
    HiberDAO dao;


    @RequestMapping("wears.do")
    public ModelAndView showAll() {
        ModelAndView mv = new ModelAndView("view");
        mv.addObject("footwears", dao.getAllFootwears());
        mv.addObject("headwears", dao.getAllHeadwears());
        mv.addObject("outerwears", dao.getAllOuterwears());
        mv.addObject("underwears", dao.getAllUnderwears());
        return mv;
    }

    @RequestMapping("addHeadwear.do")
    public ModelAndView addHeadwear(String color, String name){
        dao.addHeadwear(color, name);
        return showAll();
    }

    @RequestMapping("addFootwear.do")
    public ModelAndView addFootwear(String color, String name){
        dao.addFootwear(color, name);
        return showAll();
    }

    @RequestMapping("addOuterwear.do")
    public ModelAndView addOuterwear(String color, String name){
        dao.addOuterwear(color, name);
        return showAll();
    }

    @RequestMapping("addUnderwear.do")
    public ModelAndView addUnderwear(String color, String name){
        dao.addUnderwear(color, name);
        return showAll();
    }

    @RequestMapping("init.do")
    public String init(){
        dao.init();
        return "redirect:list.do";
    }

}
