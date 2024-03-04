package com.bank.customerservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfig {

    @Bean
    public Executor asyncEexecutor() {

        /*
        create ThreadPoolTaskExecutor object in config and set threadPoolSize to run async call on different thread,
        otherwise by default synchronous call run on Main thread and
        all async calls run on another single thread (async call execute sequentially by default).

        we can also provide bean name @Bean("myAsync") and use in @Async("myAsync")

         */
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setMaxPoolSize(4);
        taskExecutor.setCorePoolSize(4);
        taskExecutor.setQueueCapacity(100);
        taskExecutor.setThreadNamePrefix("AsyncTaskThread");
        taskExecutor.initialize();
        return taskExecutor;
    }
}
