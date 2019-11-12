var app = angular.module("attendanceManager", []);

app.controller('EmployeeController', function ($scope, $http) {
    var object = [];

    $http({
        method: 'GET',
        url:    '/employees/get-all'
    }).then(function (response) {
        $scope.employees = response.data.employees;
        $scope.weekendattendances = response.data.weekendattendances;
        $scope.workdayattendances = response.data.workdayattendances;

        $scope.obj = response;
    });

    $scope.getEmployee = function ($employee) {
        $http({
            method: 'GET',
            url:    '/employees/get/' + $employee.id
        }).then(function (response) {
            $scope.emp = response.data;
        });
    };

    $scope.saveEmployee = function () {
        $scope.obj = $scope.emp;
        $http({
            method: 'POST',
            url:    '/employees/save',
            data:   $scope.emp
        }).then(function (response) {
            $scope.employees = response.data.employees;
            $scope.weekendattendances = response.data.weekendattendances;
            $scope.workdayattendances = response.data.workdayattendances;
            $scope.emp = {};
        });
    };

    $scope.updateEmployee = function () {
        $http({
            method: 'POST',
            url:    '/employees/update',
            data:   $scope.emp
        }).then(function (response) {
            $scope.employees = response.data.employees;
            $scope.weekendattendances = response.data.weekendattendances;
            $scope.workdayattendances = response.data.workdayattendances;
            $scope.emp = {};
        });
    };

    $scope.deleteEmployee = function ($employee) {
        $http({
            method: "GET",
            url:    "/employees/delete/" + $employee.id
        }).then(function (response) {
            $scope.employees = response.data.employees;
            $scope.weekendattendances = response.data.weekendattendances;
            $scope.workdayattendances = response.data.workdayattendances;
            $scope.emp = {};
        });
    };
});

app.controller('WeekendattendanceController', function ($scope, $http) {
    $http({
        method: 'GET',
        url:    '/boards/get-all'
    }).then(function (response) {
        $scope.weekendattendances = response.data;
    });

    $scope.getWeekendattendance = function ($weekend) {
        $http({
            method: 'GET',
            url:    '/boards/get/' + $weekend.id
        }).then(function (response) {
            $scope.weekend = response.data;
        });
    };

    $scope.saveBoard = function () {
        $http({
            method: 'POST',
            url:    '/boards/save',
            data:   $scope.weekend
        }).then(function (response) {
            $scope.weekendattendances = response.data;
            $scope.weekend = {};
        });
    };

    $scope.updateBoard = function () {
        $http({
            method: 'POST',
            url:    '/boards/update',
            data:   $scope.weekend
        }).then(function (response) {
            $scope.weekendattendances = response.data;
            $scope.weekend = {};
        });
    };

    // $scope.deleteWeekendattendance = function ($weekend) {
    //     $http({
    //         method: "GET",
    //         url:    "/boards/delete/" + $board.id,
    //     }).then(function (response) {
    //         $scope.employee = response.data;
    //         $scope.brd = {};
    //     });
    // };
});
//
// app.controller('DepartmentController', function ($scope, $http) {
//     $http({
//         method: 'GET',
//         url:    '/departments/get-all'
//     }).then(function (response) {
//         $scope.departments = response.data;
//     });
//
//     $scope.getDepartment = function ($department) {
//         $http({
//             method: 'GET',
//             url:    '/departments/get/' + $department.id
//         }).then(function (response) {
//             $scope.drp = response.data;
//         });
//     };
//
//     $scope.saveDepartment = function () {
//         $http({
//             method: 'POST',
//             url:    '/departments/save',
//             data:   $scope.drp
//         }).then(function (response) {
//             $scope.departments = response.data;
//             $scope.drp = {};
//         });
//     };
//
//     $scope.updateDepartment = function () {
//         $http({
//             method: 'POST',
//             url:    '/departments/update',
//             data:   $scope.drp
//         }).then(function (response) {
//             $scope.departments = response.data;
//             $scope.drp = {};
//         });
//     };
//
//     $scope.deleteDepartment = function ($department) {
//         $http({
//             method: "GET",
//             url:    "/departments/delete/" + $department.id
//         }).then(function (response) {
//             $scope.departments = response.data;
//             $scope.drp = {};
//         });
//     };
// });
