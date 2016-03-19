
object KotlinOption {
    fun toInt(input: String): Int? {
        try {
            return input.trim().toInt()
        } catch(ex: NumberFormatException) {
            return null
        }
    }

    fun printInt(someInt: Int?) = when(someInt) {
        is Int -> println(someInt)
        else -> println("That didn't work.")
    }

    fun getAddressLine2(customer: KotlinCustomer?) = customer?.shippingAddress?.addressLine2 ?: ""

    fun nullManipulation() {
        var foo: String = "Foo"
        //Note: Compile error of next line - won't allow a null unless defined Int?
        //foo = null

        foo += " Bar"
        println(foo.toLowerCase())

        var bar: String? = "Baz"
        bar = bar?.plus(" Foo")
        println(bar?.toLowerCase() ?: "default value")

        bar = null
        bar = bar?.plus(" Foo")
        println(bar?.toLowerCase() ?: "default value")
    }
}

data class KotlinCustomer(var shippingAddress: KotlinAddress?)
data class KotlinAddress(val name: String, val addressLine1: String, var addressLine2: String?)
