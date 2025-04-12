package com.practice.blog.repository

import com.practice.blog.domain.Member
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface MemberRepository : MongoRepository<Member, String> {
}