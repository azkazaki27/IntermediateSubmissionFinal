package com.azka.intermediatesubmissionfinal.utils

import org.junit.Assert
import org.junit.Test
import java.time.format.DateTimeParseException
import java.time.zone.ZoneRulesException

class DateFormaterTest {
    @Test
    fun `given correct ISO 8601 format then should format correctly`() {
        val currentDate = "2022-02-02T10:10:10Z"
        Assert.assertEquals("02 Feb 2022 | 17:10", DateFormater.formatDate(currentDate, "Asia/Jakarta"))
        Assert.assertEquals("02 Feb 2022 | 18:10", DateFormater.formatDate(currentDate, "Asia/Makassar"))
        Assert.assertEquals("02 Feb 2022 | 19:10", DateFormater.formatDate(currentDate, "Asia/Jayapura"))
    }

    @Test
    fun `given wrong ISO 8601 format then should throw error`() {
        val wrongFormat = "2022-02-02T10:10"
        Assert.assertThrows(DateTimeParseException::class.java) {
            DateFormater.formatDate(wrongFormat, "Asia/Jakarta")
        }
    }

    @Test
    fun `given invalid timezone then should throw error`() {
        val wrongFormat = "2022-02-02T10:10:10Z"
        Assert.assertThrows(ZoneRulesException::class.java) {
            DateFormater.formatDate(wrongFormat, "Asia/Bandung")
        }
    }
}