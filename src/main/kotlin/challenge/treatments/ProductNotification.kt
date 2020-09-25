package challenge.treatments

import challenge.Product

interface ProductNotification {
    fun send(product: Product)
}
