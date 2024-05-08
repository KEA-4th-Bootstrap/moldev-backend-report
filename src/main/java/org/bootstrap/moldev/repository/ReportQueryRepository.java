package org.bootstrap.moldev.repository;

import com.querydsl.core.Tuple;
import org.bootstrap.moldev.dto.response.ReportResponseDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReportQueryRepository {
    List<ReportResponseDto> getReportListForResponse(Pageable pageable);
}
