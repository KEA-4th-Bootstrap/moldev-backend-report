package org.bootstrap.moldev.repository;

import org.bootstrap.moldev.entity.ReportPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportPostRepository extends JpaRepository<ReportPost, Long>, ReportPostQueryRepository {
}
