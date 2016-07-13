package net.imadness.abe.controllers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Глобальный обработчик исключений для контроллеров
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(BoardLoadingException.class)
    public String handleMainViewException(Exception exception, ModelMap model) {
        model.addAttribute("errorName", "Ошибка при подготовке главной страницы!");
        model.addAttribute("errorMessage", "Произошла ошибка при загрузке списка форумов на главную страницу.<br>" + exception.getMessage());
        return "error";
    }
}
