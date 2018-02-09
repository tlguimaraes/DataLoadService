angular.module('demo', [])
.controller('DataLoadController', function($scope, $http) {
    $http.get('http://localhost:8080/loadservice').
        then(function(response) {
            $scope.loadservice = response.data;
        });
});