class UrlMappings {
	static mappings = {
		// Export plugin
		"/export/index"(controller: 'export', action: 'index')

		"/$controller/$action?/$id?(.$format)?" {
			constraints {
				// apply constraints here
			}
		}

		"/"(controller: "home")
		"500"(view: '/error')
	}
}
