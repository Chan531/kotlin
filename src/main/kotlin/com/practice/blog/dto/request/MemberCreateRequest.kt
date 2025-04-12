package com.practice.blog.dto.request

import java.time.LocalDate

data class MemberCreateRequest(
    val email: String,
    val password: String,
    val name: String,
    val birth: LocalDate
) {
}