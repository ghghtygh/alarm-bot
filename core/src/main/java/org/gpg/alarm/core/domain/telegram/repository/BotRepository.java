package org.gpg.alarm.core.domain.telegram.repository;

import org.gpg.alarm.core.domain.telegram.entity.Bot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BotRepository extends JpaRepository<Bot, Long> {
}
