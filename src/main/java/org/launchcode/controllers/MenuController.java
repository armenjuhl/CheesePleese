package org.launchcode.controllers;

import org.launchcode.models.Category;
import org.launchcode.models.Menu;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

public class MenuController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("title", "Categories");
        model.addAttribute("categories", "categoryDao.findAll()");
        model.addAttribute("Menu","menuDao.findAll(cheeses)");
        return "menu/index";
    }


    @RequestMapping(value ="view", method = RequestMethod.POST)
    public String add(Model model, Errors errors) {
        model.addAttribute("menu","Menu");
        model.addAttribute("errors", "Errors");
        model.addAttribute("Menu", "menuDao.save()");
        if (errors.hasErrors()){
            return "menu/add";
        }

        return "redirect:view/" + Menu.getId();
    }

    @RequestMapping(value ="view/{menuId}", method = RequestMethod.GET)
    public String viewMenu(Model model, @PathVariable int menuId){
        menuId = Menu.getId();
        model.addAttribute("Menu","menuDao.findOne(menuId)");
        return "menu/view" + Menu.getId();
    }

    @RequestMapping(value ="addItem", method = RequestMethod.POST)
    public String AddMenuItemForm(Model model) {
    model.addAttribute("form","menuDao.save()");
        model.addAttribute("cheeses", "cheeseDao.findAll()");
        return "add-item";
    }

}



/*@RequestMapping(value ="add", method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("menu","Menu");
        return "menu/add";
}*/

