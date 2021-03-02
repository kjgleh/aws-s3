package me.kjgleh.aws.s3.user

import java.util.*

data class UploadIntroRequest(
    val id: String = UUID.randomUUID().toString(),
    val introduce: String = """
        hello~
        my name is kjgleh.
    """.trimIndent()
)
