package io.github.platan.tests_execution_chart

import kotlinx.serialization.Serializable

@Serializable
data class TimedTestResult(
    var className: String?,
    var testName: String,
    var startTime: Long,
    var endTime: Long,
    var resultType: String
) {
    val durationMs: Long
        get() = this.endTime - this.startTime
}
