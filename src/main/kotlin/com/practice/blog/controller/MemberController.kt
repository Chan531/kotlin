package com.practice.blog.controller

import com.practice.blog.dto.request.MemberCreateRequest
import com.practice.blog.dto.response.MemberCreateResponse
import com.practice.blog.service.MemberService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/members")
class MemberController(
    val memberService: MemberService
) {

    @GetMapping("/health")
    fun healthCheck(): String {
        return "ok"
    }

    @PostMapping
    fun create(@RequestBody dto: MemberCreateRequest): ResponseEntity<MemberCreateResponse> {
        val response = memberService.create(dto);
        return ResponseEntity.ok(response)
    }
}