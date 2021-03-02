package me.kjgleh.aws.s3.common

import com.amazonaws.services.s3.AmazonS3
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.net.URL

@Component
class S3Uploader(
    @Value("\${cloud.aws.s3.bucket}")
    private val bucket: String,
    private val amazonS3: AmazonS3
) {

    fun upload(key: String, content: String): URL {
        amazonS3.putObject(bucket, key, content)
        return amazonS3.getUrl(bucket, key)
    }
}