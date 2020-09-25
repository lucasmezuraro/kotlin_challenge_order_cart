package challenge.treatments

import challenge.treatments.common.ShippingTreatment

interface ProductUnetiquable: ShippingTreatment {
    fun resolve(productActionTreatment: ProductActionTreatment): Boolean
}