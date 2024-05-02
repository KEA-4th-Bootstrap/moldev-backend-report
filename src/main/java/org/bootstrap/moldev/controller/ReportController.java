package org.bootstrap.moldev.controller;

import lombok.RequiredArgsConstructor;
import org.bootstrap.moldev.common.SuccessResponse;
import org.bootstrap.moldev.dto.request.SubmitReportPostRequestDto;
import org.bootstrap.moldev.dto.request.SubmitReportReplyRequestDto;
import org.bootstrap.moldev.dto.response.SubmitReportPostResponseDto;
import org.bootstrap.moldev.dto.response.SubmitReportReplyResponseDto;
import org.bootstrap.moldev.service.ReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/report")
public class ReportController {

    private final ReportService reportService;

    @PostMapping("/post")
    public ResponseEntity<SuccessResponse<?>> submitReportPost(@RequestBody SubmitReportPostRequestDto submitReportPostRequestDto) {
        SubmitReportPostResponseDto submitReportPostResponseDto = reportService.submitReportPost(submitReportPostRequestDto);
        return SuccessResponse.created(submitReportPostResponseDto);
    }

    @PostMapping("/reply")
    public ResponseEntity<SuccessResponse<?>> submitReportReply(@RequestBody SubmitReportReplyRequestDto submitReportReplyRequestDto) {
        SubmitReportReplyResponseDto submitReportReplyResponseDto = reportService.submitReportReply(submitReportReplyRequestDto);
        return SuccessResponse.created(submitReportReplyResponseDto);
    }
}
