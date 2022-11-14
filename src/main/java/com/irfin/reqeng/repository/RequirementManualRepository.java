/*
 * RequirementManualRepository.java
 *
 * Created on Nov 15, 2022, 06.05
 */
package com.irfin.reqeng.repository;

import com.irfin.reqeng.entity.Requirement;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Irfin A.
 */
public interface RequirementManualRepository
{
    List<Requirement> findAll();
    Optional<Requirement> findById(UUID _id);
}
