package com.practice.blog.service

import com.practice.blog.domain.Member
import com.practice.blog.dto.request.MemberCreateRequest
import com.practice.blog.dto.response.MemberCreateResponse
import com.practice.blog.dto.response.MemberGetResponse
import com.practice.blog.dto.response.MembersGetResponse
import com.practice.blog.repository.MemberRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class MemberService(
    private val memberRepository: MemberRepository
) {

    fun get(id: String): MemberGetResponse {
        val member = findMember(id)
        return MemberGetResponse.from(member)
    }

    fun getAll(): MembersGetResponse {
        val members = memberRepository.findAll()
        return MembersGetResponse.from(members)
    }

    @Transactional
    fun create(request: MemberCreateRequest): MemberCreateResponse {
        val member = Member.of(request.email, request.password, request.name, request.birth)
        val id = memberRepository.save(member).id
        return MemberCreateResponse.from(id!!)
    }

    @Transactional
    fun update(id: String, request: MemberCreateRequest) {
        val member = findMember(id)
        member.update(request.email, request.password, request.name, request.birth)
        memberRepository.save(member)
    }

    @Transactional
    fun delete(id: String) {
        memberRepository.deleteById(id)
    }

    private fun findMember(id: String): Member {
        return memberRepository.findById(id)
            .orElseThrow { IllegalArgumentException("멤버가 존재하지 않습니다.") }
    }
}