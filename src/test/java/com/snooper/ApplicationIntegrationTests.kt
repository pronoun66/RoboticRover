package com.snooper

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ApplicationIntegrationTests {
    private val application = Application()

    @Test
    fun `Application happy path`() {
        val result = application.roboticRoverNavigatePlateau(
                """
                    5 5
                    1 2 N
                    LMLMLMLMM
                    3 3 E
                    MMRMMRMRRM
                    """.trimIndent()
        )
        assertEquals("1 3 N\n5 1 E\n", result)
    }

    @Test
    fun `Application should throw OutOfBoundaryException`() {
        val result = application.roboticRoverNavigatePlateau(
                """
                    5 5
                    1 2 W
                    MMMMM
                    """.trimIndent()
        )
        assertEquals("OutOfBoundaryException\n", result)
    }
}