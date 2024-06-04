package com.equipatour.coreservice.shared.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public abstract class AuditModel {

    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    protected Date createdDate;

    @Column(name = "updated_date")
    @LastModifiedDate
    @Null
    protected Date updatedDate;

    @Column(name="_deleted")
    @NotNull
    protected Boolean _deleted;

    @PrePersist
    protected void prePersist(){
        _deleted = false;
        createdDate = new Date();
    }

    @PreUpdate
    protected void preUpdate(){
        updatedDate = new Date();
    }


}
