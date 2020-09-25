package challenge.treatments

import challenge.treatments.common.ShippingTreatment

interface ProductEntiquable: ShippingTreatment {
    fun implement(productPhysicalTreatment: ProductLabelTreatment): Boolean
}