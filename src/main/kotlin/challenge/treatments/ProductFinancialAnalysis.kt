package challenge.treatments

import challenge.OrderItem
import challenge.treatments.common.ShippingTreatment

class ProductFinancialAnalysis(val orderItem: OrderItem) {

    fun separate(): ShippingTreatment {
        return when(orderItem.product.entiquable) {
            true -> ProductEntiquableTreatment(orderItem.product)
            false -> ProductUnetiquableTreatment(orderItem.product)
        }
    }
}