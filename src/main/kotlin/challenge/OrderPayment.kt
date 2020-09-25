package challenge

import challenge.treatments.FinancialBenefits
import challenge.treatments.ShippingPreparation

class OrderPayment(val order: Order, val paymentMethod: PaymentMethod) {
    var paid: Payment? = null
    fun pay(): Boolean {
        if (order.payment != null)
            throw Exception("order is paid!")
        if (order.items.count() == 0)
            throw Exception("Empty order can not be paid!")

        val payment = Payment(order, paymentMethod)
        paid = payment
        order.payment = payment
        return payment.execute()
    }
}