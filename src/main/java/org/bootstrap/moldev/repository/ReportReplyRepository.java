package org.bootstrap.moldev.repository;

import org.bootstrap.moldev.entity.ReportReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportReplyRepository extends JpaRepository<ReportReply, Long> {
}
