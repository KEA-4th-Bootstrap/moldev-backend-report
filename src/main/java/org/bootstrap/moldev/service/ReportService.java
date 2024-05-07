package org.bootstrap.moldev.service;

import org.bootstrap.moldev.dto.request.BaseReportRequestDto;
import org.springframework.stereotype.Service;

@Service
public interface ReportService {
    void submitReport(BaseReportRequestDto baseReportRequestDto);
}
