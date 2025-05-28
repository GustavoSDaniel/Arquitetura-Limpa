package dev.gustavosdaniel.infrastructure.client;

import dev.gustavosdaniel.infrastructure.client.dto.ValidarApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "ValidarApiClient", url = "${client.url}") // ANOTAÇÃO PARA RECEBER UM API EXTERNA "client.url" ESTÁ NO POM
public interface ValidarApiClient {

    @GetMapping
    ValidarApiResponse validar();
}
