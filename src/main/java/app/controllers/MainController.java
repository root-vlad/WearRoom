package app.controllers;

import app.dao.HiberDAO;
import app.models.Color;
import app.models.Footwear;
import app.models.Headwear;
import app.service.Fashion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
        dao.init();
        return mv;
    }

//    @RequestMapping("fashionWears.do")
//    public ModelAndView showFashionWears() {
//        ModelAndView mv = new ModelAndView("view");
//        mv.addObject("footwears", fashion.getFashionFootwears(dao));
//        mv.addObject("headwears", fashion.getFashionHeadwears(dao));
//        mv.addObject("outerwears", fashion.getFashionOuterwears(dao));
//        mv.addObject("underwears", fashion.getFashionUnderwears(dao));
//        return mv;
//    }

    @RequestMapping("fashionHeadwears.do")
    public ModelAndView showFashionHeadwears(Authentication authentication) {
        String username = authentication.getName();
        ModelAndView mv = new ModelAndView("headwear");
        mv.addObject("headwears", fashion.getFashionHeadwears(dao, username));
        return mv;
    }
    @RequestMapping("headwears.do")
    public ModelAndView showHeadwears(Authentication authentication) {
        String username = authentication.getName();
        ModelAndView mv = new ModelAndView("headwear");
        mv.addObject("headwears", dao.getAllHeadwearsCurrentUser(username));
        return mv;
    }
    @RequestMapping("addHeadwear.do")
    public ModelAndView addHeadwear(String color, String name, Authentication authentication){
        String username = authentication.getName();
        dao.addHeadwear(color, name, username);
        return showHeadwears(authentication);
    }

    @RequestMapping("fashionFootwears.do")
    public ModelAndView showFashionFootwears(Authentication authentication) {
        String username = authentication.getName();
        ModelAndView mv = new ModelAndView("footwear");
        mv.addObject("footwears", fashion.getFashionFootwears(dao, username));
        return mv;
    }
    @RequestMapping("footwears.do")
    public ModelAndView showFootwears(Authentication authentication) {
        String username = authentication.getName();
        ModelAndView mv = new ModelAndView("footwear");
        mv.addObject("footwears", dao.getAllFootwearsCurrentUser(username));
        return mv;
    }
    @RequestMapping("addFootwear.do")
    public ModelAndView addFootwear(String color, String name, Authentication authentication){
        String username = authentication.getName();
        dao.addFootwear(color, name, username);
        return showFootwears(authentication);
    }

    @RequestMapping("fashionOuterwears.do")
    public ModelAndView showFashionOuterwears(Authentication authentication) {
        String username = authentication.getName();
        ModelAndView mv = new ModelAndView("outerwear");
        mv.addObject("outerwears", fashion.getFashionOuterwears(dao, username));
        return mv;
    }
    @RequestMapping("outerwears.do")
    public ModelAndView showOuterwears(Authentication authentication) {
        String username = authentication.getName();
        ModelAndView mv = new ModelAndView("outerwear");
        mv.addObject("outerwears", dao.getAllOuterwearsCurrentUser(username));
        return mv;
    }
    @RequestMapping("addOuterwear.do")
    public ModelAndView addOuterwear(String color, String name, Authentication authentication){
        String username = authentication.getName();
        dao.addOuterwear(color, name, username);
        return showOuterwears(authentication);
    }

    @RequestMapping("fashionUnderwears.do")
    public ModelAndView showFashionUnderwears(Authentication authentication) {
        String username = authentication.getName();
        ModelAndView mv = new ModelAndView("underwear");
        mv.addObject("underwears", fashion.getFashionUnderwears(dao, username));
        return mv;
    }
    @RequestMapping("underwears.do")
    public ModelAndView showUnderwears(Authentication authentication) {
        String username = authentication.getName();
        ModelAndView mv = new ModelAndView("underwear");
        mv.addObject("underwears", dao.getAllUnderwearsCurrentUser(username));
        return mv;
    }
    @RequestMapping("addUnderwear.do")
    public ModelAndView addUnderwear(String color, String name, Authentication authentication){
        String username = authentication.getName();
        dao.addUnderwear(color, name, username);
        return showUnderwears(authentication);
    }

    @RequestMapping("/api/headwears.do")
    @ResponseBody
    public List<Headwear> getHeadwears() {
        return dao.getAllHeadwears();
    }

    @RequestMapping("/api/colors.do")
    @ResponseBody
    public List<Color> getColors() {
        return dao.getAllColors();
    }

    @RequestMapping("/api/add/colors.do")
    @ResponseBody
    public Color addColor(@RequestBody String colorName) {
        dao.addColor(colorName);
        Color color = new Color(colorName);
        return color;
    }

//    @RequestMapping("init.do")
//    public String init(){
//        dao.init();
//        return "redirect:wears.do";
//    }

}
