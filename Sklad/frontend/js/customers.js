let SkladApp = angular.module('SkladApp', [])
let linkRes = 'http://localhost:8080/api/customers/'

SkladApp.controller('SkladController', function ($scope, $http){

    $http.get(linkRes + '/all')
      .then(resp => {
          $scope.skladItemList = resp.data
        },
        resp => {
          console.error(resp)
        })

    $scope.name = ''
    $scope.contactName = ''
    $scope.inn = ''
    $scope.kpp = ''
    $scope.telephone = ''
    $scope.address = ''

    $scope.create = function() {

      $http.post(linkRes, {
        name: $scope.name,
        contactName: $scope.contactName,
        inn: $scope.inn,
        kpp: $scope.kpp,
        telephone: $scope.telephone,
        address: $scope.address

      })
        .then(resp => {
          $scope.skladItemList.push(resp.data)
            $scope.name = ''
            $scope.contactName = ''
            $scope.inn = ''
            $scope.kpp = ''
            $scope.telephone = ''
            $scope.address = ''

        },
          resp => {
           console.error(resp)
          })

      $scope.name = ''
      $scope.contactName = ''
      $scope.inn = ''
      $scope.kpp = ''
      $scope.telephone = ''
      $scope.address = ''
    }

    $scope.delete = function(item) {

      $http.delete(linkRes + item.id)
        .then(resp => {
          let pos = $scope.skladItemList.map(item => item.id).indexOf(item.id);
          $scope.skladItemList.splice(pos, 1);
        },
        resp => {
         console.error(resp)
        })
    }
})

//
//SkladApp.controller('SkladController', function ($scope){
//  $scope.skladItemList = [
//    {id: 1, name: 'HDD', date: '2020-01-01', count: 10, units: 'Штук', price: 5000},
//    {id: 2, name: 'FDD', date: '2020-05-15', count: 11, units: 'Штук', price: 15},
//    {id: 3, name: 'DVD', date: '2020-07-22', count: 17, units: 'Штук', price: 50}
//    ]
//
//    $scope.name = ''
//    $scope.date = ''
//    $scope.count = ''
//    $scope.units = ''
//    $scope.price = ''
//    $scope.counter = 4;
//
//    let options = {
//      day: 'numeric',
//      month: 'numeric',
//      year: 'numeric'
//    }
//
//    $scope.create = function() {
//      $scope.skladItemList.push({
//        id: $scope.counter++,
//        name: $scope.name,
////        date: $scope.date.toLocaleString().substring(0, 10),
////        date: $scope.date.toLocaleString('ru', options).substring(0, 10),
//        date: $scope.date.toISOString().substring(0, 10),
//        count: $scope.count,
//        units: $scope.units,
//        price: $scope.price
//      })
//      $scope.name = ''
//      $scope.date = ''
//      $scope.count = ''
//      $scope.units = ''
//      $scope.price = ''
//    }
//
//    $scope.delete = function(item) {
//      let pos = $scope.skladItemList.map(item => item.id).indexOf(item.id);
//      $scope.skladItemList.splice(pos, 1)
//    }
//})