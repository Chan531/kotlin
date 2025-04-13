package com.practice.blog.dto.response

import com.practice.blog.domain.Member

data class MembersGetResponse(
    val members: List<MemberGetResponse>
) {

    companion object {
        fun from(members: List<Member>): MembersGetResponse {
            return MembersGetResponse(
                members = members.stream()
                    .map { MemberGetResponse.from(it) }
                    .toList())
        }
    }
}