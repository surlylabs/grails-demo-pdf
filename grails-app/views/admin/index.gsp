<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="admin" />
	<title><g:message code="app.label" /> &mdash; <g:message code="admin.label" /></title>
	%{--<export:resource />--}%
</head>

<body>
	<nav></nav>

	<div id="status" role="complementary">
		<g:render template="appStatus" />
		<g:render template="plugins" />
	</div>

	<div id="page-body" role="main">
		<h1><g:message code="app.label" /> &mdash; <g:message code="admin.label" /></h1>
		<g:render template="controllers" />
		%{--TODO--}%
		%{--<hr />--}%
		%{--<h2>Export Plugin: [Exports domain attributes; ex Group, Evaluation, Profile]</h2>--}%
		%{--<export:formats formats="['csv', 'pdf', 'xml']" />--}%
		%{--<hr />--}%
		%{--<g:render template="chartsGoogle" model="[columns: columns, data: data]" />--}%
		%{--<g:link action="indexRenderPdf">PDF</g:link> | <g:link action="indexRenderPdfFile">PDF File</g:link>--}%
		%{--<hr />--}%
		%{--<g:render template="chartsD3" />--}%
	</div>
</body>
</html>
