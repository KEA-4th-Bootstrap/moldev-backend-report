package org.bootstrap.moldev.controller;

import lombok.RequiredArgsConstructor;
import org.bootstrap.moldev.common.SuccessResponse;
import org.bootstrap.moldev.dto.request.BaseReportRequestDto;
import org.bootstrap.moldev.dto.response.ReportNotProcessedResponseDto;
import org.bootstrap.moldev.entity.ReportType;
import org.bootstrap.moldev.service.ReportIntegrationService;
import org.bootstrap.moldev.service.ReportServiceFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/report")
public class ReportController {

    private final ReportServiceFactory reportServiceFactory;
    private final ReportIntegrationService reportIntegrationService;

    @PostMapping
    public ResponseEntity<SuccessResponse<?>> submitReport(@RequestParam(name = "type") ReportType reportType,
                                                           @RequestBody BaseReportRequestDto baseReportRequestDto) {
        reportServiceFactory.getReportService(reportType).submitReport(baseReportRequestDto);
        return SuccessResponse.created(null);
    }

    @GetMapping("/processed")
    public ResponseEntity<SuccessResponse<?>> getReportListIsProcessed(@RequestParam(name = "type", required = false) ReportType reportType,
                                                            @PageableDefault Pageable pageable) {
        if (Objects.isNull(reportType)) {
            List<ReportNotProcessedResponseDto> reportList = reportIntegrationService.getReportListIsProcessed(pageable);
            return SuccessResponse.ok(reportList);
        }
        Page<ReportNotProcessedResponseDto> reportList = reportServiceFactory.getReportService(reportType).getReportListIsProcessed(pageable);
        return SuccessResponse.ok(reportList);
    }

    @GetMapping("/not-processed")
    public ResponseEntity<SuccessResponse<?>> getReportListIsNotProcessed(@RequestParam(name = "type", required = false) ReportType reportType,
                                                            @PageableDefault Pageable pageable) {
        if (Objects.isNull(reportType)) {
            List<ReportNotProcessedResponseDto> reportList = reportIntegrationService.getReportListIsNotProcessed(pageable);
            return SuccessResponse.ok(reportList);
        }
        Page<ReportNotProcessedResponseDto> reportList = reportServiceFactory.getReportService(reportType).getReportListIsNotProcessed(pageable);
        return SuccessResponse.ok(reportList);
    }

}
