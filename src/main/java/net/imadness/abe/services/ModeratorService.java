package net.imadness.abe.services;

import net.imadness.abe.dal.ModeratorRepository;
import net.imadness.abe.models.Moderator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Содержит CRUD-методы сущности Moderator на основе использования ModeratorRepository,
 * а также элементы логики для модератора
 */
@Service
public class ModeratorService {

    @Autowired
    private ModeratorRepository moderatorRepository;

    public List<Moderator> getModerators() {
        return moderatorRepository.findAll();
    }

    public Moderator getModeratorById(Long id) {
        return moderatorRepository.getOne(id);
    }

    public Moderator insertModerator(Moderator moderator) {
        return moderatorRepository.save(moderator);
    }

    public Moderator updateModerator(Moderator moderator) {
        Moderator dbModerator = moderatorRepository.findOne(moderator.getId());
        dbModerator.setName(moderator.getName());
        dbModerator.setPassword(moderator.getPassword());
        return moderatorRepository.save(dbModerator);
    }

    public void deleteModerator(Long id) {
        moderatorRepository.delete(id);
    }

    public void banUserByIp(String ipAddress) {
        // TODO: implement this
    }
}
