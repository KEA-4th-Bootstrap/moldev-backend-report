package org.bootstrap.moldev.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.bootstrap.moldev.dto.response.ReportResponseDto;
import org.bootstrap.moldev.entity.ReportReply;
import org.bootstrap.moldev.entity.ReportType;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.bootstrap.moldev.entity.QReportReply.reportReply;

@Repository
@RequiredArgsConstructor
public class ReportReplyQueryRepositoryImpl implements ReportReplyQueryRepository {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<ReportResponseDto> getReportReplyListForResponse(Pageable pageable) {
        List<ReportReply> reportReplyList = jpaQueryFactory.selectFrom(reportReply)
                .orderBy(reportReply.id.desc())
                .offset((long) pageable.getPageNumber() * pageable.getPageSize())
                .limit(pageable.getPageSize())
                .fetch();

        return reportReplyList.stream()
                .map(reportReply -> ReportResponseDto.of(reportReply, ReportType.REPLY, reportReply.getReplyId()))
                .toList();
    }
}
