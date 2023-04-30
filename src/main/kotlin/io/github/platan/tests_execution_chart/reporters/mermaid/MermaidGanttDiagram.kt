package io.github.platan.tests_execution_chart.reporters.mermaid

data class MermaidGanttDiagram(
    val dateFormat: String,
    val axisFormat: String,
    val entries: List<Entry>
) {
    sealed interface Entry
    data class Section(val name: String) : Entry
    data class Task(val name: String, val type: String?, val start: Long, val end: Long) : Entry
    data class Milestone(val name: String, val timestamp: Long) : Entry

    class MermaidGanttDiagramBuilder {
        private val entries: MutableList<Entry> = mutableListOf()

        fun addTask(name: String, type: String?, start: Long, end: Long) {
            entries.add(Task(name, type, start, end))
        }

        fun addSection(name: String) {
            entries.add(Section(name))
        }

        fun addMilestone(name: String, timestamp: Long) {
            entries.add(Milestone(name, timestamp))
        }

        fun build(dateFormat: String, axisFormat: String): MermaidGanttDiagram {
            return MermaidGanttDiagram(
                dateFormat,
                axisFormat,
                entries.toList()
            )
        }
    }
}
