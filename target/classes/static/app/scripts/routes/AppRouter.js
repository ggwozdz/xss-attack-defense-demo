/*global Static, Backbone*/

Static.Routers = Static.Routers || {};

(function () {
    'use strict';

    Static.Routers.AppRouter = Backbone.Router.extend({
        routes: {
            "#documents"     : "showDocuments",
            '*path':  'defaultRoute'
        },


        showDocuments : function(){
            if(this.currView){
                this.currView.close();
            }

            this.currView = new Static.Views.DocumentListView().render();
        },

        defaultRoute : function(){
            this.showDocuments();
        }
    });

})();
