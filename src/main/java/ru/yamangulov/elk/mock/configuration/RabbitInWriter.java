package ru.yamangulov.elk.mock.configuration;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
@EnableScheduling
public class RabbitInWriter {
    private final RabbitTemplate rabbitTemplate;

    @Value("${pathToFile}")
    private String pathToFile;

    public RabbitInWriter(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Scheduled(fixedRateString = "10")
    private void writeFileToRabbit() throws IOException {
        Path path = Paths.get(pathToFile.replace("classpath:", "./src/main/resources"));
        String content = Files.readString(path);
        rabbitTemplate.convertAndSend(content);
    }

}
