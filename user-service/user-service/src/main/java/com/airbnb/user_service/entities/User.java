package com.airbnb.user_service.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String provide;

    private String providerSubject;

    @Column(
            name = "created_at"
    )
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(
            name = "updated_at"
    )
    @UpdateTimestamp
    private LocalDateTime updateAt;

    private Boolean isActive;
}
