package me.kjgleh.aws.s3.config

import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.testcontainers.containers.localstack.LocalStackContainer
import org.testcontainers.utility.DockerImageName

@Configuration
@Profile("local")
class S3LocalConfig {

    private val localstackImage =
        DockerImageName.parse("localstack/localstack:latest")

    @Bean(initMethod = "start", destroyMethod = "stop")
    fun localStackContainer(): LocalStackContainer {
        return LocalStackContainer(localstackImage).withServices(
            LocalStackContainer.Service.S3
        )
    }

    @Bean
    fun amazonS3(localStackContainer: LocalStackContainer): AmazonS3 {
        return AmazonS3ClientBuilder.standard()
            .withEndpointConfiguration(
                localStackContainer.getEndpointConfiguration(
                    LocalStackContainer.Service.S3
                )
            )
            .withCredentials(localStackContainer.defaultCredentialsProvider)
            .build()
    }
}