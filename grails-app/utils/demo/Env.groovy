package demo

import grails.util.*

class Env {
	static String getEnvironmentName() { Environment.getCurrent().getName() }

	static boolean isDevelopment() { GrailsUtil.isDevelopmentEnv() }

	static boolean isDevelopmentOrTest() { isDevelopment() || isTest() }

	static boolean isNotDevelopmentOrTest() { !isDevelopmentOrTest() }

	static boolean isTest() { Environment.current == Environment.TEST }

	static boolean isProduction() { Environment.current == Environment.PRODUCTION }

	static boolean isNotProduction() { !isProduction() }
}
