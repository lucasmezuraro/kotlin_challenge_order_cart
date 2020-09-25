package challenge.treatments

import challenge.Product

class DiscountTenPercent(var product: Product) : ProductActionTreatment {
    override fun execute(): Boolean {
        product.price = product.price * 0.9
        return true
    }
}
