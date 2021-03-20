package net.ddns.mcnoip.packutil;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Packutil Logger
 */
public class PackUtilLogger {
    private static final Logger LOGGER = LogManager.getLogger("PackUtil");

    public static void debug(String message, Object... args) {
	LOGGER.debug(message, args);
    }

    public static void info(String message, Object... args) {
	LOGGER.info(message, args);
    }

    public static void warn(String message, Object... args) {
	LOGGER.warn(message, args);
    }

    public static void error(String message, Object... args) {
	LOGGER.error(message, args);
    }

    public static void fatal(String message, Object... args) {
	LOGGER.fatal(message, args);
    }

}
