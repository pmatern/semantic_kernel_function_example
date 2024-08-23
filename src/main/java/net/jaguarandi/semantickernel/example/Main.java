package net.jaguarandi.semantickernel.example;

import com.azure.ai.openai.OpenAIClientBuilder;
import com.microsoft.semantickernel.Kernel;
import com.microsoft.semantickernel.aiservices.openai.chatcompletion.OpenAIChatCompletion;
import com.microsoft.semantickernel.contextvariables.ContextVariableTypes;
import com.microsoft.semantickernel.orchestration.ToolCallBehavior;
import com.microsoft.semantickernel.plugin.KernelPluginFactory;
import com.microsoft.semantickernel.semanticfunctions.KernelFunctionFromPrompt;
import com.microsoft.semantickernel.services.chatcompletion.ChatCompletionService;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        var client = new OpenAIClientBuilder()
                .endpoint("http://127.0.0.1:4000")
                .buildAsyncClient();
        var service = OpenAIChatCompletion.builder()
                .withOpenAIAsyncClient(client)
                .withModelId("phi3")
                .build();

        var plugin = KernelPluginFactory.createFromObject(new MitigationPlugin(), "ApplyMitigation");

        var kernel = Kernel.builder()
                .withAIService(ChatCompletionService.class, service)
                .withPlugin(plugin)
                .build();

        var function = KernelFunctionFromPrompt.builder()
                .withTemplate("Suspend the account with id: " + UUID.randomUUID())
                .build();

        var result = kernel.invokeAsync(function)
                .withToolCallBehavior(ToolCallBehavior.allowAllKernelFunctions(true))
                .withResultType(ContextVariableTypes.getGlobalVariableTypeForClass(String.class))
                .block();

        if (result != null) {
            System.out.println("Result is " + result.getResult());
        }
    }
}
