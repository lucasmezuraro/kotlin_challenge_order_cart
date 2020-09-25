package challenge

import java.util.*

data class Payment(val order: Order, val paymentMethod: PaymentMethod) {
    val paidAt get() = Date()
    val authorizationNumber get() = paidAt.time
    val amount get() = order.totalAmount
    val invoice get() = Invoice(order)

    fun execute(): Boolean {
        if (paymentMethod.generate(order)) return true
        else return false
    }
}

