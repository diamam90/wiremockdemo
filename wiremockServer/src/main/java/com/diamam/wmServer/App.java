package com.diamam.wmServer;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.stubbing.StubMapping;

public class App {

    public static void main(String[] args) {
        WireMockServer server = new WireMockServer(8000);
        server.start();
        WireMock.configureFor(8000);
        StubMapping usersStub = WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/users"))
                .willReturn(WireMock.aResponse()
                .withBody("YOU'RE WELCOME")
                .withStatus(201)));
        server.addStubMapping(usersStub);
    }
}
