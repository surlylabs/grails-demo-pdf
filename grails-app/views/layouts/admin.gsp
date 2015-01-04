<!DOCTYPE html>
<g:render template="/ifIE" />
<head>
	<g:render template="/meta" />
	<title><g:layoutTitle default="${message(code: 'app.label')}" /></title>
	<g:render template="/icons" />
	<asset:stylesheet src="application.css" />
	<asset:javascript src="application.js" />
	<asset:stylesheet src="admin-index.css" />

	<g:layoutHead />
</head>

<body>
	<div id="grailsLogo" role="banner"><a href="http://grails.org"><asset:image src="grails_logo.png" alt="Grails" /></a></div>
	<g:layoutBody />

	<div class="footer" role="contentinfo"></div>
	<asset:deferredScripts />
</body>
</html>
