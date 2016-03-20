angular.module('companyApp')
    .factory('DepartmentsService', ['$http', function($http) {
        var service = {};
        service.list = function() {
            return $http.get('http://localhost:8989/departments');
        };
        service.create = function(department) {
            return $http.post('http://localhost:8989/departments', department);
        };
        service.getById = function(departmentId) {
            return $http.get('http://localhost:8989/departments/' + departmentId);
        };
        return service;
}])
