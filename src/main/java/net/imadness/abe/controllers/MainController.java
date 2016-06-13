package net.imadness.abe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    //@Autowired
    //private EntryRepository entryRepo;

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "jello";
        /*try {
            Object nya = entryRepo.save(new Entry("Boo", new Date()));
            return nya.toString();
        } catch (Exception e) {
            return e.getMessage();
        }*/
    }


}
