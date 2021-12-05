package pl.marchuck.lunchcomposer.data

import java.util.concurrent.TimeUnit

enum class Starch(
    val type: StarchType,
    val minTimeToPrepare: Long,
    val unit: TimeUnit = TimeUnit.MINUTES
) {
    NONE(StarchType.NONE, 0L),
    POTATOES(StarchType.POTATOES, 20L),
    WHITE_RICE(StarchType.RICE, 15L),
    BROWN_RICE(StarchType.RICE, 20L),
    SPAGHETTI(StarchType.PASTA, 12L),
    PENNE(StarchType.PASTA, 12L),
    FUSILLI(StarchType.PASTA, 12L),
    PAPPARDELLE(StarchType.PASTA, 12L),
    TAGLIATELLE(StarchType.PASTA, 12L),
    FARFALLE(StarchType.PASTA, 12L),
    BUCKWHEAT_GROATS(StarchType.GROATS, 20L),
    COUS_COUS(StarchType.GROATS, 5L),
    BULGUR_GROATS(StarchType.GROATS, 15L),
    MILLET(StarchType.GROATS, 10L);
}
