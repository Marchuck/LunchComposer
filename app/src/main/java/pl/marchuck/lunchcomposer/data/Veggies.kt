package pl.marchuck.lunchcomposer.data

import java.util.*

enum class Veggies {
    NONE,
    BOILED_CARROT,
    BOILED_BROCCOLI,
    GRATED_CARROT,
    CHINESE_CABBAGE_SALAD,
    PICKLES,
    CELERY,
    RED_CABBAGE,
    SAUERKRAUT,
    CUCUMBER_SALAD,
    COLESLAW,
    BEETS,
    JAR_SALAD;

    companion object {
        @JvmStatic
        fun generate(random: Random): Veggies {
            val values = values()
            return values[random.nextInt(values.size)]
        }
    }
}