package pl.marchuck.lunchcomposer.generator

import pl.marchuck.lunchcomposer.data.StarchType
import pl.marchuck.lunchcomposer.data.Starch
import java.util.*

class StarchGenerator(private val random: Random) {

    fun generate(genericStarch: StarchType): StarchResult {
        return generate(genericStarch, EnumSet.noneOf(Starch::class.java))
    }

    fun generate(genericStarch: StarchType, excluded: EnumSet<Starch>): StarchResult {
        val possibleStarches = Starch.values().filter { starch ->
            starch.type == genericStarch && !excluded.contains(starch)
        }
        return if (possibleStarches.isEmpty()) {
            StarchResult.Failure(genericStarch, excluded)
        } else {
            StarchResult.Success(possibleStarches.getRandomly())
        }
    }

    private fun <T> List<T>.getRandomly(): T {
        return get(random.nextInt(size))
    }
}

sealed class StarchResult {
    data class Success(val starch: Starch) : StarchResult()
    data class Failure(
        val genericStarch: StarchType,
        val excluded: EnumSet<Starch>
    ) : StarchResult()
}