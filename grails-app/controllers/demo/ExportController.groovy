package demo

class ExportController {
	def exportService

	/**
	 * Export Plugin
	 * http://grails.org/plugin/export
	 * [Section] To make the plugin work you need to add some code to your controller.
	 */
	def index() {
		log.debug "Extension: ${params.extension}"
		log.debug "Format: ${params.format}"
		if (!params.format) { // Url Mapping is stripping it off.
			params.format = params.extension
		}
		log.debug "Extension after: ${params.extension}"
		log.debug "Format after: ${params.format}"
		if (params.format) {
			response.contentType = grailsApplication.config.grails.mime.types[params.format]
			response.setHeader("Content-disposition", "attachment; filename=index.${params.format}")
			exportService.export(params.format, response.outputStream, [new Contact([name: 'Robert Tables', email: 'robert@surlylabs.com'])], [:], [:])
		} else {
			log.debug 'Format not found'
			def columns, data = dummyData()

			render view: "index", model: [columns: columns, data: data]
		}
	}

	/**
	 * Helper
	 */
	private List dummyData() {
		def columns = [['string', 'Task'], ['number', 'Hours per Day']]
		def data = [['Work', 11], ['Eat', 2], ['Commute', 2], ['Watch TV', 2], ['Sleep', 7]]
		[columns, data]
	}
}
