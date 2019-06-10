package com.oksanasb.recipebook.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "recipes")
//@EntityListeners(AuditingEntityListener.class)
public class RecipeEntity {
    @Id
    @Column (name = "recipe_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "recipe_name")
    private String name;
    @Lob
    private String description;
//
//    @Column(name = "create_date")
//    @CreatedDate
//    private LocalDateTime createDate;
//
//    @Column(name = "update_date")
//    @LastModifiedDate
//    private LocalDateTime updateDate;

}
