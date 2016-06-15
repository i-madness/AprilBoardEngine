package net.imadness.abe.controllers;

import net.imadness.abe.dal.BoardRepository;
import net.imadness.abe.models.Entry;
import net.imadness.abe.services.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Основной контроллер приложения, обеспечивающий обработку клиентских запросов,
 * связанных с главной страницей форума и базовые REST-методы
 */
@Controller
public class MainController {

    @Autowired
    private EntryService entryService;

    @Autowired
    private BoardRepository boardRepository;

    private static final String applicationName = "April Board Engine";

    /**
     * Подготавливает представление главной страницы
     */
    @RequestMapping("/")
    public String index(ModelMap modelMap) {
        List<Entry> boards = entryService.getEntries(0).getContent();
        modelMap.addAttribute("appName", applicationName);
        modelMap.addAttribute("boards", boards);
        return "index";
    }

}
