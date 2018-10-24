package com.example.service;

import com.example.controller.MyJspController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTaskService {

    private static Logger logger = LoggerFactory.getLogger(MyJspController.class);

    @Scheduled(cron = "0/5 * * * * ?")
    public void runAutoImportData()
    {
        System.out.println("system out ---->runAutoImportData");
        logger.debug("---->runAutoImportData");

    }
}
