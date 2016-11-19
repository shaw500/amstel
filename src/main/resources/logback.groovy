import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.ConsoleAppender

appender('console', ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = "[%-5level] %d{HH:mm:ss.SSS} %logger - %msg%n"
    }
}

root(DEBUG, ['console'])

logger('io.netty', INFO, ['console'])