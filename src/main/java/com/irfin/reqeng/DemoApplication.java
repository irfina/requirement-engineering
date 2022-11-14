package com.irfin.reqeng;

import com.irfin.reqeng.entity.Requirement;
import com.irfin.reqeng.repository.RequirementManualRepository;
import com.irfin.reqeng.repository.RequirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner
{
    public static void main(String[] args)
    {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Autowired
    private RequirementRepository requirementRepository;

    @Autowired
    private RequirementManualRepository manualRepo;

    @Override
    public void run(String... args) throws Exception
    {
        var reqs = requirementRepository.findAll();
        for (Requirement req : reqs) {
            System.out.printf("[%s] %s\n", req.getId(), req.getName());
        }

        System.out.println("=== Manual Repo ===");
        var list = manualRepo.findAll();
        for (Requirement req : list) {
            System.out.printf("[%s] %s\n", req.getId(), req.getName());
        }
    }
}
