package challenge.treatments

import challenge.Product
import challenge.ProductType
import challenge.treatments.common.BenefitsChecking

class ProductEntiquableTreatment(var product: Product): ProductEntiquable, BenefitsChecking {

    override fun implement(productLabelTreatment: ProductLabelTreatment): Boolean {
        return productLabelTreatment.generate()
    }

    override fun prepare(): Boolean {
        return when(product.type) {
            ProductType.PHYSICAL -> implement(ProductPhysicalLabel(product))
            else -> false
        }
    }

    override fun grant(): Boolean {
       return when(product.taxExcempt) {
            true -> implement(ProductTaxExcempt(product))
            else -> false
       }
    }
}