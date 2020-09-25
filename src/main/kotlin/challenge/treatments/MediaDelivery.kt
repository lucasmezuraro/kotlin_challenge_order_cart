package challenge.treatments

import challenge.Product

class MediaDelivery (val product: Product) : ProductActionTreatment {

    override fun execute(): Boolean {
        if (available()) {
            notification(EmailMediaDeliveryNotification())
            return true
        }else {
            println("Product do not sent")
            return false
        }
    }

    fun available(): Boolean {
        return true
    }

    fun notification(productNotification: ProductNotification) {
        productNotification.send(product)
    }

}