package org.bootstrap.moldev.repository;

import org.bootstrap.moldev.vo.ReportResponseVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReportQueryRepository {
    Page<ReportResponseVo> getReportListForResponseByProcessed(String search, Pageable pageable, boolean isProcessed);
}
