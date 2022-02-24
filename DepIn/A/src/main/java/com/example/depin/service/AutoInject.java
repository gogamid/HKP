package main.java.com.example.depin.service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
public @interface AutoInject {
    Class toInjectFor();
}
