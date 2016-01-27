package se.racemates.maven;

import java.io.*;

class StreamGobbler extends Thread {

    private final InputStream inputStream;
    private final PrintStream printStream;

    public StreamGobbler(
            final InputStream inputStream,
            final PrintStream printStream
    ) {
        this.inputStream = inputStream;
        this.printStream = printStream;
    }

    public void run() {
        try (
                final BufferedReader bufferedReader =
                        new BufferedReader(new InputStreamReader(this.inputStream))
        ) {
            String line;
            do {
                line = bufferedReader.readLine();
                this.printStream.println(line);
            } while (line != null);
        } catch (final IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }
}