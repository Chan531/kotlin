package com.practice.blog.controller

import com.practice.blog.dto.request.MemberCreateRequest
import com.practice.blog.dto.response.MemberCreateResponse
import com.practice.blog.dto.response.MemberGetResponse
import com.practice.blog.dto.response.MembersGetResponse
import com.practice.blog.service.MemberService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/members")
class MemberController(
    val memberService: MemberService
) {

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun get(@PathVariable id: String): MemberGetResponse {
        val response = memberService.get(id);
        return response
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getAll(): MembersGetResponse {
        val response = memberService.getAll()
        return response
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: MemberCreateRequest): MemberCreateResponse {
        val response = memberService.create(request);
        return response
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun update(@PathVariable id: String, @RequestBody request: MemberCreateRequest) {
        memberService.update(id, request)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: String) {
        memberService.delete(id)
    }
}