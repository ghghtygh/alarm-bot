package org.gpg.alarm.core.domain.telegram.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Bot {

    @Id
    @Column
    private Long id;

    @Column
    private String token;

    @Column
    private String name;

    @Builder
    public Bot(Long id, String token, String name) {
        this.id = id;
        this.token = token;
        this.name = name;
    }
}
