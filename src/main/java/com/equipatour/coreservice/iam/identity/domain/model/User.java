package com.equipatour.coreservice.iam.identity.domain.model;

import com.equipatour.coreservice.shared.domain.model.AuditModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Date;


@Setter
@With
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "users")
@Where(clause = "_deleted = false")
@SQLDelete(sql = "UPDATE users SET _deleted = true WHERE id = ?")
public class User extends AuditModel {
    @NotNull
    @Size(max = 100)
    @Column(name = "email")
    private String email;

}
