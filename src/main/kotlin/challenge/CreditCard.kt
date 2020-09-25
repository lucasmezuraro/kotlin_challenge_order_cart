package challenge

data class CreditCard(val number: String) : PaymentMethod {
    override fun generate(order: Order): Boolean {
        println("Order paid: "+ order.totalAmount)
        return true
    }

}