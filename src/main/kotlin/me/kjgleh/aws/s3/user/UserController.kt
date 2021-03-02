package me.kjgleh.aws.s3.user

import me.kjgleh.aws.s3.common.S3Uploader
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URL

@RestController
class UserController(
    private val s3Uploader: S3Uploader
) {

    @PostMapping("/api/users/upload-intro")
    fun uploadIntro(): ResponseEntity<URL> {
        val uploadIntroRequest = UploadIntroRequest()
        val s3Response = s3Uploader.upload(
            uploadIntroRequest.id,
            uploadIntroRequest.introduce
        )

        return ResponseEntity.status(HttpStatus.CREATED).body(s3Response)
    }
}