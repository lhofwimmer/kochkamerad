package at.lhofwimmer.composetemplate.data.local

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.InputStream
import java.io.OutputStream

class ExampleSerializer : Serializer<Example> {
    private val moshi: Moshi by lazy {
        Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
    }

    private val adapter: JsonAdapter<Example> by lazy {
        moshi.adapter(Example::class.java)
    }

    override val defaultValue: Example = Example()

    override suspend fun readFrom(input: InputStream): Example {
        try {
            return withContext(Dispatchers.IO) {
                @Suppress("BlockingMethodInNonBlockingContext")
                adapter.fromJson(input.bufferedReader().use { it.readText() }) ?: defaultValue
            }
        } catch (exception: JsonDataException) {
            throw CorruptionException("Cannot read user_settings proto.", exception)
        }
    }

    override suspend fun writeTo(t: Example, output: OutputStream) {
        withContext(Dispatchers.IO) {
            @Suppress("BlockingMethodInNonBlockingContext")
            output.write(adapter.toJson(t).toByteArray())
        }
    }
}

data class Example(
    val name: String? = null,
    val id: Int? = null
)