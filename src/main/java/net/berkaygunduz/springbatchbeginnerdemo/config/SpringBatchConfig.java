package net.berkaygunduz.springbatchbeginnerdemo.config;

import lombok.AllArgsConstructor;
import net.berkaygunduz.springbatchbeginnerdemo.entity.Customer;
import net.berkaygunduz.springbatchbeginnerdemo.repository.CustomerRepository;
import org.apache.catalina.Executor;
import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.Step;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.infrastructure.item.data.RepositoryItemWriter;
import org.springframework.batch.infrastructure.item.file.FlatFileItemReader;
import org.springframework.batch.infrastructure.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.*;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.*;
import org.springframework.core.task.support.TaskExecutorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.concurrent.Executors;

@Configuration
public class SpringBatchConfig {

    @Bean
    public FlatFileItemReader<Customer> reader() {
        return new FlatFileItemReaderBuilder<Customer>()
                .name("csvReader")
                .resource(new FileSystemResource("src/main/resources/customers.csv"))
                .linesToSkip(1)
                .delimited()
                .names("id", "firstName", "lastName", "email", "gender", "contactNo", "country", "dob")
                .targetType(Customer.class)
                .saveState(false)
                .build();
    }

    @Bean
    public CustomerProcessor processor() {
        return new CustomerProcessor();
    }

    @Bean
    public RepositoryItemWriter<Customer> writer(CustomerRepository customerRepository) {
        return new RepositoryItemWriter<Customer>(customerRepository);
    }

    @Bean
    public Step step1(JobRepository jobRepository
            , PlatformTransactionManager transactionManager
            , RepositoryItemWriter<Customer> repositoryItemWriter
            , AsyncTaskExecutor taskExecutor) {
        return new StepBuilder("step1", jobRepository)
                .<Customer, Customer>chunk(500)
                .transactionManager(transactionManager)
                .reader(reader())
                .processor(processor())
                .writer(repositoryItemWriter)
                .taskExecutor(taskExecutor)
                .build();
    }

    @Bean
    public Job runJob(JobRepository jobRepository, Step step1) {
        return new JobBuilder("runJob", jobRepository)
                .flow(step1).end().build();
    }

    @Bean
    public AsyncTaskExecutor taskExecutor() {
        return new TaskExecutorAdapter(Executors.newVirtualThreadPerTaskExecutor());
    }


}
