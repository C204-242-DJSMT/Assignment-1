class Package {
	string id
	Client sender
	reciever location etc can be account holder or not
	Scan for timing null for not scanned
	parent bin

}

class Scan {
	some kind of identifier
	timestamp
}

class Bin {
	static collection
	string id 
	collection<city> destinations
	collection of all packages in the bin
	scan methods for the bin aplies scan to everything inside
	vehicle identifier

}
class City {
	name

}
class Destination {  //This can be combined into the package class itself
	Client - null if non client
	string Address
	string postcode
}

class Client {
	static collection
	string id
	ArrayList<destination> addresses
	access to packages addressed to them
}

class Employee {
	string id
	(enum) role
}

class Driver extends Employee{
	string vehicle id
	some way to get manifest
}

static class DataAdapter {
	static ArrayLists of Packages, clients, cities, bins, employees
	static methods to access them getList, addItem 
}

enum employeeRoles