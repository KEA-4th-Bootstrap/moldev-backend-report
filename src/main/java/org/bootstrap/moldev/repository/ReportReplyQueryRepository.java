package org.bootstrap.moldev.repository;

import org.bootstrap.moldev.dto.response.ReportResponseDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReportReplyQueryRepository {
    List<ReportResponseDto> getReportReplyListForResponse(Pageable pageable);
}
