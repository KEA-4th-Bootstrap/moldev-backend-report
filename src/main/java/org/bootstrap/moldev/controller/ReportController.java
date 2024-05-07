package org.bootstrap.moldev.controller;

import lombok.RequiredArgsConstructor;
import org.bootstrap.moldev.common.SuccessResponse;
import org.bootstrap.moldev.dto.request.BaseReportRequestDto;
import org.bootstrap.moldev.entity.ReportRequestType;
import org.bootstrap.moldev.service.ReportServiceFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/report")
public class ReportController {

    private final ReportServiceFactory reportServiceFactory;

    @PostMapping
    public ResponseEntity<SuccessResponse<?>> submitReport(@RequestParam(name = "type") ReportRequestType reportRequestType,
                                                           @RequestBody BaseReportRequestDto baseReportRequestDto) {
        reportServiceFactory.getReportService(reportRequestType).submitReport(baseReportRequestDto);
        return SuccessResponse.created(null);
    }

}
