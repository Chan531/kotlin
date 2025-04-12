package com.practice.blog.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate

@Document(collection = "members")
class Member(
    @Id
    val id: String? = null,
    val email: String,
    val password: String,
    val name: String,
    val birth: LocalDate
) {

    companion object{
        fun of(
            email: String,
            password: String,
            name: String,
            birth: LocalDate
        ): Member {
            return Member(
                email = email,
                password = password,
                name = name,
                birth = birth
            )
        }
    }
}