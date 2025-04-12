package com.practice.blog.dto.response

import com.practice.blog.domain.Member

data class MemberCreateResponse(
    val id: String
) {

    companion object{
        fun from(id: String): MemberCreateResponse{
            return MemberCreateResponse(id)
        }
    }
}