package net.imadness.abe.controllers;

import net.imadness.abe.dal.BoardRepository;
import net.imadness.abe.services.EntryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

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

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    /**
     * Подготавливает представление главной страницы
     */
    @RequestMapping("/")
    public String index(ModelMap modelMap) {
        /*try {
            List<Entry> boards = entryService.getEntries(0).getContent();
            modelMap.addAttribute("appName", applicationName);
            modelMap.addAttribute("boards", boards);
        } catch (Exception e) {*/
            LOGGER.warn("Ошибка при загрузке списка форумов на главную страницу");
            modelMap.addAttribute("errorName", "Ошибка при подготовке главной страницы!");
            modelMap.addAttribute("errorMessage", "Произошла ошибка при загрузке списка форумов на главную страницу.<br>" /*+ e.getMessage()*/);
            return "error";
        /*}
        LOGGER.info("Главная страница подготовлена и загружена");
        return "index";*/
    }

}
