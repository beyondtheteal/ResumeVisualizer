package beyondtheteal.android.com.resumevisualizer.beyondtheteal.android.com.resumevisualizer.utils;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Utils {
    static final String TAG = "Utils";

    /**
     * Code borrowed from https://stackoverflow.com/a/9544781
     * Opens a file in the assets folder with the specified name and reads it to a String
     *
     * @param filename - do not include the `.md` extension or path
     * @return String - file contents
     */
    public static String getMarkdownFile(Context context, String filename) {
        StringBuilder sbFile = new StringBuilder();

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(context.getAssets().open(filename+".md"), "UTF-8"));

            // do reading, usually loop until end of file reading
            String line;
            while ((line = reader.readLine()) != null) {
                sbFile.append(line).append("\n"); // TODO does it need the line break?
            }
            // TODO Print a message if there are no contents in the file?

        } catch (IOException e) {
            Log.e(TAG, "IO exception while trying to read markdown file");

        } finally {
            // Close the reader
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    Log.i(TAG, "IO exception while closing reader");
                }
            }
        }

        return sbFile.toString();
    }
}
