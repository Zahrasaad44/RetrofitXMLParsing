package com.example.retrofitxmlparsing

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root
import java.io.Serializable


@Root(name = "rss", strict = false)
class Feed: Serializable {
    @field:Element(name = "channel")
    var channel: Channel? = null
}


@Root(name = "channel", strict = false)
class Channel @JvmOverloads constructor(
    @field:ElementList(inline = true)
    var itemList: List<Item>? = null
)


@Root(name = "item", strict = false)
class Item @JvmOverloads constructor(
    @field:Element(name = "title")
    var title: String = "",

    @field:Element(name = "description", required = false)
    var description: String = ""
)

//A JvmOverload can be noticed in the entry class,
//the reason for it is because the simple xml converter library is made to work with empty constructors at first,
//and Kotlin creates a default constructor with all fields in it, which can throw errors.
//
//The JvmOverload tells Kotlin to override the constructor instead of creating its own.




