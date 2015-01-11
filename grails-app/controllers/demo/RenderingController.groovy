package demo

class RenderingController {
	// Rendering
	def pdfRenderingService

	/**
	 * Rendering Plugin
	 * http://grails.org/plugin/rendering
	 *
	 * Watch out for (need well-form xhtml):
	 *   Error 500: Internal Server Error
	 *   URI: /demo-pdf/rendering/index
	 *   Class: org.xml.sax.SAXParseException
	 *   Message: The markup in the document following the root element must be well-formed.
	 *
	 * Files to review:
	 *  - /grails-app/conf/BuildConfig.groovy
	 */
	def index(String fileName) {
		// Data to pass from a Grails controller or service to view layer.
		def columns = [['string', 'Task'], ['number', 'Hours per Day']]
		def data = [['Work', 11], ['Eat', 2], ['Commute', 2], ['Watch TV', 2], ['Sleep', 7]]

		if (fileName) {
			renderPdf(template: "/admin/hero", model: [columns: columns, data: data], filename: fileName)
		} else {
			renderPdf(template: "/admin/hero", model: [columns: columns, data: data])
		}
	}

	/**
	 * File already on the server, just render it!
	 */
	def pdfFile(String fileName, String filePath, boolean download) {
		def name = fileName ?: 'based-ona-true-story.pdf'
		def path = filePath ?: './etc/pdf'
		if (download) {
			render(file: new File("${path}/${name}"), fileName: "${name}", contentType: 'application/pdf')
		} else {
			render(file: new File("${path}/${name}"), contentType: 'application/pdf')
		}
	}
}
