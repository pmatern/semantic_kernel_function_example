package net.jaguarandi.semantickernel.example;

import com.microsoft.semantickernel.semanticfunctions.annotations.DefineKernelFunction;
import com.microsoft.semantickernel.semanticfunctions.annotations.KernelFunctionParameter;

public class MitigationPlugin {
    @DefineKernelFunction(name = "terminateSession", description = "Terminate a session", returnType = "string")
    public String terminateSession(@KernelFunctionParameter(name = "sessionId", description = "The id of the session") String sessionId) {
        System.out.println(sessionId + " terminated");
        return sessionId;
    }

    @DefineKernelFunction(name = "applyLimitations", description = "Apply limitations to an account", returnType = "string")
    public String applyLimitations(@KernelFunctionParameter(name = "accountId", description = "The id of the account") String accountId) {
        System.out.println(accountId + " limited");
        return accountId;
    }

    @DefineKernelFunction(name = "suspendAccount", description = "Suspend an account", returnType = "string")
    public String suspendAccount(@KernelFunctionParameter(name = "accountId", description = "The id of the account") String accountId) {
        System.out.println(accountId + " suspended");
        return accountId;
    }
}
