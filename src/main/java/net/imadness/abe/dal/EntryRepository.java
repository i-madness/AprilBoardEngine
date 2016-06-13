package net.imadness.abe.dal;

import net.imadness.abe.models.Entry;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface EntryRepository extends CrudRepository<Entry, Long> {
}