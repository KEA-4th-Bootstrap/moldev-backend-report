package org.bootstrap.moldev.controller;

import lombok.RequiredArgsConstructor;
import org.bootstrap.moldev.common.SuccessResponse;
import org.bootstrap.moldev.dto.request.BaseReportRequestDto;
import org.bootstrap.moldev.dto.response.ReportResponseDto;
import org.bootstrap.moldev.entity.ReportType;
import org.bootstrap.moldev.service.ReportIntegrationService;
import org.bootstrap.moldev.service.ReportServiceFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
                                                            @RequestParam(name = "search", required = false) String search,
                                                            @PageableDefault Pageable pageable) {
        if (Objects.isNull(reportType)) {
            ReportResponseDto reportList = reportIntegrationService.getReportListIsProcessed(search, pageable);
            return SuccessResponse.ok(reportList);
        }
        ReportResponseDto reportList = reportServiceFactory.getReportService(reportType).getReportListIsProcessed(search, pageable);
        return SuccessResponse.ok(reportList);
    }

    @GetMapping("/not-processed")
    public ResponseEntity<SuccessResponse<?>> getReportListIsNotProcessed(@RequestParam(name = "type", required = false) ReportType reportType,
                                                            @RequestParam(name = "search", required = false) String search,
                                                            @PageableDefault Pageable pageable) {
        if (Objects.isNull(reportType)) {
            ReportResponseDto reportList = reportIntegrationService.getReportListIsNotProcessed(search, pageable);
            return SuccessResponse.ok(reportList);
        }
        ReportResponseDto reportList = reportServiceFactory.getReportService(reportType).getReportListIsNotProcessed(search, pageable);
        return SuccessResponse.ok(reportList);
    }

    @PatchMapping("/{reportId}/processed")
    public ResponseEntity<SuccessResponse<?>> patchReportProcessed(@PathVariable Long reportId) {
        reportIntegrationService.updateReportProcessed(reportId);
        return SuccessResponse.ok(null);
    }

}
