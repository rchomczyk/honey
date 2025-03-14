package dev.shiza.honey.placeholder.evaluator.reflection;

import dev.shiza.honey.placeholder.PlaceholderContext;
import dev.shiza.honey.placeholder.evaluator.PlaceholderEvaluator;
import dev.shiza.honey.placeholder.evaluator.reflection.ReflectivePlaceholderEvaluatorTest.Account;
import dev.shiza.honey.placeholder.evaluator.reflection.ReflectivePlaceholderEvaluatorTest.User;
import dev.shiza.honey.placeholder.resolver.Placeholder;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

import static java.time.Duration.ofSeconds;

final class ReflectivePlaceholderEvaluatorTestUtils {

    static final Duration INVOCATION_TIMEOUT = ofSeconds(5);

    static final String NAME = "John";
    static final String SURNAME = "Doe";

    static final User USER = new User(NAME, SURNAME);
    static final Account ACCOUNT = new Account(1, USER);
    static final PlaceholderContext SYNC_CONTEXT =
        PlaceholderContext.create().withValue("account", ACCOUNT).withValue("user", USER);
    static final PlaceholderContext ASYNC_CONTEXT =
        PlaceholderContext.create()
            .withAsynchronousValue("account", CompletableFuture.completedFuture(ACCOUNT))
            .withAsynchronousValue("user", CompletableFuture.completedFuture(USER));
    static final PlaceholderEvaluator EVALUATOR = new ReflectivePlaceholderEvaluator();

    static Placeholder placeholder(final String expression) {
        return new Placeholder("{{" + expression + "}}", expression);
    }
}
