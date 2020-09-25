package challenge

import challenge.treatments.FinancialBenefits
import challenge.treatments.ShippingPreparation
import java.util.*
import kotlin.collections.ArrayList

class Order(val customer: Customer, val address: Address) {
    val items: MutableList<OrderItem> = ArrayList<OrderItem>()
    val totalAmount
        get() = items.sumByDouble { it.total }
    var closedAt: Date? = null
    var payment: Payment? = null

    fun addProduct(product: Product, quantity: Int) {
        var productAlreadyAdded = items.any { it.product == product }
        if (productAlreadyAdded)
            throw Exception("The product have already been added. Change the amount if you want more.")
        items.add(OrderItem(product, quantity))
    }
    fun getList(): List<OrderItem> = this.items
}