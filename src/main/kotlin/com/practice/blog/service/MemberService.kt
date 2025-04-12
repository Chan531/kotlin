package com.practice.blog.service

import com.practice.blog.domain.Member
import com.practice.blog.dto.request.MemberCreateRequest
import com.practice.blog.dto.response.MemberCreateResponse
import com.practice.blog.repository.MemberRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class MemberService(
    val memberRepository: MemberRepository
) {

    @Transactional
    fun create(dto: MemberCreateRequest) : MemberCreateResponse {
        val member = Member.of(dto.email, dto.password, dto.name, dto.birth)
        val id = memberRepository.save(member).id
        return MemberCreateResponse.from(id!!)
    }
}