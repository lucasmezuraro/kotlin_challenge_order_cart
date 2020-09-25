package challenge.treatments

import challenge.Product

class ProductPhysicalLabel(var product: Product): ProductLabelTreatment {
     override fun generate(): Boolean {
        println("Physical label setted")
         return true
    }

}