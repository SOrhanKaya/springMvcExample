package com.controller;
import com.model.Persontb;
import com.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

@Controller
@RequestMapping("/")
@RestController
public class PersonController {
    @Autowired
    PersonService personService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getForms(ModelAndView model) {
        Persontb personForm = new Persontb();
        model.addObject("getForm", personForm);
        model.setViewName("checkCoordinates");
        return model;
    }

    @RequestMapping(value = "/savedCoordinates", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getAllData() {
        List<Persontb> list = (personService.getPerson());
        ModelAndView model = new ModelAndView("checkCoordinates");
        model.addObject("personList", list);
        return model;
    }

    @RequestMapping(value = "/saveCoordinates", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView savePerson(@ModelAttribute Persontb person) {
        personService.saveUpdate(person);
        return new ModelAndView("checkCoordinates");
    }
    @RequestMapping(value = "/checkCoordinates", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getFirst() {
        List<Persontb> list = (personService.getPerson());
        ModelAndView model = new ModelAndView("checkCoordinates");
        if (list.isEmpty()==false){
            model.addObject("xCoor", list.get(0).getCoordinateX());
            model.addObject("yCoor", list.get(0).getCoordinateY());
            model.addObject("personTc", list.get(0).getPersonTc());
        }
        return model;
    }
}