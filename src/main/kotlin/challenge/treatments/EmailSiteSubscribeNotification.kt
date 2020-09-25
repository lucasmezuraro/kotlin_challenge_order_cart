package challenge.treatments

import challenge.Product

class EmailSiteSubscribeNotification : EmailNotification {
    override fun send(product: Product) {
        println("Product "+ product.name + " is activated")
    }
}
