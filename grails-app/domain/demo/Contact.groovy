package demo

class Contact {
	String name
	String company
	String title
	String address
	String suite
	String city
	String state
	String zipCode
	String email
	String phone

	static constraints = {
		name nullable: false, blank: false
		company nullable: true
		title nullable: true
		address nullable: true
		suite nullable: true
		city nullable: true
		state nullable: true
		zipCode nullable: true
		email nullable: true
		phone nullable: true
	}
}
