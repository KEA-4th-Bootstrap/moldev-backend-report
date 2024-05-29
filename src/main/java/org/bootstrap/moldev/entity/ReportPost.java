package org.bootstrap.moldev.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.bootstrap.moldev.dto.request.BaseReportRequestDto;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "report_post")
@Entity
@OnDelete(action = OnDeleteAction.CASCADE)
public class ReportPost extends Report {

    @Column(name = "post_id", nullable = false)
    private Long postId;

    @Builder(access = AccessLevel.PRIVATE)
    public ReportPost(BaseReportRequestDto baseReportRequestDto) {
        super(baseReportRequestDto.reportRequestDto());
        this.postId = ((Number)baseReportRequestDto.contentId()).longValue();
    }

    public static ReportPost of(BaseReportRequestDto baseReportRequestDto) {
        return ReportPost.builder()
                .baseReportRequestDto(baseReportRequestDto)
                .build();
    }
}
