<h1>Installed Plugins</h1>
<ul>
	<g:each var="plugin" in="${applicationContext.getBean('pluginManager').allPlugins}">
		<li>${plugin.name} - ${plugin.version}</li>
	</g:each>
</ul>
