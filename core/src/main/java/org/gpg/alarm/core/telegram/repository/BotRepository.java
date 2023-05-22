package org.gpg.alarm.core.telegram.repository;

import org.gpg.alarm.core.telegram.entity.Bot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BotRepository extends JpaRepository<Bot, Long> {
}
