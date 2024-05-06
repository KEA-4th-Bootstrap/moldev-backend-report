package org.bootstrap.moldev.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.bootstrap.moldev.common.BaseTimeEntity;
import org.bootstrap.moldev.entity.converter.ReasonTypeConverter;
import org.springframework.lang.NonNull;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@SuperBuilder
@Entity
@Getter
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "report_type")
public abstract class Report extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id")
    private Long id;

    @NonNull
    @Column(name = "reporter_id")
    private Long reporterId;

    @NonNull
    @Convert(converter = ReasonTypeConverter.class)
    private ReasonType reason;

    @Column(name = "is_processed")
    @Builder.Default
    private boolean isProcessed = false;

}
