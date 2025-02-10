package com.nhatdang2604.controllers;

import org.apache.thrift.transport.TTransportException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nhatdang2604.adapters.ThriftAdapter;

@RestController
@RequestMapping("api/v1/profile")
public class ProfileController {

    private ThriftAdapter thriftAdapter;

    public ProfileController(ThriftAdapter thriftAdapter) {
        this.thriftAdapter = thriftAdapter;
    }

    @GetMapping("/")
    public String getProfile(String name) throws TTransportException {
        return thriftAdapter.getProfile(name);
    }
}
