package demo

class ExportController {
	def exportService

	/**
	 * Export Plugin
	 * http://grails.org/plugin/export
	 * [Section] To make the plugin work you need to add some code to your controller.
	 *
	 * Files to review:
	 *  - /grails-app/conf/Bootstrap.groovy
	 *  - /grails-app/conf/BuildConfig.groovy
	 *  - /grails-app/conf/UrlMappings.groovy
	 */
	def index(String extension) {
		log.debug "Extension: ${extension}"
		if (extension) {
			response.contentType = grailsApplication.config.grails.mime.types[extension]
			response.setHeader("Content-disposition", "attachment; filename=index.${extension}")
			exportService.export(extension, response.outputStream, [new Contact([name: 'Robert Tables', email: 'robert@surlylabs.com'])], [:], [:])
		} else {
			render "Extension ${extension} not found."
		}
	}
}
