package org.bootstrap.moldev.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.bootstrap.moldev.dto.request.BaseReportRequestDto;
import org.bootstrap.moldev.entity.ReportReply;
import org.bootstrap.moldev.repository.ReportReplyRepository;
import org.bootstrap.moldev.repository.ReportRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Transactional
@Service("REPLY")
public class ReportReplyService implements ReportService {

    private final ReportReplyRepository reportReplyRepository;

    @Override
    public void submitReport(BaseReportRequestDto baseReportRequestDto) {
        ReportReply reportReply = ReportReply.of(baseReportRequestDto);
        reportReplyRepository.save(reportReply);
    }
}
