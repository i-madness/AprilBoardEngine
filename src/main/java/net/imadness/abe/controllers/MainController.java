package net.imadness.abe.controllers;

import net.imadness.abe.models.Author;
import net.imadness.abe.models.Board;
import net.imadness.abe.models.dto.AuthorDto;
import net.imadness.abe.services.AuthorService;
import net.imadness.abe.services.BoardService;
import net.imadness.abe.services.EntryService;
import net.imadness.abe.util.IpAddressUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    private BoardService boardService;

    @Autowired
    private AuthorService authorService;

    private static final String APPLICATION_NAME = "April Board Engine";

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    /**
     * Подготавливает представление главной страницы
     */
    @RequestMapping("/")
    public String index(ModelMap modelMap, @CookieValue("aId") String authorId, HttpServletRequest request, HttpServletResponse response) {
        try {
            // Проверка и установка Cookie с ID автора
            if (authorId == null) {
                String ipAddress = IpAddressUtil.getClientIpAddress(request);
                Author author = authorService.getAuthorByIpAddress(ipAddress);
                if (author == null) {
                    AuthorDto newAuthorRecord = new AuthorDto();
                    newAuthorRecord.setIpAddress(ipAddress);
                    Author createdAuthorRecord = authorService.insertAuthor(newAuthorRecord);
                    response.addCookie(new Cookie("aId", createdAuthorRecord.getId().toString()));
                } else
                    response.addCookie(new Cookie("aId", author.getId().toString()));
            }
            List<Board> boards = boardService.getAllBoards();
            modelMap.addAttribute("appName", APPLICATION_NAME);
            modelMap.addAttribute("boards", boards);
        } catch (Exception e) {
            LOGGER.trace("Ошибка при загрузке списка форумов на главную страницу", e);
            modelMap.addAttribute("errorName", "Ошибка при подготовке главной страницы!");
            modelMap.addAttribute("errorMessage", "Произошла ошибка при загрузке списка форумов на главную страницу.<br>" + e.getMessage());
            return "error";
        }
        LOGGER.info("Главная страница подготовлена и загружена");
        return "index";
    }

}
