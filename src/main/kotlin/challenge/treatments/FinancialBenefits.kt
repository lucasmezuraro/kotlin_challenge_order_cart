package challenge.treatments

import challenge.Order
import challenge.treatments.common.BenefitsChecking

class FinancialBenefits(val order: Order) {

    fun check() {
        order.items.forEach {
            val benefitsChecking: BenefitsChecking = ProductTreatment(it).verify()
            benefitsChecking.grant()
        }
    }
}
