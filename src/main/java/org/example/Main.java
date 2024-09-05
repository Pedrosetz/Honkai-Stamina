package org.example;

public class Main {
    public static void main(String[] args)  {
        try {
            Request req = new Request();
            String jsonResponse = req.sendRequest();
            ApiResponse apiResponse = req.parseResponse(jsonResponse);

            int currentStamina = apiResponse.getData().getStamina();
            int maxStamina = apiResponse.getData().getMax_stamina();
            int staminaRecoverTime = apiResponse.getData().getStaminaRecoverTime();

            int hours = staminaRecoverTime / 3600;
            int minutes = (staminaRecoverTime % 3600) / 60;
            int seconds = staminaRecoverTime % 60;

            String timeFormatted = String.format("%02d:%02d:%02d", hours, minutes, seconds);

            String message = String.format("Stamina Atual: %d\nStamina Máxima: %d\nTempo de Recuperação da Stamina: %s", currentStamina, maxStamina, timeFormatted);

            Request.sendToWebhook(message);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
