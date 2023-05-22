package org.gpg.alarm.core.info.repository;

import org.gpg.alarm.core.info.entity.ServiceInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceInfoRepository extends JpaRepository<ServiceInfo, Long> {
}
