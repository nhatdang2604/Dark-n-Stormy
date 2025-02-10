package com.nhatdang2604.services;

import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ThriftProfileServiceImpl implements ThriftProfileService.Iface {

    private Random randomizer;

    @Autowired
    public ThriftProfileServiceImpl() {
        this.randomizer = new Random();
    }

    @Override
    public String getProfile(String name) throws TException {
        
        int poolSize = 100;
        String[] dictionary = new String[poolSize + 1];
        for (int i = 0; i < poolSize; ++i) {
            dictionary[i] = "test_" + i; 
        }

        randomizer = new Random();
        int randomIdx = randomizer.nextInt(name.length()) % poolSize;
        
        return dictionary[randomIdx];
    }

}
