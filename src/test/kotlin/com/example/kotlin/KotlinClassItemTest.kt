package com.example.kotlin

import com.example.kotlin.regular.item.KotlinClassItem
import com.example.kotlin.regular.item.KotlinClassItemRepository
import com.example.kotlin.regular.item.interaction.KotlinClassInteraction
import com.example.kotlin.regular.item.interaction.KotlinClassInteractionRepository
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
class KotlinClassItemTest {

    @Inject
    lateinit var kotlinClassItemRepository: KotlinClassItemRepository

    @Inject
    lateinit var kotlinClassInteractionRepository: KotlinClassInteractionRepository

    @Test
    fun testJson(){
        val item = KotlinClassItem()
        item.uid = "test uid"
        kotlinClassItemRepository.save(item)

        val interaction = KotlinClassInteraction()
        interaction.kotlinClassItem = item
        interaction.properties = mapOf("test" to "val")

        kotlinClassInteractionRepository.save(interaction)

//        This passes
        val interactions = kotlinClassInteractionRepository.findByKotlinClassItemUid(item.uid)
        assert(interaction in interactions)

    }
}