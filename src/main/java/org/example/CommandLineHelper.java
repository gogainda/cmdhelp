package org.example;

import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class CommandLineHelper {
    private static final String API_KEY = System.getenv("API_KEY");
    private static final String API_URL = "https://api.openai.com/v1/chat/completions";

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Usage: java -jar app.jar \"your command here\"");
            return;
        }

        String userInput = String.join(" ", args);
        System.out.println(userInput);
        String userMessageContent = String.format("Provide examples of how to use the command line for the " +
                        "following use case: [%s] and operation system: [%s]",
                userInput,
                System.getProperty("os.name"));

        OkHttpClient client = new OkHttpClient();

        JSONObject chatMessage = new JSONObject();
        chatMessage.put("role", "user");
        chatMessage.put("content", userMessageContent);

        JSONArray messagesArray = new JSONArray();
        messagesArray.put(chatMessage);

        JSONObject payload = new JSONObject();
        payload.put("model", "gpt-4o");
        payload.put("temperature", 0.7);
        payload.put("messages", messagesArray);

        RequestBody body = RequestBody.create(
                MediaType.get("application/json"),
                payload.toString()
        );

        Request request = new Request.Builder()
                .url(API_URL)
                .post(body)
                .addHeader("Authorization", "Bearer " + API_KEY)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            String responseBody = response.body().string();
            JSONObject jsonResponse = new JSONObject(responseBody);
            String commandExamples = jsonResponse.getJSONArray("choices")
                    .getJSONObject(0)
                    .getJSONObject("message")
                    .getString("content");
            System.out.println(commandExamples.trim());
        }
    }
}
