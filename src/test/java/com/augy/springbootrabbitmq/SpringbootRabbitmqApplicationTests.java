package com.augy.springbootrabbitmq;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class SpringbootRabbitmqApplicationTests {
    private Logger log = LoggerFactory.getLogger(SpringbootRabbitmqApplicationTests.class);

    @Test
    void contextLoads() throws InterruptedException {

    }

}

class SynchronizedMethods {
    private Logger log = LoggerFactory.getLogger(SynchronizedMethods.class);

    private int sum = 0;

    public void calculate() {
        setSum(getSum() + 1);
        log.info("current value {}", sum);
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

}
