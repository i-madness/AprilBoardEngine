package net.imadness.abe.controllers;

import net.imadness.abe.dal.BoardRepository;
import net.imadness.abe.dal.EntryRepository;
import net.imadness.abe.models.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private EntryRepository entryRepository;

    @Autowired
    private BoardRepository boardRepository;

    private static final String applicationName = "April Board Engine";

    @RequestMapping("/")
    public String index(ModelMap modelMap) {
        List<Board> boards = boardRepository.findAll();
        modelMap.addAttribute("appName", applicationName);
        modelMap.addAttribute("boards", boards);
        return "index";
    }

}
