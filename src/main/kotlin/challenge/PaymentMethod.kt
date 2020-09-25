package challenge

interface PaymentMethod {
    fun generate(order: Order): Boolean
}
