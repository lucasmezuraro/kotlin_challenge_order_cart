package challenge.treatments

import challenge.Product

class SiteSubscription(val product: Product) : ProductActionTreatment {

    override fun execute(): Boolean {
        if (activate()) {
            notification(EmailSiteSubscribeNotification())
            return true
        }else {
            println("Product do not activated")
            return false
        }
    }

    fun activate(): Boolean {
        return true
    }

    fun notification(productNotification: ProductNotification) {
        productNotification.send(product)
    }

}
