package challenge.treatments

import challenge.*
import challenge.treatments.common.BenefitsChecking

class ProductUnetiquableTreatment(var product: Product) : ProductUnetiquable, BenefitsChecking {
    override fun resolve(productActionTreatment: ProductActionTreatment): Boolean {
        return productActionTreatment.execute()
    }

    override fun grant(): Boolean {
        return when(product.type) {
            ProductType.DIGITAL -> resolve(DiscountTenPercent(product))
            else -> false
        }
    }

    override fun prepare(): Boolean {
        return when(product.type) {
            ProductType.MEMBERSHIP -> resolve(SiteSubscription(product))
            ProductType.DIGITAL -> resolve(MediaDelivery(product))
            else -> false
        }
    }


}