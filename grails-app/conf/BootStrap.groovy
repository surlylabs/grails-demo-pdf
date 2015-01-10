import demo.Env
import demo.Contact

class BootStrap {
	def grailsApplication

	def init = { servletContext ->
		log.debug "****************** STARTING BootStrap.init ******************"
		logEnvInfo()

		if (Env.isDevelopment()) {
			buildDomains()
		}
		log.debug "****************** COMPLETE BootStrap.init ******************"
	}

	private void buildDomains() {
		def robert = new Contact(
			name: 'Robert Tables Sr',
			company: 'Surly Labs',
			title: 'Owner',
			address: '404 Lost Ave',
			suite: "302",
			city: "Minneapolis",
			state: 'MN',
			zipCode: '55401',
			email: 'robert@surlylabs.com',
			phone: '612-555-1212'
		)
		saveDomain(robert)

		def bobby = new Contact(
			name: 'Little Bobby Tables',
			company: 'Surly Labs',
			title: 'Slacker',
			address: '404 Lost Ave',
			suite: "302",
			city: "Minneapolis",
			state: 'MN',
			zipCode: '55401',
			email: 'bobby@surlylabs.com',
			phone: '612-555-1213'
		)
		saveDomain(bobby)
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

	private def saveDomain(domain, validate = true) {
		if (!domain?.save(validate: validate)) {
			log.error "### ERROR Creating ${domain?.class?.name} in BootStrap ###"
			domain?.errors?.allErrors?.each {
				log.error "\tError: ${it}"
			}
		}

		domain
	}

	def destroy = {
		log.debug 'Destroy all humans!'
	}
}
