/*global Static, Backbone*/

Static.Routers = Static.Routers || {};

(function () {
    'use strict';

    Static.Routers.AppRouter = Backbone.Router.extend({
        routes: {
            "documents/*path" : "showDocumentDetails",
            "documents"        : "showDocuments",
            '*path'            :  'defaultRoute'
        },


        showDocuments : function(){
            console.log('showDocuments');
            this.switchView(new Static.Views.DocumentListView({}).render());
        },

        showDocumentDetails : function(title){
            console.log('showDocumentDetails');
            this.switchView(new Static.Views.DocumentDetailsView({query:title}).render());
        },

        defaultRoute : function(){
            this.showDocuments();
        },

        switchView: function(newView){
            if(this.currView){
                this.currView.close();
            }
            this.currView = newView;
        }
    });

})();
