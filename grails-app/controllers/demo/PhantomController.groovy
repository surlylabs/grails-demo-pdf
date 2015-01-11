package demo

class PhantomController {
	/**
	 * Generate PDF report
	 *
	 * phantomjs ./scripts/phantomjs/rasterize.js <url of report> <name>.pdf <url of footer>
	 *
	 * http://stackoverflow.com/questions/12403817/phantomjs-pipe-input/17286691#17286691
	 * Need this link in rasterize.js:
	 *   page.render('/dev/stdout', { format: 'pdf' });
	 *
	 * Files to review:
	 *   - /grails-app/conf/Config.groovy
	 *   - /src/javascript/phantomjs/rasterizestdout.js
	 *   - /views/layouts/pdf.gsp
	 */
	def generate(String name, String url) {
		log.debug "Generate report: ${name} / ${url}"
		String reportName = name ? name : 'report'
		String serverURL = grailsApplication.config.grails.serverURL
		String phantomPDFScript = grailsApplication.config.grails.phantomPDFScript
		def reportUrl = url ? url : "${serverURL}/phantom/index"
		log.debug "Report URL: ${reportUrl}"

		def footImageUrl = "${serverURL}/images/footer.png"

		// List cmd = ['/usr/local/bin/phantomjs', "${phantomPDFScript}", "${reportUrl}/${reportName}", "${reportName}.pdf", "${footImageUrl}"]
		List cmd = ['/usr/local/bin/phantomjs', "${phantomPDFScript}", "${reportUrl}", "${reportName}.pdf", "${footImageUrl}"]
		log.debug "PhantomJS command: ${cmd}"

		// https://grails.org/FAQ#Q: Can I use the render method to return a binary file to the client?
		response.contentType = "application/pdf"

		// http://groovy.codehaus.org/Process+Management
		def process = cmd.execute()
		process.consumeProcessOutput(response.outputStream, response.outputStream)
		// http://groovy.codehaus.org/groovy-jdk/java/lang/Process.html
		process.waitForOrKill(20000) // 20 secs
		log.debug 'Report out:\n' + response.outputStream

		response.outputStream.flush()
	}

	def index() {
		// Data to pass to view layer from a Grails controller or service.
		def columns = [['string', 'Task'], ['number', 'Hours per Day']]
		def data = [['Work', 11], ['Eat', 2], ['Commute', 2], ['Watch TV', 2], ['Sleep', 7]]

		render view: "index", model: [columns: columns, data: data]
	}
}
