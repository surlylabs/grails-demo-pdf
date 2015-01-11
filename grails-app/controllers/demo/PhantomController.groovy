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
	 * Required to run:
	 * > brew update
	 * > brew install phantomjs
	 *
	 * Files to review:
	 *   - /grails-app/conf/Config.groovy
	 *   - /src/javascript/phantomjs/rasterizestdout.js
	 *   - /views/layouts/pdf.gsp
	 */
	def generate(String name, String url, boolean download, int waitForMillis) {
		String reportName = name ? name : 'report'
		int millis = (waitForMillis &&  waitForMillis < 0) ? waitForMillis : 20000 // 20 secs
		String serverURL = grailsApplication.config.grails.serverURL
		String phantomPDFScript = grailsApplication.config.grails.phantomPDFScript
		def reportUrl = url ? url : "${serverURL}/phantom/index"
		log.debug "Generate report: ${name} / ${reportUrl}"

		def footImageUrl = "${serverURL}/images/footer.png"

		List cmd = ['/usr/local/bin/phantomjs', "${phantomPDFScript}", "${reportUrl}", "${reportName}.pdf", "${footImageUrl}"]
		// http://mrhaki.blogspot.com/2011/04/groovy-goodness-new-dollar-slashy.html - $/string/$ syntax a.k.a slashy string syntax
		// def cmd = $/phantomjs ${phantomPDFScript} ${reportUrl} ${reportName}.pdf ${footImageUrl}/$
		log.debug "PhantomJS command: ${cmd}"

		// https://grails.org/FAQ#Q: Can I use the render method to return a binary file to the client?
		response.contentType = "application/pdf"
		if (download) {
			response.setHeader "Content-disposition", "attachment; filename=${"${reportName}.pdf"}"
		}

		if (millis) {
			// http://groovy.codehaus.org/Process+Management
			def process = cmd.execute()
			process.consumeProcessOutput(response.outputStream, response.outputStream)
			// http://groovy.codehaus.org/groovy-jdk/java/lang/Process.html
			process.waitForOrKill(millis)
			log.debug 'Report out:\n' + response.outputStream
		} else {
			def process = cmd.execute()
			response.outputStream << process.in
		}

		response.outputStream.flush()
	}

	def index() {
		// Data to pass from a Grails controller or service to view layer.
		def columns = [['string', 'Task'], ['number', 'Hours per Day']]
		def data = [['Work', 11], ['Eat', 2], ['Commute', 2], ['Watch TV', 2], ['Sleep', 7]]

		render view: "index", model: [columns: columns, data: data]
	}
}
