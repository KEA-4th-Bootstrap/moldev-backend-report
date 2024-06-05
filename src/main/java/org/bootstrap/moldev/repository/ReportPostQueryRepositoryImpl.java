package org.bootstrap.moldev.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.bootstrap.moldev.entity.ReportPost;
import org.bootstrap.moldev.entity.ReportType;
import org.bootstrap.moldev.vo.ReportResponseVo;
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
    public Page<ReportResponseVo> getReportPostListForResponseByProcessed(String search, Pageable pageable, boolean isProcessed) {
        List<ReportPost> reportPostList = jpaQueryFactory
                .selectFrom(reportPost)
                .where(
                        eqIsProcessed(isProcessed),
                        containsReporteeId(search)
                )
                .orderBy(reportPost.id.desc())
                .offset((long) pageable.getPageNumber() * pageable.getPageSize())
                .limit(pageable.getPageSize())
                .fetch();

        List<ReportResponseVo> reportPostListDto = reportPostList.stream()
                .map(reportPost -> ReportResponseVo.of(reportPost, ReportType.POST, reportPost.getPostId()))
                .toList();

        Long reportPostCount = jpaQueryFactory.select(reportPost.count())
                .from(reportPost)
                .fetchFirst();

        return PageableExecutionUtils.getPage(reportPostListDto, pageable, () -> reportPostCount);
    }

    private BooleanExpression eqIsProcessed(Boolean isProcessed) {
        return isProcessed == null ? null : reportPost.isProcessed.eq(isProcessed);
    }

    private BooleanExpression containsReporteeId(String search) {
        return search == null ? null : reportPost.reporteeId.contains(search);
    }
}
