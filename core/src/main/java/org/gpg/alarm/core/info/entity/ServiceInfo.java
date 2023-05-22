package org.gpg.alarm.core.info.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.gpg.alarm.core.common.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class ServiceInfo extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_info_id")
    private Long id;

    @Column
    private String serviceName;

    @Column
    private String serviceKey;

    @Column
    @Enumerated(EnumType.STRING)
    private ServiceStatus status;

    @Column
    private LocalTime sendTime;

    @Column
    private LocalDateTime suspendDttm;

    @Column
    private LocalDateTime resumeDttm;


}
