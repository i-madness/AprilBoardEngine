package net.imadness.abe.dal;

import net.imadness.abe.models.Board;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface BoardRepository extends CrudRepository<Board, Long> {
}