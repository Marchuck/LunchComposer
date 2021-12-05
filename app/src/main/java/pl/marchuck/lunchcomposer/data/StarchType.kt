package pl.marchuck.lunchcomposer.data

import java.util.*

enum class StarchType {
    NONE,
    RICE,
    POTATOES,
    PASTA,
    GROATS;

    companion object {
        @JvmStatic
        fun generate(random: Random): StarchType {
            return values()[random.nextInt(values().size)]
        }
    }
}
