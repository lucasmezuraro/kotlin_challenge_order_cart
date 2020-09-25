package challenge.treatments

import challenge.OrderItem
import challenge.treatments.common.BenefitsChecking
import challenge.treatments.common.ShippingTreatment

class ProductTreatment(val orderItem: OrderItem) {

    fun verify(): BenefitsChecking {
        return when(orderItem.product.entiquable) {
            true -> ProductEntiquableTreatment(orderItem.product)
            false -> ProductUnetiquableTreatment(orderItem.product)
        }
    }

    fun separate(): ShippingTreatment {
       return when(orderItem.product.entiquable) {
            true -> ProductEntiquableTreatment(orderItem.product)
            false -> ProductUnetiquableTreatment(orderItem.product)
        }
    }
}