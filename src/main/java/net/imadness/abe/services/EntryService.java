package net.imadness.abe.services;

import net.imadness.abe.dal.BoardRepository;
import net.imadness.abe.dal.EntryRepository;
import net.imadness.abe.models.Board;
import net.imadness.abe.models.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Содержит CRUD-методы на основе использования EntryRepository, учитывающие специфику запроса,
 * приходящего со стороны клиента (использование пагинации).
 */
@Service
@Transactional
public class EntryService {

    @Autowired
    private EntryRepository entryRepository;

    @Autowired
    private BoardRepository boardRepository;

    /**
     * Возвращает определённую страницу из {@link Entry}
     *
     * @param pageNumber номер страницы
     * @return страница с записями
     */
    public Page<Entry> getEntries(Long boardId, Integer pageNumber) {
        Pageable pageable = createPageRequest(pageNumber);
        Board board = boardRepository.findOne(boardId);
        return entryRepository.findByBoard(board, pageable);
    }

    /**
     * Возвращает объект форумной записи с определённым ID
     *
     * @param id id записи
     * @return запись
     */
    public Entry getEntryById(Long id) {
        return entryRepository.findOne(id);
    }

    /**
     * Сохраняет объект записи в БД
     *
     * @param entry запись для сохранения
     * @return сохраненный объект
     */
    public Entry insertEntry(Entry entry) {
        return entryRepository.save(entry);
    }

    /**
     * Изменяет данные об уже существующей в БД записи
     *
     * @param entry экземпляр записи с новыми данными
     * @param id    id записи, которую нужно обновить
     * @return сохраненный объект
     */
    public Entry updateEntry(Entry entry, Long id) {
        Entry dbEntry = entryRepository.findOne(id);
        dbEntry.setContent(entry.getContent());
        dbEntry.setDate(entry.getDate());
        return entryRepository.save(dbEntry);
    }

    /**
     * Удаляет определённую запись из БД
     *
     * @param id id удаляемой записи
     */
    public void deleteEntry(Long id) {
        entryRepository.delete(id);
    }

    /**
     * Возвращает {@code PageRequest} с данными о пагинации для дальнейшего использования в запросе
     *
     * @return объект PageRequest
     */
    private PageRequest createPageRequest(Integer pageNumber) {
        // TODO: извлечь из админского репозитория настройки, получить данные о пагинации
        return new PageRequest(pageNumber, 10);
    }

}
