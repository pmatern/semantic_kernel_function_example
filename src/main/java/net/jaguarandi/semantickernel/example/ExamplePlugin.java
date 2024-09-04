package net.jaguarandi.semantickernel.example;

import com.microsoft.semantickernel.semanticfunctions.annotations.DefineKernelFunction;
import com.microsoft.semantickernel.semanticfunctions.annotations.KernelFunctionParameter;

public class ExamplePlugin {

    @DefineKernelFunction(name = "suspendAccount", description = "Suspend an account", returnType = "string")
    public String suspendAccount(@KernelFunctionParameter(name = "accountId", description = "The id of the account") String accountId) {
        System.out.println(accountId + " suspended");
        return accountId;
    }
}
