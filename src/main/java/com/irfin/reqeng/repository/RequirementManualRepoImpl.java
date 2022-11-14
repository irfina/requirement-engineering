/*
 * RequirementManualRepo.java
 *
 * Created on Nov 15, 2022, 06.05
 */
package com.irfin.reqeng.repository;

import com.irfin.reqeng.entity.Requirement;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Irfin A.
 */
@Repository
public class RequirementManualRepoImpl implements RequirementManualRepository
{
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Requirement> findAll()
    {
        var sql = """
            SELECT CAST(id AS VARCHAR), name, description, req_date, priority, created_at
            FROM requirement
            ORDER BY created_at
            """;

        var query = em.createNativeQuery(sql);
        List<Object[]> rows = query.getResultList();
        if (rows.isEmpty())
            return Collections.emptyList();

        var retval = new LinkedList<Requirement>();
        Requirement req;
        for (Object[] row : rows) {
            req = new Requirement();
            req.setId(UUID.fromString((String) row[0]));
            req.setName((String) row[1]);
            req.setDescription((String) row[2]);

            var tstamp = (Timestamp) row[3];
            //req.setReqDate(tstamp.toLocalDateTime().atOffset(ZoneOffset.of(ZoneOffset.) ZoneId.systemDefault().getId())));
            req.setPriority((int) row[4]);

            tstamp = (Timestamp) row[5];
            req.setCreatedAt(tstamp.toLocalDateTime());

            retval.add(req);
        }
        return retval;
    }

    @Override
    public Optional<Requirement> findById(UUID _id)
    {
        return Optional.empty();
    }
}
