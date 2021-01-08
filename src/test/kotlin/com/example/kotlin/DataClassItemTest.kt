package com.example.kotlin

import com.example.kotlin.item.DataClassItem
import com.example.kotlin.item.DataClassItemRepository
import com.example.kotlin.item.interaction.DataClassInteraction
import com.example.kotlin.item.interaction.DataClassInteractionRepository
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
class DataClassItemTest {

    @Inject
    lateinit var dataClassItemRepository: DataClassItemRepository

    @Inject
    lateinit var dataClassInteractionRepository: DataClassInteractionRepository

    @Test
    fun testJson(){
        val item = DataClassItem()
        item.uid = "test uid"
        dataClassItemRepository.save(item)

        val interaction = DataClassInteraction()
        interaction.dataClassItem = item
        interaction.properties = mapOf("test" to "val")

        dataClassInteractionRepository.save(interaction)

//        This fails
        val interactions = dataClassInteractionRepository.findByDataClassItemUid(item.uid)
        assert(interaction in interactions)

    }
}