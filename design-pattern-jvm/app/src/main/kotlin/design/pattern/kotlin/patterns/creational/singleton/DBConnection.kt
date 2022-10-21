package design.pattern.kotlin.patterns.creational.singleton

class DBConnection private constructor(
    val host: String,
    val port: Number,
    val username: String,
    val password: String
) {

    companion object {
        private var instance: DBConnection? = null
        fun create(host: String, port: Number, username: String, password: String): DBConnection? {
            if (instance == null) {
                instance = DBConnection(host, port, username, password)
                return instance
            }
            return instance
        }
    }
}