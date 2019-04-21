package beyondtheteal.android.com.resumevisualizer.beyondtheteal.android.com.resumevisualizer.utils;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.widget.TextView;

import ru.noties.markwon.AbstractMarkwonPlugin;
import ru.noties.markwon.Markwon;
import ru.noties.markwon.core.MarkwonTheme;

/**
 * This is a wrapper class for the Markwon library so that we can set our own markdown
 * theme in one place
 *
 * @see <a href="https://noties.io/Markwon/docs/v3/core/theme.html">Theming in Markwon</a>
 */
public class Markdown {
    public static Markwon markdown;

    public static void applyMarkdown(Context context, TextView textView, String text) {
        if (markdown == null) {
            configureMarkdown(context);
        }
        markdown.setMarkdown(textView, text);
    }

    private static void configureMarkdown(Context context) {
        markdown = Markwon.builder(context)
            .usePlugin(new AbstractMarkwonPlugin() {
                @Override
                public void configureTheme(@NonNull MarkwonTheme.Builder builder) {
                    // FYI Thematic break == horizontal rule
                    builder
                            .headingBreakColor(Color.WHITE) // Remove the line under headings
                            .headingBreakHeight(0)          // Remove the line under headings
                    ;
                }
            })
            .build();
    }

}
