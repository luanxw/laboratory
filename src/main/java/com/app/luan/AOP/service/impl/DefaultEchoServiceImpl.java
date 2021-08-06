package com.app.luan.AOP.service.impl;

public class DefaultEchoServiceImpl implements com.app.luan.AOP.service.EchoService {
    @Override
    public String enco(String meassage) {
        return "DefaultService retrun: "+meassage;
    }
}
