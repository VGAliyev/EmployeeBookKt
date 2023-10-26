package employee

data class Employee(var fullName: String, var salary: Float, var department: Int) {
    companion object {
        private var counter = 0
    }
    private val id: Int

    init {
        counter++
        id = counter
    }

    fun getId() = id
}