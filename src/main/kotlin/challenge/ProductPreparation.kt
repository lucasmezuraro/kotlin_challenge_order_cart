package challenge

class ProductPreparation(val order: Order) {

    fun prepare() {
        order.items.forEach {
            when(it.product.entiquable) {
                true -> 1
                false -> 0
            }
        }
    }
}