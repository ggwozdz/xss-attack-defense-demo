/*global Static, Backbone*/

Static.Routers = Static.Routers || {};

(function () {
    'use strict';

    Static.Routers.AppRouter = Backbone.Router.extend({
        routes: {
            "xss-persistent" : "persistent", // #help
            "xss-dom" :        "dom", // #help
          },

          persistent:function(){
            console.log('persistent');
            if(this.currView){
                this.currView.close();
            }

            this.currView = new Static.Views.XSSPersistentView().render();
          },

           dom:function(){
              console.log('dom');
              if(this.currView){
                  this.currView.close();
              }

              this.currView = new Static.Views.XSSDomView().render();
            },

          help: function() {

          },

          search: function(query, page) {

          }
    });

})();
