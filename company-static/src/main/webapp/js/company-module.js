angular.module('companyApp', ['ngResource'])
	.controller('DepartmentController', ['DepartmentService', function(departmentService) {
		var self = this;

		self.departments = function() {
			return departmentService.list();
		}

		self.create = function() {
			departmentService.create({id : 4, name : self.department.name});
		};
		self.update = function(dept) {
			dept.name = "lalala"
		};
		self.getDepartmentById = function(departmentId) {
			departmentService.getById(departmentId);
		};

	}])
	.factory('DepartmentService', [function() {
		var departments = [
			{id : 1, name : 'Cobalt Maintenance'},
			{id : 2, name : 'TRI-CPL'},
			{id : 3, name : 'FS Maintenance'}
		];
		return {
			list: function() {
				return departments;
			},
			create: function(department) {
				departments.push(department);
			},
			getById: function(id) {
				departments.push(department);
			}
		};
	}])
	//.factory('ProjectService', ['$resource', function($resource) {
	//	return $resource('/api/project/:id');
	//}]);


/*
OO-style of service definition

function DepartmentService() {
	var departments = [
		{id : 1, name : 'Cobalt Maintenance'},
		{id : 2, name : 'TRI-CPL'},
		{id : 3, name : 'FS Maintenance'}
	];
	this.list = function() {
		return departments;
	};
	this.create = function(department) {
		departments.push(department);
	};
}

Provider may be uses to define a service
*/
