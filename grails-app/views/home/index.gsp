<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="main" />
	<title><g:message code="app.label" /> - Demo PDF Generation</title>
</head>

<body>
	<h3>Demo PDF Generation</h3>
	<div>
		<g:link controller="phantom">View Report</g:link><br />
		<g:link controller="phantom" action="generate" params="[waitForMillis: 2000]">Generate Report PDF with PhantomJS</g:link>
	</div>
	<br />
	<hr />
	<br />

	<h3>Pull existing file from server</h3>
	<div>
		<g:link controller="rendering" action="pdfFile" params="[fileName: 'based-on-a-true-story.pdf']">Render file already on server</g:link>
	</div>
	<br />
	<hr />
	<br />

	<h3>Export Plugin: [Exports domain attributes: ex Contact]</h3>
	<export:formats formats="['csv', 'pdf', 'xml']" controller="export" action="index" />
</body>
</html>
