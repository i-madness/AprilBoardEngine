package net.imadness.abe.dal;

import net.imadness.abe.models.Moderator;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторий, содержащий базовые CRUD-операции с сущностью {@code Moderator}
 */
public interface ModeratorRepository extends JpaRepository<Moderator, Long> {
}
