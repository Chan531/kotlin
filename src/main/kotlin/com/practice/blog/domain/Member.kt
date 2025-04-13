package com.practice.blog.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate

@Document(collection = "members")
class Member(
    @Id
    val id: String? = null,
    var email: String,
    var password: String,
    var name: String,
    var birth: LocalDate
) {

    companion object {
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

    fun update(email: String, password: String, name: String, birth: LocalDate) {
        this.email = email
        this.password = password
        this.name = name
        this.birth = birth
    }
}