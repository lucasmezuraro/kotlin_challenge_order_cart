package challenge.treatments

import challenge.Product

class EmailMediaDeliveryNotification : EmailNotification {
    override fun send(product: Product) {
        println("Product "+ product.name + " is delivered")
    }
}
