package com.karn.javatricks.llm;

import dev.langchain4j.model.openai.OpenAiChatModel;

public class JavaDemo {
    private static final String apiKey = "demo";
    public static void main(String[] args) {
        OpenAiChatModel model = OpenAiChatModel.builder()
                .apiKey(apiKey)
                .modelName("gpt-4o-mini")
                .build();
        String answer = model.chat("Say 'Hello World'");
        System.out.println(answer);
    }

}
