package org.bootstrap.moldev.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.bootstrap.moldev.dto.response.ReportResponseDto;
import org.bootstrap.moldev.entity.QReportPost;
import org.bootstrap.moldev.entity.ReasonType;
import org.bootstrap.moldev.entity.ReportPost;
import org.bootstrap.moldev.entity.ReportType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.bootstrap.moldev.entity.QReportPost.reportPost;

@Repository
@RequiredArgsConstructor
public class ReportPostQueryRepositoryImpl implements ReportPostQueryRepository {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Page<ReportResponseDto> getReportPostListForResponseByProcessed(Pageable pageable, boolean isProcessed) {
        List<ReportPost> reportPostList = jpaQueryFactory
                .selectFrom(reportPost)
                .where(reportPost.isProcessed.eq(isProcessed))
                .orderBy(reportPost.id.desc())
                .offset((long) pageable.getPageNumber() * pageable.getPageSize())
                .limit(pageable.getPageSize())
                .fetch();

        List<ReportResponseDto> reportPostListDto = reportPostList.stream()
                .map(reportPost -> ReportResponseDto.of(reportPost, ReportType.POST, reportPost.getPostId()))
                .toList();

        Long reportPostCount = jpaQueryFactory.select(reportPost.count())
                .from(reportPost)
                .fetchFirst();

        return PageableExecutionUtils.getPage(reportPostListDto, pageable, () -> reportPostCount);
    }
}
