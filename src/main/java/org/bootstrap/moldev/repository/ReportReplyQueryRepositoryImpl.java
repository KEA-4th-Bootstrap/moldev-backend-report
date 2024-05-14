package org.bootstrap.moldev.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.bootstrap.moldev.dto.response.ReportNotProcessedResponseDto;
import org.bootstrap.moldev.entity.ReportReply;
import org.bootstrap.moldev.entity.ReportType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.bootstrap.moldev.entity.QReportReply.reportReply;

@Repository
@RequiredArgsConstructor
public class ReportReplyQueryRepositoryImpl implements ReportReplyQueryRepository {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Page<ReportNotProcessedResponseDto> getReportReplyListForResponseByProcessed(String search, Pageable pageable, boolean isProcessed) {
        List<ReportReply> reportReplyList = jpaQueryFactory
                .selectFrom(reportReply)
                .where(reportReply.isProcessed.eq(isProcessed))
                .orderBy(reportReply.id.desc())
                .offset((long) pageable.getPageNumber() * pageable.getPageSize())
                .limit(pageable.getPageSize())
                .fetch();

        List<ReportNotProcessedResponseDto> reportReplyListDto = reportReplyList.stream()
                .map(reportReply -> ReportNotProcessedResponseDto.of(reportReply, ReportType.REPLY, reportReply.getReplyId()))
                .toList();

        Long reportReplyCount = jpaQueryFactory.select(reportReply.count())
                .from(reportReply)
                .fetchFirst();

        return PageableExecutionUtils.getPage(reportReplyListDto, pageable, () -> reportReplyCount);
    }
}
