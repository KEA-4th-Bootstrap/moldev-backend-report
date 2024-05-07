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

import java.util.List;

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

    @GetMapping
    public ResponseEntity<SuccessResponse<?>> getReportList(@PageableDefault Pageable pageable) {
        List<ReportResponseDto> reportList = reportIntegrationService.getReportList(pageable);
        return SuccessResponse.ok(reportList);
    }

}
