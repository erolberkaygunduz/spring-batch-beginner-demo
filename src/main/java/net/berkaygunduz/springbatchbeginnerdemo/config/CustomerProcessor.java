package net.berkaygunduz.springbatchbeginnerdemo.config;

import net.berkaygunduz.springbatchbeginnerdemo.entity.Customer;
import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.infrastructure.item.ItemProcessor;

public class CustomerProcessor implements ItemProcessor<Customer,Customer> {

    private static final Logger log = LoggerFactory.getLogger(CustomerProcessor.class);

    @Override
    public @Nullable Customer process(Customer customer) throws Exception {
        Thread t = Thread.currentThread();
        log.info("Processing customerId={} | virtual={} | threadId={}", customer.getId(), t.isVirtual(), t.threadId());
        return customer;
    }
}
