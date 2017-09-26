package org.launchcode.controllers;

import org.launchcode.models.Category;
import org.launchcode.models.data.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;


@Controller
@RequestMapping(value = "category")
public class CategoryController {

    @Autowired
    private CategoryDao categoryDao;

    //public findAll(){ArrayList <Object> allCategories;
    //allCategories = allCategories + name.CategoryDao}


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("title", "Categories");
        model.addAttribute("categories", categoryDao.findAll());
        //model.addAttribute("menuDao.findAll(cheeses)");
        return "category/index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute(new Category());
        model.addAttribute("title","Add Category");
    return "add.html";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Model model,
      @ModelAttribute @Valid Category category, Errors errors) {

        if (errors == null) {
            model.addAttribute(categoryDao.save(category));
            return "redirect:";
        }
        else {
            return "redirect:add.html";
    }
        }
}