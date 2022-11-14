/*
 * RequirementRepository.java
 *
 * Created on Nov 15, 2022, 05.48
 */
package com.irfin.reqeng.repository;

import com.irfin.reqeng.entity.Requirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author Irfin A.
 */
@Repository
public interface RequirementRepository extends JpaRepository<Requirement, UUID>
{
}
