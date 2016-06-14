package net.imadness.abe.dal;

import net.imadness.abe.models.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface EntryRepository extends JpaRepository<Entry, Long> {
}