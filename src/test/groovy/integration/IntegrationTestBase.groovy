package integration

import amstel.AmstelModule
import com.google.inject.Guice
import com.google.inject.Injector
import org.junit.Before

class IntegrationTestBase {

    Injector injector

    @Before
    public void setUp() {
        injector = Guice.createInjector(new AmstelModule())
    }

    public <T> T get(Class<T> clazz) {
        injector.getInstance(clazz)
    }
}
