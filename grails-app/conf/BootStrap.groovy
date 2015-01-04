import demo.Env

class BootStrap {
	def grailsApplication

	def init = { servletContext ->
		log.debug "****************** STARTING BootStrap.init ******************"
		logEnvInfo()
		log.debug "****************** COMPLETE BootStrap.init ******************"
	}

	/**
	 * Helper
	 */
	private void logEnvInfo() {
		def flatConfig = grailsApplication.getFlatConfig()
		log.debug '-----------'
		log.debug "Application: ${flatConfig['grails.project.groupId']}"
		log.debug "Environment: ${Env.getEnvironmentName()}"
		log.debug "Configruation: ${flatConfig}"
		log.debug '-----------'
	}

	def destroy = {
		log.debug 'Destroy all humans!'
	}
}
