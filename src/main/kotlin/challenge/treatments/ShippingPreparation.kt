package challenge.treatments

import challenge.Order
import challenge.treatments.common.ShippingTreatment

class ShippingPreparation(var order: Order) {

    fun prepare() {
        order.items.forEach {
            val shippingTreatment: ShippingTreatment = ProductTreatment(it).separate()
            shippingTreatment.prepare()
        }
    }
}