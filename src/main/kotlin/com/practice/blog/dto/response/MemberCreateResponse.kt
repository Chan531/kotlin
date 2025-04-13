package com.practice.blog.dto.response

data class MemberCreateResponse(
    val id: String
) {

    companion object{
        fun from(id: String): MemberCreateResponse{
            return MemberCreateResponse(id)
        }
    }
}