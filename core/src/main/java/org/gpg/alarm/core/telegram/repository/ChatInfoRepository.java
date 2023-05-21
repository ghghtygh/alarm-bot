package org.gpg.alarm.core.telegram.repository;

import org.gpg.alarm.core.telegram.entity.ChatInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatInfoRepository extends JpaRepository<ChatInfo, Long> {
}
