package org.bootstrap.moldev.repository;

import org.bootstrap.moldev.dto.response.ReportResponseDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReportPostQueryRepository {
    List<ReportResponseDto> getReportPostListForResponse(Pageable pageable);
}
