package com.practice.blog.dto.response

import com.practice.blog.domain.Member
import java.time.LocalDate

data class MemberGetResponse(
    val email: String,
    val name: String,
    val birth: LocalDate
) {

    companion object {
        fun from(member: Member): MemberGetResponse {
            return MemberGetResponse(
                email = member.email,
                name = member.name,
                birth = member.birth
            )
        }
    }
}