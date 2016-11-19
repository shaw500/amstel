package api

import org.junit.Before
import ratpack.test.embed.EmbeddedApp
import ratpack.test.http.TestHttpClient
import web.App
import web.RatpackModule

class ApiTestBase {

    TestHttpClient client

    @Before
    public void setUp() {
        def app = new App(new RatpackModule())
        EmbeddedApp.of { spec ->
            app.configureServer(spec)
        }.test { httpClient ->
            client = httpClient
        }
    }

    public get(String path) {
        client.get(path)
    }
}
