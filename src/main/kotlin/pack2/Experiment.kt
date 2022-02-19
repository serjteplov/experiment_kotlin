package pack2

import java.time.Instant
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

fun main() {

    val now = LocalDate.now()
    val start = now.atStartOfDay()
        .truncatedTo(ChronoUnit.SECONDS)
        .format(DateTimeFormatter.ISO_DATE_TIME)
    val end = now.atStartOfDay().plusDays(1).minusSeconds(1)
        .truncatedTo(ChronoUnit.SECONDS)
        .format(DateTimeFormatter.ISO_DATE_TIME)
    println("start = $start")
    println("end = $end")
    println("double = ${"12.1009".toDouble()}")
    val localDate0 = LocalDate.now()
    val localDateMinus1 = LocalDate.now().minusYears(1)
    val localDatePlus1 = LocalDate.now().plusDays(1)
    val localDateList = listOf(localDate0, localDateMinus1, localDatePlus1)
    val resultMin = localDateList.minByOrNull { it }
    println("result = $resultMin")

    val millis = Instant.now().toEpochMilli()
    println("millis = ${millis}")

    val instantNow = Instant.ofEpochMilli(1645171837867).isoFormatted().uppercase().removeSuffix("Z")
    println("instantNow = $instantNow")

}

fun Instant.isoFormatted(): String =
    DateTimeFormatter.ISO_INSTANT
        .format(this.truncatedTo(ChronoUnit.SECONDS))