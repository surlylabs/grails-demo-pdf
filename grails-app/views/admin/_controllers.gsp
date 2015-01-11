<div id="controller-list" role="navigation">
	<h2>Available Controllers:</h2>
	<ul>
		<g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName }}">
			<li class="controller"><g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link></li>
		</g:each>
	</ul>
</div>
