package com.equipatour.coreservice.assets.domain.model;

import com.equipatour.coreservice.assets.resources.requests.CreateScaleRequestDto;
import com.equipatour.coreservice.shared.domain.model.AuditModel;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "weight_balances")
@Where(clause = "_deleted = false")
@SQLDelete(sql = "UPDATE weight_balances SET _deleted = true WHERE id = ?")
public class WeightBalance extends AuditModel {

    @Column(name = "weight")
    private Double weight;

    @Formula("concat(serie,'-', number)")
    private String serieNumber;

    @Column(name = "serie")
    private String serie;

    @Column(name = "number")
    private String number;

    public WeightBalance(CreateScaleRequestDto createScaleRequestDto) {
        this.number = createScaleRequestDto.getNumber();
        this.serie = createScaleRequestDto.getSerie();
    }
}
