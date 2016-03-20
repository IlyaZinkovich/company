angular.module('companyApp').controller('DepartmentsController', ['$scope', 'DepartmentsService', function($scope, departmentsService) {

    $scope.departments = null;

    departmentsService.list().then(function(success) {
        $scope.departments = success.data;
    }, function(error) {
        console.error(error);
    });

    $scope.create = function() {
        $scope.departmentToCreate.parentDepartmentId = $scope.departmentToCreate.parentDepartment.departmentId;
        delete $scope.departmentToCreate.parentDepartment;
        departmentsService.create($scope.departmentToCreate).then(function(success) {
            $scope.departments.push($scope.departmentToCreate);
        }, function(error) {
            console.error(error);
        });
    };

    $scope.update = function(dept) {
        dept.name = "lalala"
    };
    
    $scope.getDepartmentById = function(departmentId) {
        departmentsService.getById(departmentId).then(function(success) {
            $scope.department = success.data;
        }, function(error) {
            console.error(error);
        })
    };

}]);
