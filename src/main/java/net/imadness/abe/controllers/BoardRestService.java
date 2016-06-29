package net.imadness.abe.controllers;

import net.imadness.abe.models.Entry;
import net.imadness.abe.services.BoardService;
import net.imadness.abe.services.EntryService;
import net.imadness.abe.util.RestResponseWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST-сервис, обслуживающий определённую доску. Обрабатывает все запросы, связанные каким-либо изменением
 * досок или записей
 */
@RestController
@RequestMapping("/board")
public class BoardRestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BoardRestService.class);

    private BoardService boardService;
    private EntryService entryService;

    @Autowired
    public BoardRestService(BoardService boardService, EntryService entryService) {
        this.boardService = boardService;
        this.entryService = entryService;
    }

    /**
     * Возвращает записии для определённой страницы доски
     *
     * @param id   ID выбранной доски
     * @param page номер страницы
     * @return записи со страницы доски
     */
    @RequestMapping("/{id}/{page}")
    public ResponseEntity<RestResponseWrapper<List<Entry>>> getBoardPage(@PathVariable Long id, @PathVariable Integer page) {
        try {
            List<Entry> pageEntries = entryService.getEntries(id, page).getContent();
            return new ResponseEntity<>(new RestResponseWrapper<>(pageEntries), HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.warn("Ошибка при запросе записей для {} страницы доски с ID={}", id, page, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
