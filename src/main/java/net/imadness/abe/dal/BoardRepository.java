package net.imadness.abe.dal;

import net.imadness.abe.models.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface BoardRepository extends JpaRepository<Board, Long> {
}