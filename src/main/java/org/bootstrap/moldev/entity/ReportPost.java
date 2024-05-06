package org.bootstrap.moldev.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.bootstrap.moldev.dto.request.SubmitReportPostRequestDto;
import org.bootstrap.moldev.util.EnumValueUtils;
import org.springframework.lang.NonNull;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@SuperBuilder
@Getter
@Table(name = "report_post")
@Entity
public class ReportPost extends Report {

    @NonNull
    @Column(name = "post_id")
    private Long postId;

    public static ReportPost of(SubmitReportPostRequestDto fileReportRequestDto) {
        return ReportPost.builder()
                .postId(fileReportRequestDto.postId())
                .reporterId(fileReportRequestDto.reporterId())
                .reason(EnumValueUtils.toEntityCode(ReasonType.class, fileReportRequestDto.reasonCode()))
                .build();
    }
}
