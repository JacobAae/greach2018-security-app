

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'net.grydeske.todo.TodoUser'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'net.grydeske.todo.TodoUserTodoRole'
grails.plugin.springsecurity.authority.className = 'net.grydeske.todo.TodoRole'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/',                        access: ['permitAll']],
	[pattern: '/contactList/**',          access: ['permitAll']],
	[pattern: '/credit/**',               access: ['permitAll']],
	[pattern: '/dns/**',                  access: ['permitAll']],
	[pattern: '/helper/**',               access: ['permitAll']],
	[pattern: '/honorRoll/**',            access: ['permitAll']],
	[pattern: '/login/**',                access: ['permitAll']],
	[pattern: '/otherLogin/**',           access: ['permitAll']],
	[pattern: '/pirateNameGenerator/**',  access: ['permitAll']],
	[pattern: '/securityFail/**',         access: ['permitAll']],
	[pattern: '/webshop/**',              access: ['permitAll']],
	[pattern: '/error',                   access: ['permitAll']],
	[pattern: '/index',                   access: ['permitAll']],
	[pattern: '/index.gsp',               access: ['permitAll']],
	[pattern: '/shutdown',                access: ['permitAll']],
	[pattern: '/assets/**',               access: ['permitAll']],
	[pattern: '/**/js/**',                access: ['permitAll']],
	[pattern: '/**/css/**',               access: ['permitAll']],
	[pattern: '/**/images/**',            access: ['permitAll']],
	[pattern: '/**/favicon.ico',          access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]

grails.plugin.springsecurity.logout.postOnly = false
grails.plugin.springsecurity.successHandler.defaultTargetUrl = '/todoItem/index'
