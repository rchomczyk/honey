package dev.shiza.honey.placeholder.sanitizer;

import dev.shiza.honey.placeholder.evaluator.PlaceholderEvaluator.EvaluatedPlaceholder;
import java.util.ArrayList;
import java.util.List;

public interface PlaceholderSanitizer {

    default List<SanitizedPlaceholder> getSanitizedPlaceholders(
        final List<EvaluatedPlaceholder> placeholders) {
        final List<SanitizedPlaceholder> sanitizedPlaceholders = new ArrayList<>();
        for (final EvaluatedPlaceholder placeholder : placeholders) {
            sanitizedPlaceholders.add(getSanitizedPlaceholder(placeholder));
        }
        return sanitizedPlaceholders;
    }

    record SanitizedPlaceholder(String key, String expression, Object evaluatedValue) {}
    String getSanitizedContent(final String content, final List<SanitizedPlaceholder> placeholders);
    SanitizedPlaceholder getSanitizedPlaceholder(final EvaluatedPlaceholder placeholder);
}
