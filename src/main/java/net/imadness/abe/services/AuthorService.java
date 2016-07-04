package net.imadness.abe.services;

import net.imadness.abe.dal.AuthorRepository;
import net.imadness.abe.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * TODO: implement this
 */
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    /**
     *
     * @return
     */
    public List<Author> getAllAuthors() {
        return authorRepository.findAll(new Sort(Sort.Direction.ASC));
    }
}
