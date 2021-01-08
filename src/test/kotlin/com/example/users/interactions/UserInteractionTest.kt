package com.example.users.interactions

import com.example.users.User
import com.example.users.UserRepository
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
class UserInteractionTest {


    @Inject
    lateinit var userInteractionRepository: UserInteractionRepository

    @Inject
    lateinit var userRepository: UserRepository

    @Test
    fun testAnnotationMetadata() {
        val user = User(0, "test uid")
        val savedUser = userRepository.save(user)

        val userInteraction = UserInteraction(0, savedUser, mapOf(
            "test" to "val"
        ))
        val savedInteraction = userInteractionRepository.save(userInteraction)

        val interactions = userInteractionRepository.findByUserUid("test uid")

        assert(savedInteraction in interactions)

        val userNullInteraction = userRepository.getByUid("test uid")
        assert(userNullInteraction!!.userInteractions == null)
        val userWithInteractions = userRepository.findByUid("test uid")
        assert(userWithInteractions!!.userInteractions!!.size == 1)

    }
}