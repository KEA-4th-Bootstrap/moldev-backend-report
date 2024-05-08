package org.bootstrap.moldev.repository;

import org.bootstrap.moldev.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long>, ReportQueryRepository {
}
