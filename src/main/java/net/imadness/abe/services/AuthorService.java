package net.imadness.abe.services;

import net.imadness.abe.dal.AuthorRepository;
import net.imadness.abe.models.Author;
import net.imadness.abe.models.dto.AuthorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * TODO: implement this
 */
@Service
@Transactional
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    /**
     *
     * @return
     */
    public List<Author> getAllAuthors() {
        return authorRepository.findAll(new Sort(Sort.Direction.ASC));
    }

    public Author getAuthorById(Long id) {
        return authorRepository.findOne(id);
    }

    /**
     *
     * @param ipAddress
     * @return
     */
    public Author getAuthorByIpAddress(String ipAddress) {
        return authorRepository.findByIpAddress(ipAddress);
    }

    /**
     * Обновляет экземпляр сущности автора в базе данных
     */
    public Author updateAuthor(AuthorDto authorDto) {
        Author dbAuthor = authorRepository.findByIpAddress(authorDto.getIpAddress());
        if (dbAuthor == null) {
            dbAuthor = authorRepository.findOne(authorDto.getId());
        }
        dbAuthor.setIpAddress(authorDto.getIpAddress());
        dbAuthor.setNickname(authorDto.getNickname());
        return authorRepository.saveAndFlush(dbAuthor);
    }
}
