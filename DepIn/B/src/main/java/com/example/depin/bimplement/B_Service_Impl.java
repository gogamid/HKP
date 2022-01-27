package com.example.depin.bimplement;

import com.example.depin.service.AutoInject;
import com.example.depin.service.B_Service;

@AutoInject(toInjectFor = B_Service.class)
public class B_Service_Impl implements B_Service {
    @Override
    public String opB2() {
        return "this is opB2";
    }
}
