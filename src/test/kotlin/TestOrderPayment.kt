import challenge.*
import challenge.treatments.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class TestOrderPayment {

    @Test
   fun `Order must exists`() {
        val order = Order(Customer(), Address())
        assertNotNull(order)
    }

    @Test
    fun `Order must add itens`() {
        val order = Order(Customer(), Address())
        val product1 = Product("Chair", ProductType.PHYSICAL, true, false, 25.00)
        val product2 = Product("Music", ProductType.DIGITAL, false, false, 20.00)
        order.addProduct(product1, 2)
        order.addProduct(product2, 3)
        assertEquals(2, order.items.count())
    }

    @Test
    fun `Order must add itens and check the total amount`() {
        val order = Order(Customer(), Address())
        val product1 = Product("Chair", ProductType.PHYSICAL, true, false, 25.00)
        val product2 = Product("Music", ProductType.DIGITAL, false, false, 20.00)
        order.addProduct(product1, 2)
        order.addProduct(product2, 3)
        assertEquals(110.00, order.totalAmount)
    }

    @Test
    fun `Order must add itens and pay`() {
        val order = Order(Customer(), Address())
        val product1 = Product("Chair", ProductType.PHYSICAL, true, false, 25.00)
        val product2 = Product("Music", ProductType.DIGITAL, false, false, 20.00)
        order.addProduct(product1, 2)
        order.addProduct(product2, 3)
        assertEquals(true, OrderPayment(order, CreditCard("0192309120300")).pay())
    }

    @Test
    fun `Digital item must has discount`() {
        val order = Order(Customer(), Address())
        val product2 = Product("Film", ProductType.DIGITAL, false, false, 20.00)
        order.addProduct(product2, 1)
        FinancialBenefits(order).check()
        var payment = OrderPayment(order, CreditCard("0192309120300"))
        payment.pay()
        assertEquals(18.00, payment.paid?.amount)
    }

    @Test
    fun `Book item must has tax excempt`() {
        val order = Order(Customer(), Address())
        val product2 = Product("Book", ProductType.BOOK, false, true, 20.00)
        order.addProduct(product2, 1)
        val exception = ProductEntiquableTreatment(product2).implement(ProductTaxExcempt(product2))
        assertEquals(true, exception)
    }

    @Test
    fun `Digital item must be activated`() {
        val order = Order(Customer(), Address())
        val product2 = Product("Film", ProductType.MEMBERSHIP, false, false, 20.00)
        order.addProduct(product2, 1)
        val subscription = ProductUnetiquableTreatment(product2).resolve(SiteSubscription(product2))
        assertEquals(true, subscription)
    }

}