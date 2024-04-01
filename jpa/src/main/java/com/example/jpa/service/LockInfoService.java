package com.example.jpa.service;

import com.example.jpa.repository.LockInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LockInfoService {

    private final LockInfoRepository lockInfoRepository;

    @Autowired
    public LockInfoService(LockInfoRepository lockInfoRepository) {
        this.lockInfoRepository = lockInfoRepository;
    }

    public void printLockInfo() {
        List<Object[]> lockInfos = lockInfoRepository.getLockInfo();
        for (Object[] lockInfo : lockInfos) {
            System.out.println("Session ID: " + lockInfo[0] + ", Request Mode: " + lockInfo[1]);
        }
    }
}
