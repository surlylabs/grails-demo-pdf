<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="admin" />
	<title><g:message code="app.label" /> &mdash; <g:message code="admin.label" /></title>
</head>

<body>
	<nav></nav>

	<div id="status" role="complementary">
		<g:render template="appStatus" />
		<g:render template="plugins" />
	</div>

	<div id="page-body" role="main">
		<h1><g:message code="app.label" /> &mdash; <g:message code="admin.label" /></h1>
		<g:render template="hero" />
		<g:render template="controllers" />
	</div>
</body>
</html>
