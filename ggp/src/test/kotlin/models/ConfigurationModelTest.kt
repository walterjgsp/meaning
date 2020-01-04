package models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ConfigurationModelTest {

    @Test
    fun configurationDefaultObjectTest() {
        val configuration = Configuration()
        assertThat(configuration.crossoverRate).isEqualTo(50.0)
        assertThat(configuration.mutationRate).isEqualTo(25.0)
        assertThat(configuration.generations).isEqualTo(100)
        assertThat(configuration.population).isEqualTo(100)
        assertThat(configuration.selectionSize).isEqualTo(5)
    }

    @Test
    fun configurationObjectTest() {
        val configuration = Configuration(
            crossoverRate = 75.0,
            mutationRate = 10.0,
            population = 300,
            generations = 25,
            selectionSize = 3
        )
        assertThat(configuration.crossoverRate).isEqualTo(75.0)
        assertThat(configuration.mutationRate).isEqualTo(10.0)
        assertThat(configuration.generations).isEqualTo(25)
        assertThat(configuration.population).isEqualTo(300)
        assertThat(configuration.selectionSize).isEqualTo(3)
    }
}