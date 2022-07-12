import org.junit.Test

import org.junit.Assert.*

@Suppress("KotlinConstantConditions")
class MainKtTest {



    @Test
    fun commissionMaestro() {
        val maestro = "Maestro"

        val result = commission(maestro, 100, 150)
        assertEquals(0, result)

    }

    @Test
    fun commissionMaestroMax() {
        val maestro = "Maestro"

        val result = commission(maestro, 100_000_00, 89_000_00)
        assertEquals(536000, result)

    }

    @Test
    fun commissionMaster() {
        val master = "MasterCard"

        val result = commission(master, 0,0)
        assertEquals(2000, result)

    }

    @Test
    fun commissionMasterMax() {
        val master = "MasterCard"

        val result = commission(master, 100_000_00, 74000_00)
        assertEquals(446000, result)

    }

    @Test
    fun commissionVisa() {
        val visa = "VISA"

        val result = commission(visa, 100_000_00, 74000_00)
        assertEquals(55500, result)

    }

    @Test
    fun commissionVisaFix() {
        val visa = "VISA"

        val result = commission(visa, 100_0, 0)
        assertEquals(3500, result)

    }

    @Test
    fun commissionVk() {
        val vk = "vk"

        val result = commission(vk, 100_000_00, 76_000_00)
        assertEquals(0,  result)

    }


    @Test
    fun rubConvert() {
        val cent = 100_78

        val result = rubConvert(cent)
        assertEquals("100 руб 78 коп", result)
    }
}