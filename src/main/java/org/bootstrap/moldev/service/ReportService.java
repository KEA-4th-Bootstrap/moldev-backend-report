package org.bootstrap.moldev.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.bootstrap.moldev.dto.request.SubmitReportPostRequestDto;
import org.bootstrap.moldev.dto.request.SubmitReportReplyRequestDto;
import org.bootstrap.moldev.dto.response.SubmitReportPostResponseDto;
import org.bootstrap.moldev.dto.response.SubmitReportReplyResponseDto;
import org.bootstrap.moldev.entity.ReportPost;
import org.bootstrap.moldev.entity.ReportReply;
import org.bootstrap.moldev.repository.ReportRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Transactional
@Service
public class ReportService {

    private final ReportRepository reportRepository;

    public SubmitReportPostResponseDto submitReportPost(SubmitReportPostRequestDto reportPostRequestDto) {
        ReportPost reportPost = ReportPost.of(reportPostRequestDto);
        reportRepository.save(reportPost);
        return SubmitReportPostResponseDto.of(reportPost.getId());
    }

    public SubmitReportReplyResponseDto submitReportReply(SubmitReportReplyRequestDto reportReplyRequestDto) {
        ReportReply reportReply = ReportReply.of(reportReplyRequestDto);
        reportRepository.save(reportReply);
        return SubmitReportReplyResponseDto.of(reportReply.getId());
    }

}
