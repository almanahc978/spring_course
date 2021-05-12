angular.module('app',['ngResource']).controller('ProductController', function($resource){
    let vm = this;
    let Product = $resource('api/products/:productId') //$resource opakowuje $http, zwraca konstruktor -- WZORZEC ACTIVE RECORD
    vm.product = new Product();

    function refreshData(){
        vm.products = Product.query(function success(data, headres){
            console.log('Pobrano dane: ' + data);            
        }, function error(response){
            console.log(response.status)
        });
    }

    vm.addProduct = function(product){
        console.log(vm.product.__proto__);
        vm.product.$save(function(data){
            refreshData();
            vm.product = new Product();
        });
    }

    vm.loadData = function(id){
        vm.details = Product.get({productId:id});
    }

    vm.appName = 'Product Manager';
    refreshData();
});

