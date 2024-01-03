package br.com.edu.picpayclone;

import io.netty.util.concurrent.ThreadPerTaskExecutor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
public class ExecucaoAssincronaConfiguracao {
    @Bean(name = "asyncExecutor")
    public Executor getAsyncExecutor(){
        ThreadPooTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePollSize(3);
        executor.setMaxPoolSize(3);
        executor.setQueueCapacity(100);
        executor.setThreadNamePrefix("AsyncThread-");
        executor.initialize();
        return executor;
    }
}
