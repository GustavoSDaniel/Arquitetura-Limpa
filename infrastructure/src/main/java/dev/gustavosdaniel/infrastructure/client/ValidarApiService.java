package dev.gustavosdaniel.infrastructure.client;

import dev.gustavosdaniel.infrastructure.client.dto.ValidarApiResponse;
import org.springframework.stereotype.Service;

@Service
public class ValidarApiService {

    private ValidarApiClient validarApiClient;

    public ValidarApiService(ValidarApiClient validarApiClient) {
        this.validarApiClient = validarApiClient;
    }

    public ValidarApiResponse validarApiResponse() {

        try {
            return validarApiClient.validar();
        } catch (Exception e) {
            return null;
        }
    }
}
