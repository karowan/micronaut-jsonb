package com.example.java

import com.example.item.Item
import com.example.item.ItemRepository
import com.example.item.interaction.Interaction
import com.example.item.interaction.InteractionRepository
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
class ItemTest {

    @Inject
    lateinit var itemRepository: ItemRepository

    @Inject
    lateinit var interactionRepository: InteractionRepository

    @Test
    fun testJson(){
        val item = Item()
        item.uid = "test uid"
        itemRepository.save(item)

        val interaction = Interaction()
        interaction.item = item
        interaction.properties = mapOf("test" to "val")

        interactionRepository.save(interaction)

//        This works
        val interactions = interactionRepository.findByItemUid(item.uid)
        assert(interaction in interactions)

    }
}