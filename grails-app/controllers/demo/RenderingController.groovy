package demo

class RenderingController {
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
