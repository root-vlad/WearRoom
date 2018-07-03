package app.controllers;

import app.dao.HiberDAO;
import app.models.Footwear;
import app.service.Fashion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @Autowired
    HiberDAO dao;
    Fashion fashion = new Fashion();

    @RequestMapping("wears.do")
    public ModelAndView showAll() {
        ModelAndView mv = new ModelAndView("view");
        mv.addObject("footwears", dao.getAllFootwears());
        mv.addObject("headwears", dao.getAllHeadwears());
        mv.addObject("outerwears", dao.getAllOuterwears());
        mv.addObject("underwears", dao.getAllUnderwears());
        return mv;
    }

    @RequestMapping("fashionWears.do")
    public ModelAndView showFashionWears() {
        ModelAndView mv = new ModelAndView("view");
        mv.addObject("footwears", fashion.getFashionFootwears(dao));
        mv.addObject("headwears", fashion.getFashionHeadwears(dao));
        mv.addObject("outerwears", fashion.getFashionOuterwears(dao));
        mv.addObject("underwears", fashion.getFashionUnderwears(dao));
        return mv;
    }

    @RequestMapping("fashionHeadwears.do")
    public ModelAndView showFashionHeadwears() {
        ModelAndView mv = new ModelAndView("headwear");
        mv.addObject("headwears", fashion.getFashionHeadwears(dao));
        return mv;
    }
    @RequestMapping("headwears.do")
    public ModelAndView showHeadwears() {
        ModelAndView mv = new ModelAndView("headwear");
        mv.addObject("headwears", dao.getAllHeadwears());
        return mv;
    }
    @RequestMapping("addHeadwear.do")
    public ModelAndView addHeadwear(String color, String name){
        dao.addHeadwear(color, name);
        return showHeadwears();
    }

    @RequestMapping("fashionFootwears.do")
    public ModelAndView showFashionFootwears() {
        ModelAndView mv = new ModelAndView("footwear");
        mv.addObject("footwears", fashion.getFashionFootwears(dao));
        return mv;
    }
    @RequestMapping("footwears.do")
    public ModelAndView showFootwears() {
        ModelAndView mv = new ModelAndView("footwear");
        mv.addObject("footwears", dao.getAllFootwears());
        return mv;
    }
    @RequestMapping("addFootwear.do")
    public ModelAndView addFootwear(String color, String name){
        dao.addFootwear(color, name);
        return showFootwears();
    }

    @RequestMapping("fashionOuterwears.do")
    public ModelAndView showFashionOuterwears() {
        ModelAndView mv = new ModelAndView("outerwear");
        mv.addObject("outerwears", fashion.getFashionOuterwears(dao));
        return mv;
    }
    @RequestMapping("outerwears.do")
    public ModelAndView showOuterwears() {
        ModelAndView mv = new ModelAndView("outerwear");
        mv.addObject("outerwears", dao.getAllOuterwears());
        return mv;
    }
    @RequestMapping("addOuterwear.do")
    public ModelAndView addOuterwear(String color, String name){
        dao.addOuterwear(color, name);
        return showOuterwears();
    }

    @RequestMapping("fashionUnderwears.do")
    public ModelAndView showFashionUnderwears() {
        ModelAndView mv = new ModelAndView("underwear");
        mv.addObject("underwears", fashion.getFashionUnderwears(dao));
        return mv;
    }
    @RequestMapping("underwears.do")
    public ModelAndView showUnderwears() {
        ModelAndView mv = new ModelAndView("underwear");
        mv.addObject("underwears", dao.getAllUnderwears());
        return mv;
    }
    @RequestMapping("addUnderwear.do")
    public ModelAndView addUnderwear(String color, String name){
        dao.addUnderwear(color, name);
        return showUnderwears();
    }

    @RequestMapping("init.do")
    public String init(){
        dao.init();
        return "redirect:wears.do";
    }

}
