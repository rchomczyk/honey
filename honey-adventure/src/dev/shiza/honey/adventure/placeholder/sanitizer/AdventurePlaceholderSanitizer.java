package dev.shiza.honey.adventure.placeholder.sanitizer;

import dev.shiza.honey.placeholder.evaluator.PlaceholderEvaluator.EvaluatedPlaceholder;
import dev.shiza.honey.placeholder.sanitizer.PlaceholderSanitizer;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class is responsible for placeholder sanitization, which is the process of transforming
 * placeholder key from honey's format to match the MiniMessage's format.
 */
final class AdventurePlaceholderSanitizer implements PlaceholderSanitizer {

    private static final Pattern PLACEHOLDER_PATTERN = Pattern.compile("\\{\\{(.*?)}}");
    private static final String MINI_MESSAGE_PLACEHOLDER_FORMAT = "<%s>";

    AdventurePlaceholderSanitizer() {}

    @Override
    public String getSanitizedContent(
        final String content, final List<SanitizedPlaceholder> placeholders) {
        return processPlaceholders(content, MINI_MESSAGE_PLACEHOLDER_FORMAT);
    }

    @Override
    public SanitizedPlaceholder getSanitizedPlaceholder(final EvaluatedPlaceholder placeholder) {
        final String sanitized = processPlaceholders(placeholder.placeholder().key(), "%s");
        return new SanitizedPlaceholder(
            sanitized, placeholder.placeholder().key(), placeholder.evaluatedValue());
    }

    private String processPlaceholders(final String input, final String format) {
        final Matcher matcher = PLACEHOLDER_PATTERN.matcher(input);
        final StringBuilder result = new StringBuilder();
        while (matcher.find()) {
            matcher.appendReplacement(result, format.formatted(matcher.group(1)));
        }
        matcher.appendTail(result);
        return result.toString();
    }
}
