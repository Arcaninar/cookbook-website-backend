package dev.arcaninar.cookbook.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

import java.net.URI;
import java.net.URISyntaxException;

@Configuration
public class BackblazeConfig {
    private final String endpointUrl;
    private final String accessKey;
    private final String secretKey;

    public BackblazeConfig(@Value("${backblaze.s3.endpoint}") String endpointUrl, @Value("${backblaze.s3.access.key}") String accessKey, @Value("${backblaze.s3.secret.key}") String secretKey) {
        this.endpointUrl = endpointUrl;
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    @Bean
    public S3Client s3Client() throws URISyntaxException {
        return S3Client.builder()
                .region(Region.EU_CENTRAL_1)
                .credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create(
                        accessKey,
                        secretKey
                )))
                .endpointOverride(new URI(endpointUrl))
                .build();
    }
}