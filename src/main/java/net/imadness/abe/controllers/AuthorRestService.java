package net.imadness.abe.controllers;

import net.imadness.abe.models.Author;
import net.imadness.abe.models.dto.AuthorDto;
import net.imadness.abe.services.AuthorService;
import net.imadness.abe.util.IpAddressUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 *
 */
@RestController
public class AuthorRestService {

    @Autowired
    private AuthorService authorService;

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorRestService.class);

    /**
     * Обрабатывает HTTP-запрос, приходящий на сервер, когда пользователь вводит никнейм в соответствующее поле.
     * Устанавливает значение никнейма на полученное.
     *
     * @param nickname новое значение никнейма
     * @param request объект пользовательского запроса
     * @return объект ответа сервера с указанием статуса
     */
    public ResponseEntity<String> processUsernameRequest(@RequestParam String nickname, HttpServletRequest request) {
        try {
            AuthorDto authorDto = new AuthorDto();
            authorDto.setNickname(nickname);
            Author userInstance = null;
            // попытка найти пользователя по его IP-адресу
            String ipAddress = IpAddressUtil.getClientIpAddress(request);
            authorDto.setIpAddress(ipAddress);
            userInstance = authorService.getAuthorByIpAddress(ipAddress);
            if (userInstance == null) {
                // попытка найти пользователя по его ID, сохранённому в cookie браузера
                Long idCookie = null;
                for (Cookie cookie : request.getCookies()) {
                    if (cookie.getName().equals("uId"))
                        idCookie = Long.parseLong(cookie.getValue());
                }
                if (idCookie != null)
                    authorService.updateAuthor(authorDto);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                authorService.updateAuthor(authorDto);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        } catch (Exception e) {
            LOGGER.warn("Ошибка при обновлении никнейма пользователя на {}:", nickname, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
