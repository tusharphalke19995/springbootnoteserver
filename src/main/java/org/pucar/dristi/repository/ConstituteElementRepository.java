package org.pucar.dristi.repository;

import org.pucar.dristi.entity.ConstituteElement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public interface ConstituteElementRepository extends JpaRepository<ConstituteElement, String> {

    @Transactional
    @Modifying
    @Query(value = "select e from ConstituteElement e where e.caseId = :caseId")
    List<ConstituteElement> getAllConstituteElements(@Param("caseId") String caseId);
}
