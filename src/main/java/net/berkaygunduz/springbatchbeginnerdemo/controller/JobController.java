package net.berkaygunduz.springbatchbeginnerdemo.controller;

import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.parameters.*;
import org.springframework.batch.core.launch.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobOperator jobOperator;

    @Autowired
    private Job job;

    @PostMapping("/importCustomers")
    public void importCsvToDBJob(){
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("startAt",System.currentTimeMillis())
                .toJobParameters();

        try {
            jobOperator.start(job,jobParameters);
        } catch (Exception e){
            e.printStackTrace();
        }

    }

}
