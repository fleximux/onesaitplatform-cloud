/*
 * Copyright 2018 StreamSets Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

angular
  .module('dataCollectorApp.home')
  .controller('DownloadEdgePipelinesModalInstanceController', ["$scope", "$modalInstance", "api", function ($scope, $modalInstance, api) {
    angular.extend($scope, {
      common: {
        errors: []
      },
      downloadModel : {
        edgeHttpUrl: 'http://localhost:18633',
        proxy: 'server'
      },
      operationInProgress: false,

      downloadPipelines : function() {
        $scope.operationInProgress = true;
        api.pipelineAgent.downloadPipelinesFromEdge($scope.downloadModel.edgeHttpUrl)
          .then(
            function() {
              $modalInstance.close();
            },
            function (res) {
              $scope.operationInProgress = false;
              $scope.common.errors = [res.data];
            }
          );
      },

      cancel : function () {
        $modalInstance.close();
      }
    });
  }]);
