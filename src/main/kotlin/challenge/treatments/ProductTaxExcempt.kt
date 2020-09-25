package challenge.treatments

import challenge.Product
import challenge.ProductType

class ProductTaxExcempt(var product: Product): ProductLabelTreatment {
    override fun generate(): Boolean {
        if (product.type == ProductType.BOOK) return true
        else return false
    }
}