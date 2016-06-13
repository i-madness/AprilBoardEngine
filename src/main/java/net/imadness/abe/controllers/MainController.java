package net.imadness.abe.controllers;

import net.imadness.abe.dal.BoardRepository;
import net.imadness.abe.dal.EntryRepository;
import net.imadness.abe.models.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Autowired
    private EntryRepository entryRepository;

    @Autowired
    private BoardRepository boardRepository;

    @RequestMapping("/")
    public String index(ModelMap modelMap) {
        Board board = boardRepository.findOne(2l);
        modelMap.addAttribute("board", board);
        return "index";
    }

}
