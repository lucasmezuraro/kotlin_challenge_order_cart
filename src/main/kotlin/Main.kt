import challenge.*
import challenge.treatments.FinancialBenefits
import challenge.treatments.ShippingPreparation

fun main(args : Array<String>) {
    val shirt = Product("Flowered t-shirt", ProductType.PHYSICAL, true, false, 35.00)
    val netflix = Product("Familiar plan", ProductType.MEMBERSHIP, false, false, 29.90)
    val book = Product("The Hitchhiker's Guide to the Galaxy",ProductType.BOOK, true, true, 120.00)
    val music = Product("Stairway to Heaven", ProductType.DIGITAL, false, false, 5.00)

    val order = Order(Customer(), Address())

    order.addProduct(shirt, 2)
    order.addProduct(netflix, 1)
    order.addProduct(book, 1)
    order.addProduct(music, 1)

    FinancialBenefits(order).check()
    OrderPayment(order,CreditCard("43567890-987654367")).pay()
    ShippingPreparation(order).prepare()
}