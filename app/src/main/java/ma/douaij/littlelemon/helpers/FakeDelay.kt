package ma.douaij.littlelemon.helpers

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

suspend fun fakeDelay(): String = withContext(Dispatchers.IO) {
    // Simulate a long-running operation
    delay(1000)
    "Data Loaded!"
}